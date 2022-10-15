package com.desarrollo.sem.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TransaccionesCC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double montoTransaccion;

    @Temporal(TemporalType.DATE)
    private Calendar fecha;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date hora;

    //@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", nullable = false, referencedColumnName = "id")
    private UsuarioConductor cuenta;


    public TransaccionesCC( double montoTransaccion, Calendar fecha, Date hora, UsuarioConductor cuenta) {
        this.montoTransaccion = montoTransaccion;
        this.fecha = fecha;
        this.hora = hora;
        this.cuenta = cuenta;
    }


    public TransaccionesCC(long id, double montoTransaccion, Calendar fecha, Date hora) {
        this.id = id;
        this.montoTransaccion = montoTransaccion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public long getId() {
        return this.id;
    }

    public UsuarioConductor getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(UsuarioConductor cuenta) {
        this.cuenta = cuenta;
    }

    public void setId(long id) {
        this.id = id;
    }



    public TransaccionesCC() {
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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", montoTransaccion='" + getMontoTransaccion() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", hora='" + getHora() + "'" +
            ", cuenta='" + getCuenta() + "'" +
            "}";
    }



}
