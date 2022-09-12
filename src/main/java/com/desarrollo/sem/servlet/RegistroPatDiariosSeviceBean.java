package com.desarrollo.sem.servlet;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.desarrollo.sem.models.RegistroPatentesDiarios;

@Stateless 
public class RegistroPatDiariosSeviceBean implements RegistroPatDiariosSevice {


     //donde se define el nombre del PersistenceContext ?????
   // @PersistenceContext(unitName = "")
   @PersistenceContext()
   protected EntityManager em;

   public EntityManager getEntityManager() {
      return em;
   }

    @Override
    public Collection<RegistroPatentesDiarios> findAll() {

        try {
          return em.createQuery(
    "select e from RegistroPatentesDiarios e", RegistroPatentesDiarios.class)
              .getResultList();
        } catch (NoResultException e) {
          return null;
        }
    
      }
    
}
