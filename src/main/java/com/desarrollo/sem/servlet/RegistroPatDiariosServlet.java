package com.desarrollo.sem.servlet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.model.RegistroPatentesDiarios;
import com.desarrollo.sem.service.RegistroPatDiariosService;

@RequestMapping("registroPatentes")
@RestController
public class RegistroPatDiariosServlet {

    private RegistroPatDiariosService service;

   



    @Autowired
    public RegistroPatDiariosServlet(RegistroPatDiariosService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public Collection<RegistroPatentesDiarios> findAll(){
        return service.findAll();
    }
    
}