package com.grupo4.eflete.Helpers;

import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.dtos.EnvioDTO;
import org.modelmapper.ModelMapper;

public class Converter extends ModelMapper {

    public EnvioDTO map(Envio envio, Class<EnvioDTO> destinationType){
        EnvioDTO envioDTO = super.map(envio, destinationType);
        envioDTO.setIdEstadoActual(envio.getEstadoActual().getId());
        return  envioDTO;
    }

}
