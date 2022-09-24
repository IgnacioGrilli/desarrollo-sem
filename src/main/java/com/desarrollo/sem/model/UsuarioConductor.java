package com.desarrollo.sem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;

@Entity
public class UsuarioConductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "numero_cuenta", referencedColumnName = "numeroCuenta") 
    private CuentaCorriente cuenta;

    private String mail;
    private String contraseña;
    private double saldo;
    private int DNI;

    public UsuarioConductor() {
    }


    public UsuarioConductor(long id, CuentaCorriente cuenta, String mail, String contraseña, double saldo, int DNI) {
        this.id = id;
        this.cuenta = cuenta;
        this.mail = mail;
        this.contraseña = contraseña;
        this.saldo = saldo;
        this.DNI = DNI;
    }
    

    public CuentaCorriente getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(CuentaCorriente cuenta) {
        this.cuenta = cuenta;
    }

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
            ", cuenta='" + getCuenta() + "'" +
            ", mail='" + getMail() + "'" +
            ", contraseña='" + getContraseña() + "'" +
            ", saldo='" + getSaldo() + "'" +
            ", DNI='" + getDNI() + "'" +
            "}";
    }

}
