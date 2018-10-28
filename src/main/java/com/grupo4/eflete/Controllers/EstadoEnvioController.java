package com.grupo4.eflete.Controllers;

import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.Model.EstadoEnvio;
import com.grupo4.eflete.Services.EnvioService;
import com.grupo4.eflete.Services.EstadoEnvioService;
import com.grupo4.eflete.dtos.EstadoEnvioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstadoEnvioController {

    @Autowired
    private EstadoEnvioService estadoEnvioService;

    @GetMapping("/estadoenvios/{id}")
    public EstadoEnvioDTO getEstadoEnvioById(@PathVariable Long id)
    {
        return estadoEnvioService.getEstadoEnvioDTOById(id);
    }

    @PostMapping("/estadoenvios/{idEnvio}")
    @ResponseBody
    public ResponseEntity<EstadoEnvioDTO> updateEstadoEnvio(@RequestBody EstadoEnvioDTO estadoEnvioDTO, @PathVariable Long idEnvio) {
        EstadoEnvioDTO savedEstadoEnvioDTO = estadoEnvioService.setEstadoEnvioToEnvioByDTOAndId(estadoEnvioDTO,idEnvio);
        return ResponseEntity.ok(savedEstadoEnvioDTO);
    }

}
