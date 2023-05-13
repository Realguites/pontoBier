package com.example.pontoBier.pontoBier.model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Map;


@Entity
public class Jogo extends Basic{

    private Map<Jogador, Long> pontuacao;
    private Date data;
    private Double nrCervejas;

    public Jogo(){

    }


    public Map<Jogador, Long> getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Map<Jogador, Long> pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getNrCervejas() {
        return nrCervejas;
    }

    public void setNrCervejas(Double nrCervejas) {
        this.nrCervejas = nrCervejas;
    }
}
