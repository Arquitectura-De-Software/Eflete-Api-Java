package com.grupo4.eflete.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Paquete")
public class Paquete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean esFragil;


    public boolean getEsFragil(){
        return this.esFragil;
    }

    public void setEsFragil(boolean esFragil){
        this.esFragil = esFragil;
    }
}
