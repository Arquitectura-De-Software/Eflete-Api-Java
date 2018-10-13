package com.grupo4.eflete.dtos;

import com.grupo4.eflete.Model.CodigoEstadoEnvio;

public class EstadoEnvioDto {
    private CodigoEstadoEnvio codigoEstadoEnvio;
    private String ubicacion;

    public EstadoEnvioDto() {
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
