package com.grupo4.eflete;

import com.grupo4.eflete.Model.Envio;
import com.grupo4.eflete.Model.Paquete;
import com.grupo4.eflete.Repositories.EnvioRepository;
import com.grupo4.eflete.Repositories.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private PaqueteRepository paqueteRepository;
    @Autowired
    private EnvioRepository envioRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
    }
}
