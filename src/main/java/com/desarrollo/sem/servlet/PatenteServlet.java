package com.desarrollo.sem.servlet;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.desarrollo.sem.models.Patente;


@Path("/patente")
public class PatenteServlet {

    @EJB
    private PatenteService service;


    public PatenteServlet() {
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Patente> findAll(){
        Collection<Patente> data;

        data = service.findAll();


        return data;

    }

    
}
