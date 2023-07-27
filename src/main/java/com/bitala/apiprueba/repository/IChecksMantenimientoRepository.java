package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChecksMantenimientoRepository extends JpaRepository <IChecksMantenimientoRepository, Long> {
    
}
