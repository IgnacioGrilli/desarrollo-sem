package com.desarrollo.sem.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desarrollo.sem.model.UsuarioConductor;

@Repository
public interface UsuarioConductorService extends JpaRepository<UsuarioConductor, Long> {

    @Query(value = "SELECT p from UsuarioConductor p WHERE p.mail LIKE %?1%")
    List<UsuarioConductor> findByMail(String num);

}
