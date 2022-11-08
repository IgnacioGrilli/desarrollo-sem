package com.desarrollo.sem.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Entity
public class RegistroPagosDiarios {

    @Id
    @GeneratedValue (generator = "UUID")
    private UUID uuid = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "obleista_id", nullable = true)
    private UsuarioObleista usuarioObleista;

    /*
     * @ManyToOne
     * 
     * @JoinColumn (name="condPatenteID")
     * private ConductorPatente conductorPatente;
     */

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patente_id", nullable = false)
    private Patente patente;

    @Temporal (TemporalType.DATE)
    private Calendar fecha;

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = true)
    private UsuarioConductor conductor;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "America/Argentina/Buenos_Aires")
    private Date horaInicio;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "America/Argentina/Buenos_Aires")
    private Date horaFin;

    private int valor;

    public RegistroPagosDiarios() {
    }


    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public UsuarioConductor getConductor() {
        return this.conductor;
    }

    public void setConductor(UsuarioConductor conductor) {
        this.conductor = conductor;
    }

    public UsuarioObleista getUsuarioObleista() {
        return this.usuarioObleista;
    }

    public void setUsuarioObleista(UsuarioObleista usuarioObleista) {
        this.usuarioObleista = usuarioObleista;
    }

    /*
     * public ConductorPatente getConductorPatente() {
     * return this.conductorPatente;
     * }
     * 
     * public void setConductorPatente(ConductorPatente conductorPatente) {
     * this.conductorPatente = conductorPatente;
     * }
     */

    public Date getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return this.horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    

}
