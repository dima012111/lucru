package com.example.demo.entity;


import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cursa implements Serializable,Comparable<Cursa> {
    private Long id_Cursa;
    private String plecare;
    private String sosire;
    private Timestamp date;
    private Double pret;
    private int locuri_libere;

    @Override
    public String toString() {
        return "Cursa " +
                "care pleaca la '" + plecare + '\'' +
                " si soseste la '" + sosire + '\'' +
                " la data de '" + date + '\''+
                " pretul unui bilet '" + pret + '\'' +
                " si locuri libere  '" + locuri_libere + '\'';
    }

    public Cursa() {
    }

    public Cursa(Long id_Cursa, String plecare, String sosire, Timestamp date, Double pret, int locuri_libere) {
        this.id_Cursa = id_Cursa;
        this.plecare = plecare;
        this.sosire = sosire;
        this.date = date;
        this.pret = pret;
        this.locuri_libere = locuri_libere;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public int getLocuri_libere() {
        return locuri_libere;
    }

    public void setLocuri_libere(int locuri_libere) {
        this.locuri_libere = locuri_libere;
    }



    public Long getId_Cursa() {
        return id_Cursa;
    }

    public void setId_Cursa(Long id_Cursa) {
        this.id_Cursa = id_Cursa;
    }

    public String getPlecare() {
        return plecare;
    }

    public void setPlecare(String plecare) {
        this.plecare = plecare;
    }

    public String getSosire() {
        return sosire;
    }

    public void setSosire(String sosire) {
        this.sosire = sosire;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public int compareTo(Cursa o) {
        return getDate().compareTo(o.getDate());
    }
}
