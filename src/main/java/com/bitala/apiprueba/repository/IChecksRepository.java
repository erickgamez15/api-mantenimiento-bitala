package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.Checks;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - CHECKS
 * 
 * version 1.0
 */

@Repository
public interface IChecksRepository extends JpaRepository <Checks, Long> {

}
