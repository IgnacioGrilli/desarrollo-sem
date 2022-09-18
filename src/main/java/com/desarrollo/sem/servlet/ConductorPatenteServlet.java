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


@RequestMapping("conductorPatente")
@RestController
public class ConductorPatenteServlet {

    ConductorPatente conductorPataux;

    private ConductorPatenteService service;

    @Autowired
    public ConductorPatenteServlet(ConductorPatenteService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public String create(@RequestBody ConductorPatente conductorPatente ){
        ConductorPatente conductorPat = service.create(conductorPataux); 
        return conductorPatente.toString() ; //cambiar a conductorPatente
    }

    @GetMapping("/all")
    public List<ConductorPatente> findAll(){
        return service.findAll();
    }
}
