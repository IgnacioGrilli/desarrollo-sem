package com.desarrollo.sem.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.model.TransaccionesCC;
import com.desarrollo.sem.service.TransaccionesCCServive;

@RestController
@RequestMapping("transaccion")
public class TransaccionesCCServlet {

    @Autowired
    private TransaccionesCCServive service;

    @GetMapping("/all")
    public List<TransaccionesCC> findAll() {
        return service.findAll();
    }

    @GetMapping("/all/{usu}")
    public List<TransaccionesCC> findTransaccionesUsuario(@PathVariable String usu) {
        return service.getTransaccionesUsuario(usu);
    }


    @PostMapping("/new")
    public TransaccionesCC create(@RequestBody TransaccionesCC transacion) {
        return service.save(transacion);
    }

}
