package com.desarrollo.sem.model;


import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class UsuarioConductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*
    @OneToMany
    private TransaccionesCC transacciones;
    */

    private String mail;
    private String contraseña;
    private double saldo;
    private int DNI;

    public UsuarioConductor() { }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getDNI() {
        return this.DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", mail='" + getMail() + "'" +
                ", contraseña='" + getContraseña() + "'" +
                ", saldo='" + getSaldo() + "'" +
                ", DNI='" + getDNI() + "'" +
        "}";
    }

}
