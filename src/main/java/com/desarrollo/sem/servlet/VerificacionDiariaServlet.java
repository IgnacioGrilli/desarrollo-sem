package com.desarrollo.sem.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.service.VerificacionDiariaService;

import com.desarrollo.sem.model.RegistroPatentesDiarios;

@RestController
@RequestMapping("verificacionDiaria")
public class VerificacionDiariaServlet {
    
    @Autowired
    private VerificacionDiariaService service;

    @GetMapping("/validar")
    public List<RegistroPatentesDiarios> validar() {
        return service.verificacionDiaria();
    }

}
