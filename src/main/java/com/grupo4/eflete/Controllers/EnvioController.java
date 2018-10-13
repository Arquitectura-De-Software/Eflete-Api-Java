package com.grupo4.eflete.Controllers;

import com.grupo4.eflete.Model.CodigoEstadoEnvio;
import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.Model.EstadoEnvio;
import com.grupo4.eflete.Repositories.EnvioRepository;
import com.grupo4.eflete.Repositories.EstadoEnvioRepository;
import com.grupo4.eflete.dtos.EnvioDTO;
import com.grupo4.eflete.dtos.EstadoEnvioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EnvioController {

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private EstadoEnvioRepository estadoEnvioRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/envios/{id}")
    public EnvioDTO getEnvioById(@PathVariable Long id) {

        Envio getEnvio = envioRepository.getOne(id);
        EstadoEnvio estado = getEnvio.getEstadoActual();
        EnvioDTO envioDTO = new EnvioDTO();
        envioDTO.setOrigen(getEnvio.getOrigen());
        envioDTO.setDestino(getEnvio.getDestino());
        envioDTO.setEstadoActual(modelMapper.map(estado, EstadoEnvioDto.class));
        envioDTO.setRefrigeracion(getEnvio.getRefrigeracion());
        envioDTO.setId(getEnvio.getId());

        List<EstadoEnvioDto> estados = new ArrayList<>();

        getEnvio.getEstadoEnvios().forEach(est -> {
            EstadoEnvioDto edto = modelMapper.map(est, EstadoEnvioDto.class);
            estados.add(edto);
        });

        envioDTO.setEstadoEnvios(estados);
        return envioDTO;

    }

    @PostMapping("/envios")
    @ResponseBody public ResponseEntity<EnvioDTO> createEnvio(@RequestBody Envio envio) {
        Envio savedEnvio = envioRepository.save(envio);

        estadoEnvioRepository.saveEstadoInicial(savedEnvio.getOrigen(), CodigoEstadoEnvio.INICIADO.ordinal(), savedEnvio.getId());
        Long lastId = estadoEnvioRepository.getLastId();

        envioRepository.updateEstadoActual(lastId, savedEnvio.getId());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/")
                .buildAndExpand(savedEnvio.getId()).toUri();

        EnvioDTO envioDTO = modelMapper.map(savedEnvio, EnvioDTO.class);


        return ResponseEntity.ok(envioDTO);
    }


}
