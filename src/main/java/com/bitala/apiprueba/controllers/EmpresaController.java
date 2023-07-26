package com.bitala.apiprueba.controllers;

import com.bitala.apiprueba.models.Empresa;
import com.bitala.apiprueba.repository.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpresaController {
    @Autowired
    private IEmpresaRepository empresaRepository;

    @GetMapping("/empresas")
    public List<Empresa> allEmpresas(){
        return empresaRepository.findAll();
    }

    @GetMapping("/empresa/{nombre}")
    public List<Empresa> findByName(@PathVariable("nombre") String nombre) {
        return empresaRepository.findByNombre(nombre);
    }
}
