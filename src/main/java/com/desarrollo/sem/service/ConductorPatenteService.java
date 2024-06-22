package com.desarrollo.sem.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desarrollo.sem.model.ConductorPatente;
import com.desarrollo.sem.model.Patente;
import com.desarrollo.sem.model.UsuarioConductor;


@Repository
public interface ConductorPatenteService extends JpaRepository<ConductorPatente,Long>  {

    @Query(value = "SELECT p.patente from ConductorPatente p WHERE p.conductor=?1")
    List<Patente> findByCondId(UsuarioConductor us);

    @Query("SELECT cp FROM ConductorPatente cp WHERE cp.conductor = ?1 AND cp.patente = ?2")
    ConductorPatente findByConductorAndPatente(UsuarioConductor conductor, Patente patente);
}
