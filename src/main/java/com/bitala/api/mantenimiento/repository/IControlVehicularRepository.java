package com.bitala.api.mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.api.mantenimiento.models.ControlVehicular;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * REPOSITORY - CONTROLVEHICULAR
 * 
 * version 1.0
 */

@Repository
public interface IControlVehicularRepository extends JpaRepository <ControlVehicular, Long> {
    
}
