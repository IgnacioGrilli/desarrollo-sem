package com.desarrollo.sem.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Calendar;
import javax.persistence.*;

@Entity
public class ValorMinuto {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int valor;

    @Temporal (TemporalType.DATE)
    private Calendar fechaDesde;


    // Horario de la mañana 
    private int hsInicioM;
    private int hsFinM;

    public int getHsInicioM() {
        return this.hsInicioM;
    }

    public void setHsInicioM(int hsInicioM) {
        this.hsInicioM = hsInicioM;
    }

    public int getHsFinM() {
        return this.hsFinM;
    }

    public void setHsFinM(int hsFinM) {
        this.hsFinM = hsFinM;
    }

    public int getHsInicioT() {
        return this.hsInicioT;
    }

    public void setHsInicioT(int hsInicioT) {
        this.hsInicioT = hsInicioT;
    }

    public int getHsFinT() {
        return this.hsFinT;
    }

    public void setHsFinT(int hsFinT) {
        this.hsFinT = hsFinT;
    }


    // Horario de la tarde
    private int hsInicioT;
    private int hsFinT;


    public ValorMinuto() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Calendar getFechaDesde() {
        return this.fechaDesde;
    }

    public void setFechaDesde(Calendar fechaDesde) {
        this.fechaDesde = fechaDesde;
    }



}
