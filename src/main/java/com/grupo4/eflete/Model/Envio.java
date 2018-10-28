package com.grupo4.eflete.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Envio")
public class Envio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origen;
    private String destino;
    private Refrigeracion refrigeracion;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_estado_actual")
    private EstadoEnvio estadoActual;
    @JsonIgnore
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "fk_envios_estados")
    private List<EstadoEnvio> estadoEnvios = new ArrayList<>();

    public Envio() {
    }

    public Envio(String origen, String destino, Refrigeracion refrigeracion) {
        this.origen = origen;
        this.destino = destino;
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

    public Refrigeracion getRefrigeracion() {
        return refrigeracion;
    }

    public void setRefrigeracion(Refrigeracion refrigeracion) {
        this.refrigeracion = refrigeracion;
    }

    public List<EstadoEnvio> getEstadoEnvios() {
        return estadoEnvios;
    }

    public void setEstadoEnvios(List<EstadoEnvio> estadoEnvios) {
        this.estadoEnvios = estadoEnvios;
    }

    public EstadoEnvio getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoEnvio estadoActual) {
        this.estadoActual = estadoActual;
        this.getEstadoEnvios().add(estadoActual);
    }

}
