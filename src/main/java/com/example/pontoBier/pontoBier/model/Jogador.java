package com.example.pontoBier.pontoBier.model;

import javax.persistence.Entity;

@Entity
public class Jogador extends Basic{

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

