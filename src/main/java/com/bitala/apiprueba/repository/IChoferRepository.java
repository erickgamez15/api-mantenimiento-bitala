package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.Chofer;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - CHOFER
 * 
 * version 1.0
 */

@Repository
public interface IChoferRepository extends JpaRepository <Chofer, Long> {
    
}
