package com.grupo4.eflete.Controllers;

import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.Model.EstadoEnvio;
import com.grupo4.eflete.Repositories.EnvioRepository;
import com.grupo4.eflete.Repositories.EstadoEnvioRepository;
import com.grupo4.eflete.dtos.EstadoEnvioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class EstadoEnvioController {

    @Autowired
    private EstadoEnvioRepository estadoEnvioRepository;

    @Autowired
    private EnvioRepository envioRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/estadoenvios/{id}")
    public EstadoEnvio getEstadoEnvioById(@PathVariable Long id) {
        return estadoEnvioRepository.getOne(id);
    }

    @PostMapping("/estadoenvios/{idEnvio}")
    @ResponseBody public ResponseEntity<EstadoEnvioDto> createEstadoEnvio(@RequestBody EstadoEnvio estadoEnvio, @PathVariable Long idEnvio) {
        Envio getEnvio = envioRepository.getOne(idEnvio);
        estadoEnvio.setEnvio(getEnvio);
        EstadoEnvio savedEstado = estadoEnvioRepository.save(estadoEnvio);

        envioRepository.updateEstadoActual(savedEstado.getId(), getEnvio.getId());

        EstadoEnvioDto estadoEnvioDto = modelMapper.map(savedEstado, EstadoEnvioDto.class);


        return ResponseEntity.ok(estadoEnvioDto);

    }


}
