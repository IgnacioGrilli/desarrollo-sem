package com.desarrollo.sem.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class ConductorPatente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name="PATENTE_ID", nullable = false)
    private Patente patente;
 
    @ManyToOne()
    @JoinColumn(name="CONDUCTOR_ID", nullable = false)
    private UsuarioConductor conductor;
 

    public ConductorPatente() {
    }

    public ConductorPatente(int id, Patente patente, UsuarioConductor conductor) {
        this.id = id;
        this.patente = patente;
        this.conductor = conductor;
    }

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

  

    public Patente getPatente() {
        return this.patente;
    }

    public void setPatente(Patente patente) {
        this.patente = patente;
    }

    public UsuarioConductor getConductor() {
        return this.conductor;
    }

    public void setConductor(UsuarioConductor conductor) {
        this.conductor = conductor;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", patente='" + getPatente() + "'" +
            ", conductor='" + getConductor() + "'" +
            "}";
    }




    }