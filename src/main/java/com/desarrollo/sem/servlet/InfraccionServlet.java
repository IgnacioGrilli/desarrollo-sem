package com.desarrollo.sem.servlet;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.service.InfraccionDTO;
import com.desarrollo.sem.service.InfraccionService;
import com.desarrollo.sem.service.ObleistaSummaryDTO;

@RestController
@RequestMapping("infraccion")
public class InfraccionServlet {

    @Autowired
    private InfraccionService service;

    @GetMapping("/all/{patente}")
    public List<InfraccionDTO> findInfraccionesByPatente(@PathVariable String patente) {
        return service.getInfraccionesByPatente(patente);
    }

    // Nuevo método para obtener todas las infracciones sin distinción de patentes
    @GetMapping("/all")
    public List<InfraccionDTO> findAllInfracciones() {
        return service.getAllInfracciones();
    }

    @GetMapping("/obleista-summaries")
    public List<ObleistaSummaryDTO> getObleistaSummaries() {
        return service.getObleistaSummaries();
    }

    @GetMapping("/byFecha/{fecha}")
    public ResponseEntity<List<InfraccionDTO>> getInfraccionesByFecha(@PathVariable String fecha) {
        try {
            Date sqlDate = Date.valueOf(fecha);  // Convertir la cadena a java.sql.Date
            return ResponseEntity.ok(service.getInfraccionesByFecha(sqlDate));
        } catch (IllegalArgumentException e) {
            // Manejar el caso donde la fecha no esté en el formato correcto
            return ResponseEntity.badRequest().body(null);
        }
    }
}