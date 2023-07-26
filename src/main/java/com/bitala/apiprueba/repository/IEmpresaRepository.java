package com.bitala.apiprueba.repository;

import com.bitala.apiprueba.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findByName(@Param("nombre") String nombre);
}
