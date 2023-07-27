package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.Chofer;

@Repository
public interface IChoferRepository extends JpaRepository<Chofer, Long> {
    
}