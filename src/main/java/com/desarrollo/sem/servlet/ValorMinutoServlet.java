package com.desarrollo.sem.servlet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.model.ValorMinuto;
import com.desarrollo.sem.service.*;



@RestController
@RequestMapping("ValorMinuto")
public class ValorMinutoServlet {
    
    @Autowired
    private ValorMinutoService service;

    @GetMapping("/ValorActual")
    public double valorActual() {
        /* List<ValorMinuto> v = service.valorActual(PageRequest.of(0,1)); */
        /* return service.findTopByOrderByvalorDesc().getValor(); */
         return service.valorActual().getValor();
    }

    @GetMapping("/horario")
    public ValorMinuto getHorario() {
        /* List<ValorMinuto> v = service.valorActual(PageRequest.of(0,1)); */
        /* return service.findTopByOrderByvalorDesc().getValor(); */
         return service.valorActual();
    }


}
