package com.desarrollo.sem.model;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
/*@Table(name = "cuenta")*/
public class CuentaCorriente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long numeroCuenta;

    @OneToMany(/*mappedBy = "cuenta"*/)
    private Collection<TransaccionesCC> transaccion;

    @OneToOne(/*mappedBy = "cuenta"*/)
    private UsuarioConductor conductor;

    @Temporal(TemporalType.DATE)
    private Calendar fechaCreacion;

    public CuentaCorriente() {
    }

    public CuentaCorriente(long id, long numeroCuenta, Collection<TransaccionesCC> transaccion,
            UsuarioConductor conductor, Calendar fechaCreacion) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.transaccion = transaccion;
        this.conductor = conductor;
        this.fechaCreacion = fechaCreacion;
    }

    public long getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<TransaccionesCC> getTransaccion() {
        return this.transaccion;
    }

    public void setTransaccion(Collection<TransaccionesCC> transaccion) {
        this.transaccion = transaccion;
    }

    public UsuarioConductor getConductor() {
        return this.conductor;
    }

    public void setConductor(UsuarioConductor conductor) {
        this.conductor = conductor;
    }

    public Calendar getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", numeroCuenta='" + getNumeroCuenta() + "'" +
            ", transaccion='" + getTransaccion() + "'" +
            ", conductor='" + getConductor() + "'" +
            ", fechaCreacion='" + getFechaCreacion() + "'" +
            "}";
    }


}