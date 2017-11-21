package com.example.demo.service;

import com.example.demo.entity.Cursa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursaService implements ICursa{
    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<Object> findAll() {


        String sql = "SELECT * FROM Cursa";

        List<Object> cursa = jtm.query(sql, new BeanPropertyRowMapper(Cursa.class));

        return cursa;
    }

    @Override
    public List<String> findCursaRezervare(Long id_Cursa) {
        String sql = "SELECT locuri_libere,PRET,PLECARE,SOSIRE,rezervari,DATE FROM REZERVARE,Cursa WHERE REZERVARE.ID_CURSA=?";

        List<String> cursa = jtm.query(sql, new Object[]{id_Cursa}, new BeanPropertyRowMapper(List.class));

        return cursa;


    }

    @Override
    public Cursa findById(Long id_Cursa) {
        String sql = "SELECT * FROM CURSA WHERE ID_CURSA=?";
        Cursa cursa = (Cursa) jtm.queryForObject(sql, new Object[]{id_Cursa},
                new BeanPropertyRowMapper(Cursa.class));
        return cursa;
    }

    @Override
    public List<Cursa> findByCursa(String plecare,String sosire) {

        String sql = "SELECT * FROM CURSA WHERE PLECARE=? and SOSIRE=? ORDER BY DATE ";

        List<Cursa> cursa = jtm.query(sql, new Object[]{plecare,sosire},
                new BeanPropertyRowMapper(Cursa.class));

        return cursa;
    }

    @Override
    public void addCursa(Cursa cursa) {
     //   String sql = "INSERT INTO CURSA(PLECARE,SOSIRE,DATE) VALUES ('"+cursa.getPlecare()+"','"+cursa.getSosire()+"'+cursa.getDate()+";
        String sql="INSERT INTO CURSA(PLECARE,SOSIRE,DATE,PRET,LOCURI_LIBERE) VALUES (?,?,?,?,?)";
        jtm.update(sql,cursa.getPlecare(),cursa.getSosire(),cursa.getDate(),cursa.getPret(),cursa.getLocuri_libere());
       // jtm.queryForObject(sql, new Object[]{cursa.getPlecare(),cursa.getSosire(),cursa.getDate()},new BeanPropertyRowMapper(Cursa.class));
    }

    @Override
    public void updateCursa(Cursa cursa) {
      //  String sql="UPDATE CURSA SET PLECARE="+cursa.getPlecare()+",SOSIRE="+cursa.getSosire()+",DATE="+cursa.getDate()+" WHERE ID_CURSA="+cursa.getId_Cursa();
        String sql="UPDATE CURSA SET pret=?,locuri_libere=?,PLECARE=?,SOSIRE=?,DATE =? WHERE ID_CURSA=?";
        jtm.update(sql,cursa.getPret(),cursa.getLocuri_libere(),cursa.getPlecare(),cursa.getSosire(),cursa.getDate(),cursa.getId_Cursa());
        //jtm.queryForObject(sql, new Object[]{cursa.getPlecare(),cursa.getSosire(),cursa.getDate(),cursa.getId_Cursa()},new BeanPropertyRowMapper(Cursa.class));
    }

    @Override
    public void deleteCursa(Long id_Cursa) {
        String sql="DELETE FROM REZERVARE WHERE ID_CURSA=?";
        jtm.update(sql,id_Cursa);
        sql="DELETE FROM CURSA WHERE ID_CURSA=?";
        jtm.update(sql,id_Cursa);
        // jtm.queryForObject(sql, new Object[]{id_Cursa},new BeanPropertyRowMapper(Cursa.class));

    }


}
