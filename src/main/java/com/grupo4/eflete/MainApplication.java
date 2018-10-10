package com.grupo4.eflete;

import com.grupo4.eflete.Model.Paquete;
import com.grupo4.eflete.Repositories.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private PaqueteRepository paqueteRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Paquete paquete = new Paquete();
        paquete.setEsFragil(false);
        paqueteRepository.save(paquete);
    }
}
