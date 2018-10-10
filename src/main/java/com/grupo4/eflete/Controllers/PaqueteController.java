package com.grupo4.eflete.Controllers;

import com.grupo4.eflete.Model.Paquete;
import com.grupo4.eflete.Repositories.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaqueteController {

    @Autowired
    private PaqueteRepository paqueteRepository;

    @GetMapping("paquete/get")
    @ResponseBody
    public Paquete getPaquete(@RequestParam(name="idPaquete") Long idPaquete){
        return paqueteRepository.getOne(idPaquete);
    }

}
