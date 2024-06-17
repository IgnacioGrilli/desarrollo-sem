package com.desarrollo.sem.service;

public class ObleistaSummaryDTO {
    private Long obleistaId;
    private String obleistaNombre;
    private Double totalValor;
    private Long totalRegistros;


    public ObleistaSummaryDTO(Long obleistaId, String obleistaNombre, Double totalValor, Long totalRegistros) {
        this.obleistaId = obleistaId;
        this.obleistaNombre = obleistaNombre;
        this.totalValor = totalValor;
        this.totalRegistros = totalRegistros;
    }


    public ObleistaSummaryDTO() {
    }



    public Long getObleistaId() {
        return obleistaId;
    }

    public void setObleistaId(Long obleistaId) {
        this.obleistaId = obleistaId;
    }

    public String getObleistaNombre() {
        return obleistaNombre;
    }

    public void setObleistaNombre(String obleistaNombre) {
        this.obleistaNombre = obleistaNombre;
    }

    public Double getTotalValor() {
        return totalValor;
    }

    public void setTotalValor(Double totalValor) {
        this.totalValor = totalValor;
    }

    public Long getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(Long totalRegistros) {
        this.totalRegistros = totalRegistros;
    }


    @Override
    public String toString() {
        return "ObleistaSummaryDTO [obleistaId=" + obleistaId + ", obleistaNombre=" + obleistaNombre + ", totalValor="
                + totalValor + ", totalRegistros=" + totalRegistros + "]";
    }


}