package com.grupo4.eflete.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EstadoEnvio")
public class EstadoEnvio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CODIGOESTADOENVIO codigoestadoenvio;
    private String ubicacion;

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public CODIGOESTADOENVIO getCodigoestadoenvio() {
        return codigoestadoenvio;
    }

    public void setCodigoestadoenvio(CODIGOESTADOENVIO codigoestadoenvio) {
        this.codigoestadoenvio = codigoestadoenvio;
    }
}
