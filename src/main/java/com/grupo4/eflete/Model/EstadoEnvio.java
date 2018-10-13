package com.grupo4.eflete.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EstadoEnvio")
public class EstadoEnvio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @JsonProperty("CodigoEstadoEnvio")
    private CodigoEstadoEnvio codigoestadoenvio;
    @JsonProperty("ubicacion")
    private String ubicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_envios_estados")
    private Envio envio;



    public EstadoEnvio() {
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public CodigoEstadoEnvio getCodigoestadoenvio() {
        return codigoestadoenvio;
    }

    public void setCodigoestadoenvio(CodigoEstadoEnvio codigoestadoenvio) {
        this.codigoestadoenvio = codigoestadoenvio;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public Long getId() {
        return id;
    }
}
