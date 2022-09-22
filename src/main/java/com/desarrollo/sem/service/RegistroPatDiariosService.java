package com.desarrollo.sem.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrollo.sem.model.RegistroPatentesDiarios;

@Repository
public interface RegistroPatDiariosService extends JpaRepository<RegistroPatentesDiarios, Long> {

}
