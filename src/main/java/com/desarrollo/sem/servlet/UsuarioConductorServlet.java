package com.desarrollo.sem.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.model.CuentaCorriente;
import com.desarrollo.sem.model.TransaccionesCC;
import com.desarrollo.sem.model.UsuarioConductor;

import com.desarrollo.sem.service.TransaccionesCCServive;
import com.desarrollo.sem.service.UsuarioConductorService;

@RestController
@RequestMapping("conductor")
public class UsuarioConductorServlet {

    @Autowired
    private UsuarioConductorService service;

    @Autowired
    private TransaccionesCCServive serviceTransaccion;

   

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

    @PutMapping("/newMovimiento/{val}")
    public UsuarioConductor newMovimiento(@RequestBody UsuarioConductor conductor, @PathVariable Double val) {

        TransaccionesCC trasacAux = null;
        CuentaCorriente cuenta =null;
        UsuarioConductor conductoraux = findMail(conductor.getMail());

        //si el conductor existe (corrobora con el mail)
        if (null != service.findByMail(conductor.getMail())) {
            //System.out.println("/ooooooooooooooo"+ findMail(conductor.getMail()).getCuenta());
            cuenta = conductoraux.getCuenta();
            trasacAux = serviceTransaccion.save(new TransaccionesCC(val, null, null,cuenta));
            cuenta.getTransaccion().add(trasacAux);
            return service.save(conductoraux);
        }
        //else
        System.out.println("nuloooooooooooo");
        return null;
    }

}
