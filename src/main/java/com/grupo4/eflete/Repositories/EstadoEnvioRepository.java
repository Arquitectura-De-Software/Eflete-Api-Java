package com.grupo4.eflete.Repositories;

import com.grupo4.eflete.Model.CodigoEstadoEnvio;
import com.grupo4.eflete.Model.EstadoEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EstadoEnvioRepository extends JpaRepository<EstadoEnvio, Long> {

    @Transactional
    @Modifying
    @Query(value ="insert into estado_envio (codigoestadoenvio, ubicacion, fk_envios_estados) values (?2,?1,?3)", nativeQuery = true)
    void saveEstadoInicial(String ubicacion, int iniciado, Long id);

    @Transactional
    @Query(value ="SELECT MAX(id) FROM estado_envio", nativeQuery = true)
    Long getLastId();

}
