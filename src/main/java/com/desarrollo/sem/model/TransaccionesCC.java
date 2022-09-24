package com.desarrollo.sem.model;



import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TransaccionesCC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double montoTransaccion;

    @Temporal (TemporalType.DATE)
    private Calendar fecha;

    @Temporal (TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CC_id",nullable = false)
    private CuentaCorriente cuenta;

    /*     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bank_id", nullable=false)
    private Bank bank; */


    public TransaccionesCC(long id, double montoTransaccion, Calendar fecha, Date hora, CuentaCorriente cuenta) {
        this.id = id;
        this.montoTransaccion = montoTransaccion;
        this.fecha = fecha;
        this.hora = hora;
        this.cuenta = cuenta;
    }


    public TransaccionesCC() {
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

    public CuentaCorriente getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(CuentaCorriente cuenta) {
        this.cuenta = cuenta;
    }






    
}
