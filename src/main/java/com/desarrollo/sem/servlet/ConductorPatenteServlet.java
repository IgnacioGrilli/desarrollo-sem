package com.desarrollo.sem.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desarrollo.sem.model.ConductorPatente;
import com.desarrollo.sem.service.ConductorPatenteService;



@RestController
@RequestMapping("conductorPatente")
public class ConductorPatenteServlet {

   // ConductorPatente conductorPataux;

   @Autowired
    private ConductorPatenteService service;

    /* 
    public ConductorPatenteServlet(ConductorPatenteService service) {
        this.service = service;
    } */


    @PostMapping("/new")
    public ConductorPatente create(@RequestBody ConductorPatente conductorPatente ){
       // ConductorPatente conductorPat = service.create(conductorPataux); 
        return  service.save(conductorPatente) ; //cambiar a conductorPatente
    }

    @GetMapping("/all")
    public List<ConductorPatente> findAll(){
        return service.findAll();
        
    }
}
