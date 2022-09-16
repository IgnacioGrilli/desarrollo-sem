package com.desarrollo.sem.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.model.Patente;
import com.desarrollo.sem.service.PatenteService;

@RequestMapping("patentes")
@RestController
public class PatenteServlet {

    private PatenteService service;

    @Autowired
    public PatenteServlet(PatenteService service) {
        this.service = service;
    }


    @GetMapping("/{numero}/")
    public Patente find(@PathVariable String numero){
        return service.findNum(numero);
    }

    
    @GetMapping("/all")
    public List<Patente> findAll(){
        return service.findAll();
    }

    

    
   
}