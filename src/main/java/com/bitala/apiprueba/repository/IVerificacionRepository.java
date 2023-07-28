package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.Verificacion;

@Repository
public interface IVerificacionRepository extends JpaRepository<Verificacion, Long> {
    
}
