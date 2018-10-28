package com.grupo4.eflete.dtos;

import com.grupo4.eflete.Model.CodigoEstadoEnvio;

public class EstadoEnvioDTO {

    private Long id;
    private CodigoEstadoEnvio codigoEstadoEnvio;
    private String ubicacion;

    public EstadoEnvioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public CodigoEstadoEnvio getCodigoEstadoEnvio() {
        return codigoEstadoEnvio;
    }

    public void setCodigoEstadoEnvio(CodigoEstadoEnvio codigoEstadoEnvio) {
        this.codigoEstadoEnvio = codigoEstadoEnvio;
    }
}
