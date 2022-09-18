package com.desarrollo.sem.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrollo.sem.model.Patente;


@Repository
public interface PatenteService extends JpaRepository<Patente,Long> {

 //   Patente findByNum(String num);

   /*  public List<Patente> findAll();

    public Patente findNum(String numero);

    public Patente create(Patente patente); */
    
}
