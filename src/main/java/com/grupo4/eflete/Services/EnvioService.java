package com.grupo4.eflete.Services;

import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.Model.EstadoEnvio;
import com.grupo4.eflete.Model.Paquete;
import com.grupo4.eflete.Repositories.EnvioRepository;
import com.grupo4.eflete.dtos.EnvioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EnvioService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private EnvioRepository envioRepository;


    public Envio getEnvio(long idEnvio){
        return envioRepository.getOne(idEnvio);
    }

    public void saveNewEstadoEnvio(Envio envio, EstadoEnvio estadoEnvio){
        envio.setEstadoActual(estadoEnvio);
        envioRepository.save(envio);
    }

    public EnvioDTO getEnvioDTOById(long idEnvio){
        Envio envio = getEnvio(idEnvio);
        return modelMapper.map(envio, EnvioDTO.class);
    }

    public EnvioDTO saveEnvioFromDTO(EnvioDTO envioDTO){
        Envio savedEnvio = new Envio(envioDTO.getOrigen(), envioDTO.getDestino(), envioDTO.getRefrigeracion());
        envioRepository.save(savedEnvio);
        envioDTO.setId(savedEnvio.getId());
        return envioDTO;
    }

}
