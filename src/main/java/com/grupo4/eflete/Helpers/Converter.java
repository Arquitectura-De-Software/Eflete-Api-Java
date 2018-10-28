package com.grupo4.eflete.Helpers;

import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.dtos.EnvioDTO;
import com.grupo4.eflete.dtos.EstadoEnvioDTO;
import org.modelmapper.ModelMapper;

public class Converter extends ModelMapper {

    public EnvioDTO map(Envio envio, Class<EnvioDTO> destinationType){
        EnvioDTO envioDTO = super.map(envio, destinationType);
        EstadoEnvioDTO estadoEnvioDTO = super.map(envio.getEstadoActual(), EstadoEnvioDTO.class);
        envioDTO.setEstadoActual(estadoEnvioDTO);
        return  envioDTO;
    }

}
