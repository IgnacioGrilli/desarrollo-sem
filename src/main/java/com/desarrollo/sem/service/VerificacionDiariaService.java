package com.desarrollo.sem.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.desarrollo.sem.model.RegistroPatentesDiarios;

@Repository
public interface VerificacionDiariaService extends JpaRepository<RegistroPatentesDiarios, String>  {

    @Query(value = "SELECT p FROM Patente p WHERE p.numero LIKE %?1%")
    List<RegistroPatentesDiarios> verificacionDiaria();

}