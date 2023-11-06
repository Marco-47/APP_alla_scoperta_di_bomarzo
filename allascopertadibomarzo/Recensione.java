package com.example.allascopertadibomarzo;

public class Recensione {

    private float voto;
    private String nome;
    private String testo;


    public Recensione(float voto, String nome, String testo) {
        this.voto = voto;
        this.nome = nome;
        this.testo = testo;
    }

    public float getVoto(){
        return this.voto;
    }
    public String getNome(){
        return this.nome;
    }
    public String getTesto(){
        return this.testo;
    }

    public void setVoto(float voto){
        this.voto=voto;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setTesto(String testo){ this.testo=testo; }
}



