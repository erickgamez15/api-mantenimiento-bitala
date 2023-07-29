package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.Mantenimiento;

@Repository
public interface IMantenimientoRepository extends JpaRepository <Mantenimiento, Long> {
    
}
