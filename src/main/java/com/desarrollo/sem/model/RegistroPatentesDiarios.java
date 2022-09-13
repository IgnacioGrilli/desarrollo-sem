package com.desarrollo.sem.model;

import javax.persistence.*;

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

/*
    @Temporal (TemporalType.DATE)
    private Calendar fecha;

    @Temporal (TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Calendar hora;
*/

    public RegistroPatentesDiarios() {
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

/* 
    public Calendar getFecha() {
        return this.fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Calendar getHora() {
        return this.hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }
 */
    
}
