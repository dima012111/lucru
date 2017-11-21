package com.example.demo.controller;

import com.example.demo.entity.Cursa;
import com.example.demo.entity.Rezervare;
import com.example.demo.service.ICursa;
import com.example.demo.service.IRezervare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin()
public class RezervareController {
    @Autowired
    private IRezervare rezervare;

    @RequestMapping("/rezervare")
    public List<Rezervare> findRezervari() {

        return rezervare.findAll();
    }

    @RequestMapping("/rezervare/{id_Rezervare}")
    public List<Rezervare> findRezervareId(@PathVariable("id_Rezervare") Long id_Rezervare) {

        return rezervare.findById(id_Rezervare);
    }

    @RequestMapping(value = "/rezervare",method = RequestMethod.POST)
    public void addRezervare(@RequestBody Rezervare rez) {

        rezervare.addRezervare(rez);
    }

    @RequestMapping(value = "/rezervare",method = RequestMethod.PUT)
    public void updateRezervare(@RequestBody Rezervare rez) {
        rezervare.updateRezervare(rez);
    }

    @RequestMapping(value = "/rezervare/{id_Rezervare}",method = RequestMethod.DELETE)
    public void deleteRezervare(@PathVariable("id_Rezervare") Long id_Rezervare) {
        //trebuie de anulat rezervarile
        rezervare.deleteRezervare(id_Rezervare);
    }

}
