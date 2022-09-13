package com.desarrollo.sem.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.desarrollo.sem.models.Patente;

@Service
public class PatenteServiceBean implements PatenteService {

  @PersistenceContext
  protected EntityManager em;
   
  public List<Patente> findAll() {
    
    try {
      return em.createQuery(
      "SELECT p FROM Patente p", Patente.class
      ).getResultList();  
    } catch (NoResultException e) {
      return null;
    }

  }
    
}
