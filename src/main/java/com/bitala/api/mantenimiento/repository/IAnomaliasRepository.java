package com.bitala.api.mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.api.mantenimiento.models.Anomalias;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - ANOMALIAS
 * 
 * version 1.0
 */

@Repository
public interface IAnomaliasRepository extends JpaRepository <Anomalias, Long> {
    
}
