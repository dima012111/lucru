package com.example.demo.service;

import com.example.demo.entity.Cursa;

import java.util.List;

public interface ICursa {
     List<Object> findAll();
     List<String> findCursaRezervare(Long id_Cursa);
     List<Cursa> findByCursa(String plecare,String sosire);
     Cursa findById(Long id_Cursa);
     void addCursa(Cursa cursa);
     void updateCursa(Cursa cursa);
     void deleteCursa(Long id_Cursa);

}
