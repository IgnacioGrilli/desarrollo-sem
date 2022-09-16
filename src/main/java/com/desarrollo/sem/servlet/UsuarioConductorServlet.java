package com.desarrollo.sem.servlet;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.desarrollo.sem.model.UsuarioConductor;

import com.desarrollo.sem.service.UsuarioConductorService;



@RequestMapping("conductor")
@RestController
public class UsuarioConductorServlet {

    private UsuarioConductorService service;

    @Autowired
    public UsuarioConductorServlet(UsuarioConductorService service) {
        this.service = service;
    }

    @GetMapping("/mail/{mail}/")
    public UsuarioConductor findMail(@PathVariable String mail){
        return service.findMail(mail);
    }

}
