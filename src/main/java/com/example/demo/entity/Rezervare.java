package com.example.demo.entity;

import java.util.Random;

public class Rezervare {
    private Long id_Rezervare;
    private String nume;
    private int rezervari;
    private Long id_Cursa;

    public Rezervare() {

    }


    public Rezervare(Long id_Rezervare, String nume, int rezervari, Long id_Cursa) {
        this.id_Rezervare = id_Rezervare;
        this.nume = nume;
        this.rezervari = rezervari;
        this.id_Cursa = id_Cursa;
    }

    public Long getId_Rezervare() {
        return id_Rezervare;
    }

    public void setId_Rezervare(Long id_Rezervare) {
        this.id_Rezervare = id_Rezervare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getRezervari() {
        return rezervari;
    }

    public void setRezervari(int rezervari) {
        this.rezervari = rezervari;
    }

    public Long getId_Cursa() {
        return id_Cursa;
    }

    public void setId_Cursa(Long id_Cursa) {
        this.id_Cursa = id_Cursa;
    }

    @Override
    public String toString() {
        return "Rezervare " +
                " pe numele  '" + nume + '\'' +
                " cu numarul de locuri '" + rezervari + '\'';

    }
}
