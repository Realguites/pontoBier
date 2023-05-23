package com.guilherme.pontoBier.service;

import com.guilherme.pontoBier.model.Jogador;
import com.guilherme.pontoBier.repositorie.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.imgproc.Imgproc;
import java.util.ArrayList;
import java.util.List;




import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;
    public List<Jogador> getAllJogadores() {
        return jogadorRepository.findAll();
    }

    public Jogador createNew(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    public Optional<Jogador> findById(Long id){
        return jogadorRepository.findById(id);
    }

    public void delete(Long id){
        Optional<Jogador> jogador = jogadorRepository.findById(id);
        if (jogador.isPresent()) {
            jogadorRepository.delete(jogador.get());
        } else {
            throw new NullPointerException("Aluno não encontrado com o ID: " + id);
        }
    }

    public void processaImagem(){
        String pathImagem = "/home/guilherme/Pictures/reiDeCopas.png";
        Mat image = Imgcodecs.imread(pathImagem);
        //System.out.println("A carta é rei de copas? " + detectKingOfHearts(pathImagem));
    }

    public static boolean detectKingOfHearts(String imagePath) {
        // Carrega a imagem utilizando o OpenCV
        Mat image = Imgcodecs.imread(imagePath);

        // Carrega o classificador treinado para detectar rostos (ou cartas) em cascata
        CascadeClassifier cascadeClassifier = new CascadeClassifier("haarcascade_playingcard.xml");

        // Detecta as cartas na imagem
        MatOfRect cards = new MatOfRect();
        cascadeClassifier.detectMultiScale(image, cards);

        // Verifica se algum Rei de Copas foi detectado
        for (Rect cardRect : cards.toArray()) {
            // Corta a região da carta da imagem original
            Mat cardImage = image.submat(cardRect);

            // Verifica se a carta é um Rei de Copas
            if (isKingOfHearts(cardImage)) {
                // Desenha um retângulo na imagem original para mostrar a posição da carta
                Imgproc.rectangle(image, cardRect.tl(), cardRect.br(), new Scalar(0, 255, 0), 2);

                // Salva a imagem com o retângulo desenhado
                Imgcodecs.imwrite("result.jpg", image);

                return true;
            }
        }

        return false;
    }

    private static boolean isKingOfHearts(Mat cardImage) {
        // Converta a imagem para o espaço de cores HSV
        Mat hsvImage = new Mat();
        Imgproc.cvtColor(cardImage, hsvImage, Imgproc.COLOR_BGR2HSV);
    
        // Defina os intervalos de cor para o Rei de Copas (vermelho)
        Scalar lowerRed = new Scalar(0, 70, 50);  // Valor mínimo de HSV para o vermelho
        Scalar upperRed = new Scalar(10, 255, 255);  // Valor máximo de HSV para o vermelho
    
        // Crie uma máscara usando os intervalos de cor
        Mat mask = new Mat();
        Core.inRange(hsvImage, lowerRed, upperRed, mask);
    
        // Aplique uma operação de abertura para remover ruídos na máscara
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5, 5));
        Imgproc.morphologyEx(mask, mask, Imgproc.MORPH_OPEN, kernel);
    
        // Encontre os contornos na máscara
        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(mask, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
    
        // Verifique se algum dos contornos corresponde a um objeto em forma de coração
        for (MatOfPoint contour : contours) {
            double contourArea = Imgproc.contourArea(contour);
    
            // Verifique a área mínima do contorno para evitar detecções indesejadas
            if (contourArea > 1000) {
                // Aproxime o contorno para obter um polígono
                MatOfPoint2f approxCurve = new MatOfPoint2f();
                double epsilon = 0.02 * Imgproc.arcLength(new MatOfPoint2f(contour.toArray()), true);
                Imgproc.approxPolyDP(new MatOfPoint2f(contour.toArray()), approxCurve, epsilon, true);
    
                // Verifique se o polígono tem 4 vértices (forma aproximada de um coração)
                if (approxCurve.total() == 4) {
                    return true;  // É um Rei de Copas!
                }
            }
        }
    
        return false;  // Não é um Rei de Copas
    }
}
