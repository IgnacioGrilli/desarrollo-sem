package com.desarrollo.sem.service;

import org.springframework.stereotype.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desarrollo.sem.model.RegistroPagosDiarios;


@Repository
public interface RegistroPagosService extends JpaRepository<RegistroPagosDiarios,Long>  {
    RegistroPagosDiarios findOneByUuid(UUID uuid); 
}
