package com.desarrollo.sem.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RegistroPatentesDiarios {

    @Id
    /* @GeneratedValue (strategy = GenerationType.UUID) */ 
/*     @Type () 
    @GeneratedValue(generator = "UUID") */
    @GeneratedValue (generator = "UUID")
    private UUID uuid = UUID.randomUUID();
   

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

    private float longitud;
    private float latitud;
    private String foto;


    public RegistroPatentesDiarios() {
    }



    public RegistroPatentesDiarios(UUID uuid, UsuarioObleista usuarioObleista, Patente patente, Calendar fecha, Date hora, float longitud, float latitud, String foto) {
        this.uuid = uuid;
        this.usuarioObleista = usuarioObleista;
        this.patente = patente;
        this.fecha = fecha;
        this.hora = hora;
        this.longitud = longitud;
        this.latitud = latitud;
        this.foto = foto;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public float getLongitud() {
        return this.longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return this.latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
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
