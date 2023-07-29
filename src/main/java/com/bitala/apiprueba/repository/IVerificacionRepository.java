package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.Verificacion;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - VERIFICACION
 * 
 * version 1.0
 */

@Repository
public interface IVerificacionRepository extends JpaRepository <Verificacion, Long> {
    
}
