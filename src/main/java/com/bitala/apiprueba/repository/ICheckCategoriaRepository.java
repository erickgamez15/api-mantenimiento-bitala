package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.CheckCategoria;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - CHECKCATEGORIA
 * 
 * version 1.0
 */

@Repository
public interface ICheckCategoriaRepository extends JpaRepository <CheckCategoria, Long> {
    
}
