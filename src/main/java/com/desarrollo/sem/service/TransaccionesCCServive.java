package com.desarrollo.sem.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.desarrollo.sem.model.CuentaCorriente;
import com.desarrollo.sem.model.TransaccionesCC;

@Repository
public interface TransaccionesCCServive extends JpaRepository<TransaccionesCC, Long> {

  //busca las transacciones de un usuario 
  @Query(value = "SELECT NEW com.desarrollo.sem.service.TransaccionDTO (p.id, p.montoTransaccion, p.fecha, p.hora)"+
  " FROM TransaccionesCC p WHERE p.cuenta.mail = ?1")
  List<TransaccionDTO> getTransaccionesUsuario(String mail);


}
