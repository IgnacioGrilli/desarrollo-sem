package com.desarrollo.sem.model;

import javax.persistence.*;

@Entity
public class Patente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String numero;

    public Patente() {
    
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

<<<<<<< HEAD:src/main/java/com/desarrollo/sem/model/Patente.java
=======
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

>>>>>>> Nacho:src/main/java/com/desarrollo/sem/models/Patente.java
}