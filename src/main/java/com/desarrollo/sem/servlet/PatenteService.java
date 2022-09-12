package com.desarrollo.sem.servlet;
import java.util.Collection;

import com.desarrollo.sem.models.Patente;



public interface PatenteService {

    public Collection<Patente> findAll();
    
}
