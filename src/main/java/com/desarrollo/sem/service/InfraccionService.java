package com.desarrollo.sem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
interface InfraccionRepository extends JpaRepository<InfraccionDTO, Long> {

    // Nueva query para obtener todas las infracciones sin distinción de patentes
    @Query(value = "SELECT rpd.uuid AS id, rpd.fecha AS fecha, rpd.patenteid AS patente, rpd.hora AS hora FROM registro_patentes_diarios rpd EXCEPT SELECT DISTINCT ON (rpat.uuid) rpat.uuid, rpat.fecha, rpat.patenteid, rpat.hora FROM registro_pagos_diarios rpag JOIN registro_patentes_diarios rpat ON rpag.patente_id = rpat.patenteid WHERE rpag.fecha = rpat.fecha AND rpat.hora >= rpag.hora_inicio AND rpat.hora <= rpag.hora_fin ORDER BY fecha DESC", nativeQuery = true)
    List<InfraccionDTO> findAllInfracciones();

    @Query(value = "SELECT rpd.uuid AS id, rpd.fecha AS fecha, rpd.patenteid AS patente, rpd.hora AS hora FROM registro_patentes_diarios rpd WHERE rpd.patenteid = ?1 EXCEPT SELECT DISTINCT ON (rpat.uuid) rpat.uuid, rpat.fecha, rpat.patenteid, rpat.hora FROM registro_pagos_diarios rpag JOIN registro_patentes_diarios rpat ON rpag.patente_id = rpat.patenteid WHERE rpat.patenteid = ?1 AND rpag.fecha = rpat.fecha AND rpat.hora >= rpag.hora_inicio AND rpat.hora <= rpag.hora_fin ORDER BY fecha DESC", nativeQuery = true)
    List<InfraccionDTO> findInfraccionesByPatente(String patente);

    @Query(value = "SELECT uo.id AS obleistaId, uo.nombre AS obleistaNombre, SUM(rpd.valor) AS totalValor, COUNT(*) AS totalRegistros FROM public.registro_pagos_diarios rpd JOIN public.usuario_obleista uo ON rpd.obleista_id = uo.id GROUP BY uo.id, uo.nombre", nativeQuery = true)
    List<ObleistaSummaryProjection> findObleistaSummaries();

    // Nueva consulta para obtener infracciones por fecha específica
    @Query(value = "SELECT rpd.uuid AS id, rpd.fecha AS fecha, rpd.patenteid AS patente, rpd.hora AS hora " +
            "FROM registro_patentes_diarios rpd " +
            "WHERE rpd.fecha = ?1 " +
            "EXCEPT " +
            "SELECT DISTINCT ON (rpat.uuid) rpat.uuid, rpat.fecha, rpat.patenteid, rpat.hora " +
            "FROM registro_pagos_diarios rpag " +
            "JOIN registro_patentes_diarios rpat ON rpag.patente_id = rpat.patenteid " +
            "WHERE rpag.fecha = ?1 AND rpat.hora >= rpag.hora_inicio AND rpat.hora <= rpag.hora_fin",
            nativeQuery = true)
    List<InfraccionDTO> findInfraccionesByFecha(Date fecha);
}

@Service
public class InfraccionService {

    @Autowired
    private InfraccionRepository infraccionRepository;

    public List<InfraccionDTO> getInfraccionesByPatente(String patente) {
        return infraccionRepository.findInfraccionesByPatente(patente);
    }

    //  método para obtener todas las infracciones sin distinción de patentes
    public List<InfraccionDTO> getAllInfracciones() {
        return infraccionRepository.findAllInfracciones();
    }

    //  método para obtener el resumen de los obleistas
    public List<ObleistaSummaryDTO> getObleistaSummaries() {
        List<ObleistaSummaryProjection> projections = infraccionRepository.findObleistaSummaries();
        return projections.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ObleistaSummaryDTO convertToDto(ObleistaSummaryProjection projection) {
        ObleistaSummaryDTO dto = new ObleistaSummaryDTO();
        dto.setObleistaId(projection.getObleistaId());
        dto.setObleistaNombre(projection.getObleistaNombre());
        dto.setTotalValor(projection.getTotalValor());
        dto.setTotalRegistros(projection.getTotalRegistros());
        return dto;
    }

    // Método para obtener infracciones por fecha
    public List<InfraccionDTO> getInfraccionesByFecha(Date fecha) {
        return infraccionRepository.findInfraccionesByFecha(fecha);
    }


}