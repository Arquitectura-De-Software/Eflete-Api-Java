package com.grupo4.eflete.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Paquete")
public class Paquete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private boolean esFragil;
    @NotNull
    private double ancho;
    @NotNull
    private double alto;
    @NotNull
    private double profundidad;
    @NotNull
    private double peso;

    public Paquete() {
    }

    public Paquete(@NotNull boolean esFragil, @NotNull double ancho, @NotNull double alto, @NotNull double profundidad, @NotNull double peso) {
        this.esFragil = esFragil;
        this.ancho = ancho;
        this.alto = alto;
        this.profundidad = profundidad;
        this.peso = peso;
    }

    public boolean getEsFragil(){
        return this.esFragil;
    }

    public void setEsFragil(boolean esFragil){
        this.esFragil = esFragil;
    }

    public Long getId() {
        return id;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
