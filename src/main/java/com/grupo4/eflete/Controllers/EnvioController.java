package com.grupo4.eflete.Controllers;

import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.Repositories.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class EnvioController {

    @Autowired
    private EnvioRepository envioRepository;

    @GetMapping("/envios/{id}")
    public Envio getEnvioById(@PathVariable Long id) {
        return envioRepository.getOne(id);
    }

    @PostMapping("/envios")
    public ResponseEntity<Envio> createEnvio(@RequestBody Envio envio) {
        Envio savedStudent = envioRepository.save(envio);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();

        return ResponseEntity.created(location).build();

    }


}
