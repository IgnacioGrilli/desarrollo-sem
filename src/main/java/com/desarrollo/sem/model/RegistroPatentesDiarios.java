package com.desarrollo.sem.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RegistroPatentesDiarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn (name="obleistaID")
    private UsuarioObleista usuarioObleista;

    @ManyToOne
    @JoinColumn (name="patenteID")
    private Patente patente;


    @Temporal (TemporalType.DATE)
    private Calendar fecha;

    @Temporal (TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "America/Argentina/Buenos_Aires")
    private Date hora;


    public RegistroPatentesDiarios() {
    }


    public RegistroPatentesDiarios(long id, UsuarioObleista usuarioObleista, Patente patente, Calendar fecha, Date hora) {
        this.id = id;
        this.usuarioObleista = usuarioObleista;
        this.patente = patente;
        this.fecha = fecha;
        this.hora = hora;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UsuarioObleista getUsuarioObleista() {
        return this.usuarioObleista;
    }

    public void setUsuarioObleista(UsuarioObleista usuarioObleista) {
        this.usuarioObleista = usuarioObleista;
    }

    public Patente getPatente() {
        return this.patente;
    }

    public void setPatente(Patente patente) {
        this.patente = patente;
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
