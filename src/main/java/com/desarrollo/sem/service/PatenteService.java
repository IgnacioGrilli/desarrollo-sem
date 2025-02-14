package com.desarrollo.sem.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.desarrollo.sem.model.Patente;

@Repository
public interface PatenteService extends JpaRepository<Patente, Long>  {

  @Query(value = "SELECT p from Patente p WHERE p.numero LIKE %?1%")
  List<Patente> findByNombre( String num);


  @Query(value = "SELECT * FROM patente WHERE patente.numero like %?1%",
          nativeQuery = true
  )
  List<Patente> findByNombreJpql(String num2);


  @Query(value = "SELECT p FROM Patente p WHERE p.numero = ?1")
  Patente findByNumero(String numero);
}