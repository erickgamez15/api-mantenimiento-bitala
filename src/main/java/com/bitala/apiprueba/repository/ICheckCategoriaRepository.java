package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.CheckCategoria;

@Repository
public interface ICheckCategoriaRepository extends JpaRepository <CheckCategoria, Long> {
    
}
