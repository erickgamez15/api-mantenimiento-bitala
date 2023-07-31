package com.bitala.api.mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.api.mantenimiento.models.CheckCategoria;

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
