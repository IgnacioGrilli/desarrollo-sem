package com.desarrollo.sem.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrollo.sem.model.ConductorPatente;


@Repository
public interface ConductorPatenteService extends JpaRepository<ConductorPatente,Long>  {

   /*  public ConductorPatente create(ConductorPatente conductorPatente);

    public List<ConductorPatente> findAll(); */

}
