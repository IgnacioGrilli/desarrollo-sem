package com.desarrollo.sem.service;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.desarrollo.sem.model.ValorMinuto;


@Repository
public interface ValorMinutoService  extends JpaRepository<ValorMinuto, Long>  {
 
  
  @Query(value = "SELECT * from valor_minuto p ORDER BY p.fecha_desde desc limit 1", nativeQuery = true)
  ValorMinuto valorActual();
 

  /* 
  ValorMinuto findTopByOrderByvalorDesc();  */

}
