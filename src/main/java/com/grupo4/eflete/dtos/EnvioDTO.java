package com.grupo4.eflete.dtos;

import com.grupo4.eflete.Model.CodigoEstadoEnvio;
import com.grupo4.eflete.Model.Refrigeracion;

import java.util.List;

public class EnvioDTO {
    private Long id;
    private String origen;
    private String destino;
    EstadoEnvioDto estadoActual;
    private Refrigeracion refrigeracion;
    private List<EstadoEnvioDto> estadoEnvios;

    public EnvioDTO() {
    }

    public EstadoEnvioDto getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoEnvioDto estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Refrigeracion getRefrigeracion() {
        return refrigeracion;
    }

    public void setRefrigeracion(Refrigeracion refrigeracion) {
        this.refrigeracion = refrigeracion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public List<EstadoEnvioDto> getEstadoEnvios() {
        return estadoEnvios;
    }

    public void setEstadoEnvios(List<EstadoEnvioDto> estadoEnvios) {
        this.estadoEnvios = estadoEnvios;
    }
}
