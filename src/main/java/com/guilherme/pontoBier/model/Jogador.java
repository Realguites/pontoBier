package com.guilherme.pontoBier.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jogador{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Long getId(){
        return this.id;
    }
    private String nome;
    private String apelido;
    private Double cervejasTomadas;


    public Jogador(){

    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getApelido() {
        return apelido;
    }


    public void setApelido(String apelido) {
        this.apelido = apelido;
    }


    public Double getCervejasTomadas() {
        return cervejasTomadas;
    }


    public void setCervejasTomadas(Double cervejasTomadas) {
        this.cervejasTomadas = cervejasTomadas;
    }



}

