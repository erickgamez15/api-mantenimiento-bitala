package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.Unidad;

@Repository
public interface IUnidadRepository extends JpaRepository<Unidad, Long> {
    
}
