package com.desarrollo.sem.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.model.UsuarioConductor;

import com.desarrollo.sem.service.UsuarioConductorService;

@RestController
@RequestMapping("conductor")
public class UsuarioConductorServlet {

    @Autowired
    private UsuarioConductorService service;

    @GetMapping("/all")
    public List<UsuarioConductor> findAll() {
        return service.findAll();
    }

    @GetMapping("/mail/{mail}/")
    public UsuarioConductor findMail(@PathVariable String mail) {
        return service.findByMail(mail);
    }

   @GetMapping("/calculoSaldoMail/{val}")
    public List<Double> findSaldoUsua(@PathVariable String val) {
       long idCuenta = service.findByMail(val).getCuenta().getId();
       System.out.println("////////////////////////" + idCuenta);
        return service.findBySaldo(idCuenta);
    } 

}
