package com.grupo4.eflete.Model;


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
    private REFRIGERACION refrigeracion;
    private EstadoEnvio estadoEnvio;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Paquete> paquetes = new ArrayList<Paquete>();

    public Envio() {
    }

    public Envio(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
        this.refrigeracion = REFRIGERACION.Ninguno;
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

    public REFRIGERACION getRefrigeracion() {
        return refrigeracion;
    }

    public void setRefrigeracion(REFRIGERACION refrigeracion) {
        this.refrigeracion = refrigeracion;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public EstadoEnvio getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadoEnvio estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }
}
