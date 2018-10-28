package com.grupo4.eflete.Services;

import com.grupo4.eflete.Model.CodigoEstadoEnvio;
import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.Model.EstadoEnvio;
import com.grupo4.eflete.Repositories.EstadoEnvioRepository;
import com.grupo4.eflete.dtos.EstadoEnvioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoEnvioService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private EstadoEnvioRepository estadoEnvioRepository;

    @Autowired
    private EnvioService envioService;



    public EstadoEnvioDTO getEstadoEnvioDTOById(long idEstadoEnvio){
        EstadoEnvio estadoEnvio = estadoEnvioRepository.getOne(idEstadoEnvio);
        return modelMapper.map(estadoEnvio, EstadoEnvioDTO.class);
    }

    public EstadoEnvioDTO setEstadoEnvioToEnvioByDTOAndId(EstadoEnvioDTO estadoEnvioDTO, long idEnvio){
        EstadoEnvio estadoEnvio = new EstadoEnvio(estadoEnvioDTO.getUbicacion(), estadoEnvioDTO.getCodigoEstadoEnvio());
        Envio envio = envioService.getEnvio(idEnvio);
        estadoEnvio.setEnvio(envio);
        estadoEnvioRepository.save(estadoEnvio);
        envioService.saveNewEstadoEnvio(envio, estadoEnvio);
        return modelMapper.map(estadoEnvio, EstadoEnvioDTO.class);
    }
}
