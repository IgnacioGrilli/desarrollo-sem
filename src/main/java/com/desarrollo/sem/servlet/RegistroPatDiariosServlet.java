package com.desarrollo.sem.servlet;




import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.desarrollo.sem.models.RegistroPatentesDiarios;

@Path("/RegistroPatDiariosServlet")
public class RegistroPatDiariosServlet {


    @EJB
    private RegistroPatDiariosSevice service;

    public RegistroPatDiariosServlet() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<RegistroPatentesDiarios> findAll(){
        Collection<RegistroPatentesDiarios> data;

        data = service.findAll();


        return data;

    }
    
}


