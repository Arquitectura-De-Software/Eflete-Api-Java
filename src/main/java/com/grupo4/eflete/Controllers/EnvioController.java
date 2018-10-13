package com.grupo4.eflete.Controllers;

import com.grupo4.eflete.Model.CodigoEstadoEnvio;
import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.Model.EstadoEnvio;
import com.grupo4.eflete.Repositories.EnvioRepository;
import com.grupo4.eflete.Repositories.EstadoEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigInteger;
import java.net.URI;

@RestController
public class EnvioController {

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private EstadoEnvioRepository estadoEnvioRepository;

    @GetMapping("/envios/{id}")
    public Envio getEnvioById(@PathVariable Long id) {
        return envioRepository.getOne(id);
    }

    @PostMapping("/envios")
    @ResponseBody public ResponseEntity<Envio> createEnvio(@RequestBody Envio envio) {
        Envio savedEnvio = envioRepository.save(envio);



        estadoEnvioRepository.saveEstadoInicial(savedEnvio.getOrigen(), CodigoEstadoEnvio.INICIADO.ordinal(), savedEnvio.getId());
        Long lastId = estadoEnvioRepository.getLastId();

        envioRepository.updateEstadoActual(lastId, savedEnvio.getId());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/")
                .buildAndExpand(savedEnvio.getId()).toUri();


        return ResponseEntity.ok(savedEnvio);
    }


}
