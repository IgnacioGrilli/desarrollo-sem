package com.desarrollo.sem.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import java.util.Calendar;
import javax.persistence.*;

@Entity
public class ValorMinuto {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double valor;

    @Temporal (TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YY")
    private Calendar fechaDesde;

    // Horario de la mañana
    private int hsInicioM;
    private int hsFinM;

    // Horario de la tarde
    private int hsInicioT;
    private int hsFinT;

    public ValorMinuto() {  }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

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

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getFechaDesde() {
        return this.fechaDesde;
    }

    public void setFechaDesde(Calendar fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

}
