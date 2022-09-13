package com.desarrollo.sem.servlet;

import java.util.Collection;

import com.desarrollo.sem.models.RegistroPatentesDiarios;

public interface RegistroPatDiariosSevice {

    public Collection<RegistroPatentesDiarios> findAll();

}
