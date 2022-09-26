package com.desarrollo.sem.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrollo.sem.model.TransaccionesCC;

@Repository
public interface TransaccionesCCServive extends JpaRepository<TransaccionesCC, Long>  {

}
