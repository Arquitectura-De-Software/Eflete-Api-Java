package com.grupo4.eflete.dtos;

import com.grupo4.eflete.Model.Refrigeracion;

import java.util.List;

public class EnvioDTO {
    private Long id;
    private String origen;
    private String destino;
    private Long idEstadoActual;
    private Refrigeracion refrigeracion;
    private List<EstadoEnvioDTO> estadoEnvios;

    public EnvioDTO() {
    }

    public Long getIdEstadoActual() {
        return idEstadoActual;
    }

    public void setIdEstadoActual(Long idEstadoActual) {
        this.idEstadoActual = idEstadoActual;
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

    public List<EstadoEnvioDTO> getEstadoEnvios() {
        return estadoEnvios;
    }

    public void setEstadoEnvios(List<EstadoEnvioDTO> estadoEnvios) {
        this.estadoEnvios = estadoEnvios;
    }
}