package com.desarrollo.sem.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.desarrollo.sem.model.Patente;

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

  public Patente findNum(String numero) {
    try {
      return em.createQuery(
        "select e from Patente e where e.numero = :numero", Patente.class)
        .setParameter("numero", numero)
        .getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }


  public Patente create(Patente patente) {
    em.persist(patente);
      return patente;
  }

  
}
    
  
