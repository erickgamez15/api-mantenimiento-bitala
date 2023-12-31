package com.bitala.api.mantenimiento.controllers;

import org.springframework.web.bind.annotation.*;

import com.bitala.api.mantenimiento.models.Empresa;
import com.bitala.api.mantenimiento.repository.IEmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - EMPRESA
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para accder a Empresa
@RequestMapping("/api/empresa")
public class EmpresaController {

    //Anotación para inyección de dependencias
    @Autowired
    private IEmpresaRepository empresaRepository;

    //Constructor para inyeccion de dependencias
    public EmpresaController(IEmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    //Retorna una lista de todos los elementos de Empresas
    @GetMapping
    public List<Empresa> allEmpresas(){
        return empresaRepository.findAll();
    }

    //Busca una Empresa por id
    @GetMapping("/{id}")
    public Empresa findById(@PathVariable("id") Long id) {
        if (empresaRepository.existsById(id)) return empresaRepository.findById(id).orElse(null);
        else return null;
    }

    //Agrega una nueva Empresa
    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return empresaRepository.save(empresa);
    }
    
    //Modifica una Empresa por id
    @PutMapping("/{id}")
    public Empresa updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresaData) {
        return null;
    }

    //Elimina una Empresa por id
    @DeleteMapping("/{id}")
	public void deleteEmpresa(@PathVariable("id") Long id) {
        if(empresaRepository.existsById(id)) empresaRepository.deleteById(id);
	}
}
