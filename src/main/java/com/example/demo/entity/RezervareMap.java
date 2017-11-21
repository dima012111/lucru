package com.example.demo.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RezervareMap implements RowMapper<Rezervare> {

    @Override
    public Rezervare mapRow(ResultSet resultSet, int i) throws SQLException {
        Rezervare r=new Rezervare();
        r.setId_Rezervare(resultSet.getLong("ID_Rezervare"));
        r.setRezervari(resultSet.getInt("REZERVARI"));
        r.setNume(resultSet.getString("NUME"));
        r.setId_Cursa(resultSet.getLong("ID_CURSA"));
        return r;
    }
}
