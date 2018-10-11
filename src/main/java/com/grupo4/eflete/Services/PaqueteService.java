package com.grupo4.eflete.Services;

import com.grupo4.eflete.Model.Paquete;
import com.grupo4.eflete.Repositories.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaqueteService {

    @Autowired
    private PaqueteRepository paqueteRepository;

    public Paquete CreatePaquete(double ancho, double alto, double profundidad, boolean esFragil, double peso){
        Paquete paquete = new Paquete(esFragil,ancho,alto,profundidad,peso);
        paqueteRepository.save(paquete);
        return paquete;
    }

}
