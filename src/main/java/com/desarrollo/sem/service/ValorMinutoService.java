package com.desarrollo.sem.service;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.desarrollo.sem.model.ValorMinuto;


@Repository
public interface ValorMinutoService  extends JpaRepository<ValorMinuto, Long>  {
 
  
  @Query(value = "SELECT * from valor_minuto p WHERE p.fecha_desde <= CURRENT_DATE ORDER BY p.fecha_desde desc limit 1",
          nativeQuery = true)
  ValorMinuto valorActual();
 

  /* 
  ValorMinuto findTopByOrderByvalorDesc();  */

}
