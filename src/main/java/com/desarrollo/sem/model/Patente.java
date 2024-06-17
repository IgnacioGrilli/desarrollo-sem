package com.desarrollo.sem.model;

import javax.persistence.*;

@Entity
public class Patente {

    @Id
    private String numero;

    public Patente() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "{" +
            " numero='" + getNumero() + "'" +
        "}";
    }

}