package com.desarrollo.sem.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ValorMinuto {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int valor;

    @Temporal (TemporalType.DATE)
    private Calendar fechaDesde;


    // Horario de la mañana 
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date hsInicioM;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date hsFinM;


    // Horario de la tarde
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date hsInicioT;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date hsFinT;


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

    public Date getHsInicioM() {
        return this.hsInicioM;
    }

    public void setHsInicioM(Date hsInicioM) {
        this.hsInicioM = hsInicioM;
    }

    public Date getHsFinM() {
        return this.hsFinM;
    }

    public void setHsFinM(Date hsFinM) {
        this.hsFinM = hsFinM;
    }

    public Date getHsInicioT() {
        return this.hsInicioT;
    }

    public void setHsInicioT(Date hsInicioT) {
        this.hsInicioT = hsInicioT;
    }

    public Date getHsFinT() {
        return this.hsFinT;
    }

    public void setHsFinT(Date hsFinT) {
        this.hsFinT = hsFinT;
    }


}
