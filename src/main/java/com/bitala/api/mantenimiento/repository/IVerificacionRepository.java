package com.bitala.api.mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.api.mantenimiento.models.Verificacion;

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
