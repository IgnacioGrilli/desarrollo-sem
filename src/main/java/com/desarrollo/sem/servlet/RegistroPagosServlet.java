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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RequestMapping("registroPagos")
@RestController
public class RegistroPagosServlet {
    
    @Autowired
    private RegistroPagosService service;

   
    /* public RegistroPagosServlet(RegistroPagosService service) {
        this.service = service;
    } */
    
    @PostMapping("/new")
    public RegistroPagosDiarios create(@RequestBody RegistroPagosDiarios registroPago ){
      return  service.save(registroPago);
      }

    @GetMapping("/all")
    public List<RegistroPagosDiarios> findAll(){
        return service.findAll();
    }

    @PutMapping("/update/{id}")
    public RegistroPagosDiarios update (@PathVariable long id, @RequestBody RegistroPagosDiarios registro){
        RegistroPagosDiarios reg = service.findById(id).orElseThrow();
        reg.setHoraFin(registro.getHoraFin());
        return service.save(reg);
    }
}
