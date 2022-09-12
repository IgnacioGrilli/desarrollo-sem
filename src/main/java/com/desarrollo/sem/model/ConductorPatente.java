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
    private int id;

    @ManyToOne()
    @JoinColumn(name="PATENTE_ID")
    private Patente patente;
 
    @ManyToOne()
    @JoinColumn(name="CONDUCTOR_ID")
    private UsuarioConductor conductor;
 

    public ConductorPatente() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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



    }