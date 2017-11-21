package com.example.demo.service;

import com.example.demo.entity.Cursa;
import com.example.demo.entity.Rezervare;
import com.example.demo.entity.RezervareMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RezervareService implements IRezervare {
    @Autowired
    private JdbcTemplate jtm;
    @Override
    public List<Rezervare> findAll() {
        String sql = "SELECT * FROM Rezervare";
        List<Rezervare> rez = jtm.query(sql, new BeanPropertyRowMapper(Rezervare.class));

        return rez;
    }

    @Override
    public List<Rezervare> findById(Long id_Rezervare) {
        String sql = "SELECT * FROM Rezervare WHERE ID_Cursa=? ";

        List<Rezervare> rez = jtm.query(sql, new Object[]{id_Rezervare},
                new RezervareMap());

        return rez;
    }
    @Async
    @Override
    public void addRezervare(Rezervare rezervare) {
try {
    String sql = "SELECT * FROM CURSA WHERE ID_CURSA=?";
    Cursa cursa = (Cursa) jtm.queryForObject(sql, new Object[]{rezervare.getId_Cursa()},
            new BeanPropertyRowMapper(Cursa.class));
if (cursa.getLocuri_libere()>0) {
    sql = "INSERT INTO REZERVARE(NUME,REZERVARI,ID_CURSA) VALUES (?,?,?)";
    jtm.update(sql, rezervare.getNume(), rezervare.getRezervari(), rezervare.getId_Cursa());
}
}catch (Exception e){
    e.printStackTrace();
    }
    }

    @Override
    public void updateRezervare(Rezervare rezervare) {
        String sql="UPDATE REZERVARE SET REZERVARI=?,NUME=?,ID_CURSA =? WHERE ID_REZERVARE=?";
        jtm.update(sql,rezervare.getRezervari(),rezervare.getNume(),rezervare.getId_Cursa(),rezervare.getId_Rezervare());

    }

    @Override
    public void deleteRezervare(Long id_Rezervare) {
        String sql="DELETE FROM REZERVARE WHERE ID_REZERVARE=?";
        jtm.update(sql,id_Rezervare);

    }


}
