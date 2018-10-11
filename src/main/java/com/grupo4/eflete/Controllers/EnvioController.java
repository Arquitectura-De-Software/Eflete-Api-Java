package com.grupo4.eflete.Controllers;

import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.Repositories.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EnvioController {

    @Autowired
    private EnvioRepository envioRepository;

    @GetMapping("envio/get")
    @ResponseBody
    public Envio getEnvio(@RequestParam(name="idEnvio") Long idEnvio){
        return envioRepository.getOne(idEnvio);
    }

}
