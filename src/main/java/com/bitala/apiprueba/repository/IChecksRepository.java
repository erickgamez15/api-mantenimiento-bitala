package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.Checks;

@Repository
public interface IChecksRepository extends JpaRepository <Checks, Long> {

}
