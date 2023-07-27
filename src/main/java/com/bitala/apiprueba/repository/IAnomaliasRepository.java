package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitala.apiprueba.models.Anomalias;

public interface IAnomaliasRepository extends JpaRepository<Anomalias, Long> {
    
}
