package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.TiposVehiculos;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - TIPOSVEHICULOS
 * 
 * version 1.0
 */

@Repository
public interface ITiposVehiculosRepository extends JpaRepository <TiposVehiculos, Long> {
    
}
