package com.grupo4.eflete.Services;

import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.Model.EstadoEnvio;
import com.grupo4.eflete.Model.Paquete;
import com.grupo4.eflete.Repositories.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private EstadoEnvioService estadoEnvioService;

    public Envio InitializeEnvio(String origen, String destino, List<Paquete> paquetes){
        Envio envio = new Envio(origen,destino);
        EstadoEnvio estadoEnvio = estadoEnvioService.InitializeEstadoEnvio(origen);
        envio.setEstadoEnvio(estadoEnvio);
        envio.setPaquetes(paquetes);
        envioRepository.save(envio);
        return envio;
    }
}
