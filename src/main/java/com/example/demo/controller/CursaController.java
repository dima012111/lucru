package com.example.demo.controller;

import com.example.demo.entity.Cursa;
import com.example.demo.service.ICursa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class CursaController {

    @Autowired
    private ICursa cityService;


    @RequestMapping("/cursa")
    public List<Object> findCurse() {

        return cityService.findAll();
    }


    @RequestMapping(value = "/cursa/{id_Cursa}",method = RequestMethod.GET)
    public Cursa findCursaId(@PathVariable("id_Cursa") Long id_Cursa) {

        return cityService.findById(id_Cursa);
    }


    @RequestMapping("/cursa/{plecare}"+"/"+"{sosire}")
    public List<Cursa> findCursa(@PathVariable("plecare") String plecare, @PathVariable("sosire") String sosire) {

        return cityService.findByCursa(plecare,sosire);
    }

    @RequestMapping(value = "/cursa",method = RequestMethod.POST)
    public void addCursa(@RequestBody Cursa cursa) {

        cityService.addCursa(cursa);
    }

    @RequestMapping(value = "/cursa",method = RequestMethod.PUT)
    public void updateCursa(@RequestBody Cursa cursa) {
        cityService.updateCursa(cursa);
    }

    @RequestMapping(value = "/cursa/{id_Cursa}",method = RequestMethod.DELETE)
    public void deleteCursa(@PathVariable("id_Cursa") Long id_Cursa) {
        //trebuie de anulat rezervarile
        cityService.deleteCursa(id_Cursa);
    }


}
