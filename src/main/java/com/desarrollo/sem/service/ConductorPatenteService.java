package com.desarrollo.sem.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrollo.sem.model.ConductorPatente;


@Repository
public interface ConductorPatenteService extends JpaRepository<ConductorPatente,Long>  {

}
