package com.desarrollo.sem.service;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.desarrollo.sem.model.ValorMinuto;


@Repository
public interface ValorMinutoService  extends JpaRepository<ValorMinuto, Long>  {
 
    
  @Query(value = "SELECT p from valor_minuto p ORDER BY p.fecha_desde desc ", nativeQuery = true)
  ValorMinuto valorActual(); 
/* 
  ValorMinuto findTopByOrderByfechadesdeDesc(); */

}
