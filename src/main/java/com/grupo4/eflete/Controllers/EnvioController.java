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
import org.springframework.transaction.annotation.Transactional;
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
        return modelMapper.map(envioRepository.getOne(id), EnvioDTO.class);
    }

    @PostMapping("/envios")
    @ResponseBody public ResponseEntity<EnvioDTO> createEnvio(@RequestBody Envio envio) {
        Envio savedEnvio = envioRepository.save(envio);

        updateEstadoActual(savedEnvio);

        EnvioDTO envioDTO = modelMapper.map(envioRepository.getOne(envio.getId()), EnvioDTO.class);

        return ResponseEntity.ok(envioDTO);
    }

    @Transactional
    void updateEstadoActual(Envio envio){
        estadoEnvioRepository.saveEstadoInicial(envio.getOrigen(), CodigoEstadoEnvio.INICIADO.ordinal(), envio.getId());
        Long lastId = estadoEnvioRepository.getLastId();
        envioRepository.updateEstadoActual(lastId, envio.getId());
    }


}
