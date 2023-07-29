package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.FotosAnomalia;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - FOTOSANOMALIA
 * 
 * version 1.0
 */

@Repository
public interface IFotosAnomaliaRepository extends JpaRepository <FotosAnomalia, Long> {
    
}
