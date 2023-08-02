package com.bitala.api.mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitala.api.mantenimiento.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
