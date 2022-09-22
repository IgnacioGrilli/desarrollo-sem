package com.desarrollo.sem.model;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Entity
public class RegistroPagosDiarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn (name="obleistaID", nullable=true)
    private UsuarioObleista usuarioObleista;


    @ManyToOne
    @JoinColumn (name="condPatenteID")
    private ConductorPatente conductorPatente;


    @Temporal (TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date horaInicio;


    @Temporal (TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date horaFin;


    private int valor;


    public RegistroPagosDiarios() {
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

    public ConductorPatente getConductorPatente() {
        return this.conductorPatente;
    }

    public void setConductorPatente(ConductorPatente conductorPatente) {
        this.conductorPatente = conductorPatente;
    }

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
