package com.desarrollo.sem.service;

import java.util.List;

import com.desarrollo.sem.model.ConductorPatente;


public interface ConductorPatenteService {

    public ConductorPatente create(ConductorPatente conductorPatente);

    public List<ConductorPatente> findAll();

}
