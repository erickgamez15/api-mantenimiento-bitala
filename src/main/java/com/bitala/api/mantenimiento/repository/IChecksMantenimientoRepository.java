package com.bitala.api.mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.api.mantenimiento.models.ChecksMantenimiento;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - CHECKSMANTENIMIENTO
 * 
 * version 1.0
 */

@Repository
public interface IChecksMantenimientoRepository extends JpaRepository <ChecksMantenimiento, Long> {
    
}
