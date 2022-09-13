package com.desarrollo.sem.service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.desarrollo.sem.model.RegistroPatentesDiarios;

@Service 
public class RegistroPatDiariosServiceBean implements RegistroPatDiariosService {

  @PersistenceContext
  protected EntityManager em;

  @Override
  public Collection<RegistroPatentesDiarios> findAll() {

    try {
      return em.createQuery(
      "SELECT r FROM RegistroPatentesDiarios r", RegistroPatentesDiarios.class)
      .getResultList();
    } catch (NoResultException e) {
      return null;
    }
    
  }
    
}
