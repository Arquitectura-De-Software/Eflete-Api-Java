package com.grupo4.eflete.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EstadoEnvio")
public class EstadoEnvio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CodigoEstadoEnvio codigoestadoenvio;
    private String ubicacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_envios_estados")
    private Envio envio;



    public EstadoEnvio() {
    }

    public EstadoEnvio(String ubicacion, CodigoEstadoEnvio codigo) {
        this.codigoestadoenvio = codigo;
        this.ubicacion = ubicacion;
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
