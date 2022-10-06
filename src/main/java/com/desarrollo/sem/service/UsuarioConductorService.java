package com.desarrollo.sem.service;

import java.util.Calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desarrollo.sem.model.UsuarioConductor;

@Repository
public interface UsuarioConductorService extends JpaRepository<UsuarioConductor, Long> {

    @Query(value = "SELECT p from UsuarioConductor p WHERE p.mail LIKE %?1%")
    UsuarioConductor findByMail(String num);

/* 
    @Query(value = "SELECT sum(r.monto_transaccion) from Transaccionescc r WHERE r.fk_cc.id = ?1 ")
    List<Double> findBySaldo(long idCuenta); NO FUNSIONA */

    
     /* @Query(value =
      "SELECT sum(transaccionescc.monto_transaccion) from transaccionescc where transaccionescc.fk_cc = :idCuenta "
     , nativeQuery = true)
      List<Double> findBySaldo(@Param("idCuenta")long idCuenta); */


      @Query(value =
      "SELECT sum(transaccionescc.monto_transaccion) from transaccionescc where transaccionescc.usuario_id = :idCuenta AND transaccionescc.fecha <= :fecha"
     , nativeQuery = true)
      Double findBySaldo(@Param("idCuenta")long idCuenta, @Param("fecha") Calendar fecha);
    
}
