package com.example.pontoBier.pontoBier.service;

import com.example.pontoBier.pontoBier.model.Jogador;
import com.example.pontoBier.pontoBier.repositorie.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
}
