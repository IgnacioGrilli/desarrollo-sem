package com.desarrollo.sem.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desarrollo.sem.service.CuentaCorrieteService;
import com.desarrollo.sem.model.CuentaCorriente;



@RestController
@RequestMapping("CuentaCorriente")
public class CuentaCorreienteServlet {

    @Autowired
    private CuentaCorrieteService service;

   
 /*    public CuentaCorreienteServlet(CuentaCorrieteService service) {
        this.service = service;
    }
 */

    @PostMapping("/new")
    public CuentaCorriente create(@RequestBody CuentaCorriente conductorPatente ){
       // ConductorPatente conductorPat = service.create(conductorPataux); 
        return  service.save(conductorPatente) ; //cambiar a conductorPatente
    }

    @GetMapping("/all")
    public List<CuentaCorriente> findAll(){
        return service.findAll();
    }
    
}
