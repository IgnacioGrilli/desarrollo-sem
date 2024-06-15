package com.desarrollo.sem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
interface InfraccionRepository extends JpaRepository<InfraccionDTO, Long> {

    // Nueva query para obtener todas las infracciones sin distinción de patentes
    @Query(value = "SELECT rpd.uuid AS id, rpd.fecha AS fecha, rpd.patenteid AS patente, rpd.hora AS hora FROM registro_patentes_diarios rpd EXCEPT SELECT DISTINCT ON (rpat.uuid) rpat.uuid, rpat.fecha, rpat.patenteid, rpat.hora FROM registro_pagos_diarios rpag JOIN registro_patentes_diarios rpat ON rpag.patente_id = rpat.patenteid WHERE rpag.fecha = rpat.fecha AND rpat.hora >= rpag.hora_inicio AND rpat.hora <= rpag.hora_fin", nativeQuery = true)
    List<InfraccionDTO> findAllInfracciones();

    @Query(value = "SELECT rpd.uuid AS id, rpd.fecha AS fecha, rpd.patenteid AS patente, rpd.hora AS hora FROM registro_patentes_diarios rpd WHERE rpd.patenteid = ?1 EXCEPT SELECT DISTINCT ON (rpat.uuid) rpat.uuid, rpat.fecha, rpat.patenteid, rpat.hora FROM registro_pagos_diarios rpag JOIN registro_patentes_diarios rpat ON rpag.patente_id = rpat.patenteid WHERE rpat.patenteid = ?1 AND rpag.fecha = rpat.fecha AND rpat.hora >= rpag.hora_inicio AND rpat.hora <= rpag.hora_fin", nativeQuery = true)
    List<InfraccionDTO> findInfraccionesByPatente(String patente);
}

@Service
public class InfraccionService {

    @Autowired
    private InfraccionRepository infraccionRepository;

    public List<InfraccionDTO> getInfraccionesByPatente(String patente) {
        return infraccionRepository.findInfraccionesByPatente(patente);
    }

    // Nuevo método para obtener todas las infracciones sin distinción de patentes
    public List<InfraccionDTO> getAllInfracciones() {
        return infraccionRepository.findAllInfracciones();
    }
}
