package com.desarrollo.sem.model;
import javax.persistence.*;

@Entity
public class UsuarioPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn (name="obleistaID", nullable=true)
    private UsuarioObleista usuarioObleista;


    @ManyToOne
    @JoinColumn (name="condPatenteID")
    private ConductorPatente conductorPatente;



    public UsuarioPago() {
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

}