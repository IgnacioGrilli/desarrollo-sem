package com.desarrollo.sem.servlet;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.service.*;



@RestController
@RequestMapping("ValorMinuto")
public class ValorMinutoServlet {
    
    @Autowired
    private ValorMinutoService service;

    @GetMapping("/ValorActual")
    public int valorActual() {
        /* List<ValorMinuto> v = service.valorActual(PageRequest.of(0,1)); */
        /* return service.findTopByOrderByvalorDesc().getValor(); */
         return service.valorActual().getValor();
    }


}
