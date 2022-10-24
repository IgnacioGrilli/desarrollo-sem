package com.desarrollo.sem.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
public class RegistroPatentesDiarios {

    @Id
    /* @GeneratedValue (strategy = GenerationType.UUID) */ 
/*     @Type () 
    @GeneratedValue(generator = "UUID") */
    @GeneratedValue (generator = "UUID")
    private UUID uuid = UUID.randomUUID();
    //private UUID id;
    //

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


    public RegistroPatentesDiarios(UUID id, UsuarioObleista usuarioObleista, Patente patente, Calendar fecha, Date hora) {
        this.uuid = id;
        this.usuarioObleista = usuarioObleista;
        this.patente = patente;
        this.fecha = fecha;
        this.hora = hora;
    }


    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /* public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    } */

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
