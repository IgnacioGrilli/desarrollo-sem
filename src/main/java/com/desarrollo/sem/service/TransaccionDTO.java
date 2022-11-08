package com.desarrollo.sem.service;

import java.util.Date;
import java.util.Calendar;

public class TransaccionDTO {
    private long id;
    private double montoTransaccion;
    private Calendar fecha;
    private Date hora;


    public TransaccionDTO(long id, double montoTransaccion, Calendar fecha, Date hora) {
        this.id = id;
        this.montoTransaccion = montoTransaccion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMontoTransaccion() {
        return this.montoTransaccion;
    }

    public void setMontoTransaccion(double montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public Calendar getFecha() {
        return this.fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return this.hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

}

