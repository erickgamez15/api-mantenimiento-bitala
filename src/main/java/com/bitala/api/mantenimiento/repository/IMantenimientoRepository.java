package com.bitala.api.mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.api.mantenimiento.models.Mantenimiento;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - MANTENIMIENTO
 * 
 * version 1.0
 */

@Repository
public interface IMantenimientoRepository extends JpaRepository <Mantenimiento, Long> {
    
}
