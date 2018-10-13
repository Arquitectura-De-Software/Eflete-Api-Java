package com.grupo4.eflete.Repositories;


import com.grupo4.eflete.Model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
    @Transactional
    @Modifying
    @Query(value ="update envio e set e.fk_estado_actual = ?1 where e.id = ?2", nativeQuery = true)
    void updateEstadoActual(long idEstadoActual, long idEstado);
}
