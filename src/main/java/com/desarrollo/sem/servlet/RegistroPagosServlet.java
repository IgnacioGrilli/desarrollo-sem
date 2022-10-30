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
import com.desarrollo.sem.service.ValorMinutoService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RequestMapping("registroPagos")
@RestController
public class RegistroPagosServlet {
    
    @Autowired
    private RegistroPagosService service;

    @Autowired
    private ValorMinutoService valService;

   
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
    public RegistroPagosDiarios update (@PathVariable String id, @RequestBody RegistroPagosDiarios registro){
        long parsedId = Long.parseLong(id);
        RegistroPagosDiarios reg = service.findById(parsedId).orElseThrow();
        reg.setHoraFin(registro.getHoraFin());
        return service.save(reg);
    }

    @GetMapping("/minTotales/{id}") 
    public int minutos(@PathVariable long id) {
        RegistroPagosDiarios reg = service.findById(id).orElseThrow();

        Long min = (reg.getHoraInicio().getTime() - reg.getHoraFin().getTime()) / 60000;

        return min.intValue();
    }   

    @PutMapping("/valor/{id}")
    public long valor(@PathVariable long id) {
        RegistroPagosDiarios reg = service.findById(id).orElseThrow();
    
        reg.setValor(minutos(id) * valService.valorActual().getValor()); 
        service.save(reg);
        
        return reg.getValor();
    }     
}

    
