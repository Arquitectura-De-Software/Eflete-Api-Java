package com.grupo4.eflete.Controllers;

import com.grupo4.eflete.Services.EnvioService;
import com.grupo4.eflete.dtos.EnvioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping("/envios/{id}")
    public EnvioDTO getEnvioById(@PathVariable Long id) {
        return envioService.getEnvioDTOById(id);
    }

    @PostMapping("/envios")
    @ResponseBody public ResponseEntity<EnvioDTO> createEnvio(@RequestBody EnvioDTO envioDTO) {
        EnvioDTO envioDTOWithId =  envioService.saveEnvioFromDTO(envioDTO);
        return ResponseEntity.ok(envioDTOWithId);
    }

}
