package com.desarrollo.sem.servlet;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.sem.model.Patente;
import com.desarrollo.sem.service.PatenteService;

@RestController
@RequestMapping("patentes")
public class PatenteServlet {

    @Autowired
    private PatenteService service;

    /*
     * public PatenteServlet(PatenteService service) {
     * this.service = service;
     * }
     */

    /*
     * @GetMapping("/{numero}/")
     * public Patente find(@PathVariable String numero){
     * return service.findNum(numero);
     * }
     * 
     */
    /*
     * @GetMapping("/num/{num}")
     * public Patente findNumPatente(@PathVariable String num){
     * return service.findByNum(num);
     * }
     */

    @GetMapping("/all")
    public List<Patente> findAll() {
        return service.findAll();
    }

    @PostMapping("/new")
    public Patente create(@RequestBody Patente patente) {
        return service.save(patente);
    }

    @GetMapping("/numero/{numero}")

    //
    public List<Patente> findByNumero(@PathParam(value = "num1") String num1) {
        return service.findByNombre(num1);

    }

    @GetMapping("/num/{num2}/")
    public List<Patente> findByNumeroJpql(@PathVariable String num2) {
        return service.findByNombreJpql(num2);

    }



    /*
     * @PostMapping("/create")
     * public String create(@RequestBody Patente patente ){
     * Patente patente2 = service.create(patente);
     * return patente.toString() ;
     * }
     */

}