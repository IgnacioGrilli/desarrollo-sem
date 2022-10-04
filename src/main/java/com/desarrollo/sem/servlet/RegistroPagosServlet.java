package com.desarrollo.sem.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desarrollo.sem.model.RegistroPagosDiarios;
import com.desarrollo.sem.service.RegistroPagosService;


@RequestMapping("registroPagos")
@RestController
public class RegistroPagosServlet {
    
    private RegistroPagosService service;

    @Autowired
    public RegistroPagosServlet(RegistroPagosService service) {
        this.service = service;
    }
    
    @PostMapping("/new")
    public RegistroPagosDiarios create(@RequestBody RegistroPagosDiarios registroPago ){
      return  service.save(registroPago);
      }

    @GetMapping("/all")
    public List<RegistroPagosDiarios> findAll(){
        return service.findAll();
    }

}

    
