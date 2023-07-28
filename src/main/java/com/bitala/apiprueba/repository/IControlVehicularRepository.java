package com.bitala.apiprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.apiprueba.models.ControlVehicular;

@Repository
public interface IControlVehicularRepository extends JpaRepository<ControlVehicular, Long> {
    
}
