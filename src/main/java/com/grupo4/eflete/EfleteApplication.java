package com.grupo4.eflete;

import com.grupo4.eflete.Model.Paquete;
import com.grupo4.eflete.Repositories.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EfleteApplication {

    @Autowired
    private static PaqueteRepository paqueteRepository;

	public static void main(String[] args) {

        Paquete paquete = new Paquete();
        paquete.setEsFragil(true);
        paqueteRepository.save(paquete);

		SpringApplication.run(EfleteApplication.class, args);
	}
}