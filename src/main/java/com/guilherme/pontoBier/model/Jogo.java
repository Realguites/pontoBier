package com.guilherme.pontoBier.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Map;


@Entity
public class Jogo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Long getId(){
        return this.id;
    }
    //private Map<Jogador, Long> pontuacao;
    private Date data;
    private Double nrCervejas;

    public Jogo(){

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
