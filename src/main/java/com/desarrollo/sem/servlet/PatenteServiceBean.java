package com.desarrollo.sem.servlet;

import com.desarrollo.sem.models.Patente;

import java.util.Collection;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


@Stateless 
public class PatenteServiceBean implements PatenteService {


    //donde se define el nombre del PersistenceContext ?????
   // @PersistenceContext(unitName = "")
    @PersistenceContext()
   protected EntityManager em;

   public EntityManager getEntityManager() {
      return em;
   }

    
    public Collection<Patente> findAll() {

        try {
          return em.createQuery(
    "select e from Patente e", Patente.class)
              .getResultList();
        } catch (NoResultException e) {
          return null;
        }
    
      }
    
}
