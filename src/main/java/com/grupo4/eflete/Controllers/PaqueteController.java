package com.grupo4.eflete.Controllers;

import com.grupo4.eflete.Model.Paquete;
import com.grupo4.eflete.Repositories.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaqueteController {

    @Autowired
    private PaqueteRepository paqueteRepository;

    @GetMapping("/paquetes/{id}")
    @ResponseBody
    public Paquete getPaqueteById(@PathVariable Long id){
        return paqueteRepository.getOne(id);
    }

}
