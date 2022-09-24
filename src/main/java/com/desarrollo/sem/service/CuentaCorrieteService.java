package com.desarrollo.sem.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desarrollo.sem.model.CuentaCorriente;


@Repository
public interface CuentaCorrieteService extends JpaRepository<CuentaCorriente, Long> {

}
