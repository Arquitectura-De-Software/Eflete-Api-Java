package com.grupo4.eflete.Services;

import com.grupo4.eflete.Model.CODIGOESTADOENVIO;
import com.grupo4.eflete.Model.EstadoEnvio;
import com.grupo4.eflete.Repositories.EstadoEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoEnvioService {

    @Autowired
    private EstadoEnvioRepository estadoEnvioRepository;

    public EstadoEnvio InitializeEstadoEnvio(String origen){
        EstadoEnvio estadoEnvio = new EstadoEnvio();
        estadoEnvio.setUbicacion(origen);
        estadoEnvio.setCodigoestadoenvio(CODIGOESTADOENVIO.Iniciado);
        estadoEnvioRepository.save(estadoEnvio);
        return  estadoEnvio;
    }
}
