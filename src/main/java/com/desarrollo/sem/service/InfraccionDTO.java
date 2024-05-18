package com.desarrollo.sem.service;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InfraccionDTO {


    @Id
    private String id;
    private Calendar fecha;
    private String patente;
    private Date hora;

     // Constructor
     public InfraccionDTO(String id, Calendar fecha, String patente, Date hora) {
        this.id = id;
        this.fecha = fecha;
        this.patente = patente;
        this.hora = hora;
    }

    public InfraccionDTO() {
    }

    

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return this.fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getPatente() {
        return this.patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Date getHora() {
        return this.hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

     // Método toString
     @Override
     public String toString() {
         return "InfraccionDTO{" +
                 "id=" + id +
                 ", fecha=" + (fecha != null ? fecha.getTime() : null) +
                 ", patente='" + patente + '\'' +
                 ", hora=" + hora +
                 '}';
     }



}
