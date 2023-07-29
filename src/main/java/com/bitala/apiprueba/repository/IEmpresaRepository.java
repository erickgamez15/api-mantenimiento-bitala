package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.Empresa;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - EMPRESA
 * 
 * version 1.0
 */

@Repository
public interface IEmpresaRepository extends JpaRepository <Empresa, Long> {

}
