package com.desarrollo.sem.servlet;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.service.*;
import com.desarrollo.sem.model.ValorMinuto;


@RestController
@RequestMapping("ValorMinuto")
public class ValorMinutoServlet {
    
    @Autowired
    private ValorMinutoService service;

    @GetMapping("/all")
    public int valorActual() {

        return service.valorActual().getValor();
    }


}
