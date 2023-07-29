package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.ChecksMantenimiento;

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
