package com.example.demo.service;

import com.example.demo.entity.Rezervare;

import java.util.List;

public interface IRezervare {
    List<Rezervare> findAll();
    List<Rezervare> findById(Long id_Rezervare);
    void addRezervare(Rezervare rezervare);
    void updateRezervare(Rezervare rezervare);
    void deleteRezervare(Long id_Rezervare);


}
