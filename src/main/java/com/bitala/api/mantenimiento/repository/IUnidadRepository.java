package com.bitala.api.mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.api.mantenimiento.models.Unidad;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - UNIDAD
 * 
 * version 1.0
 */

@Repository
public interface IUnidadRepository extends JpaRepository <Unidad, Long> {
    
}
