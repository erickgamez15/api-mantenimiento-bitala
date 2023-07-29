package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.Anomalias;

@Repository
public interface IAnomaliasRepository extends JpaRepository <Anomalias, Long> {
    
}
