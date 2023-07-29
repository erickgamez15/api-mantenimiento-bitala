package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bitala.apiprueba.models.Empresa;
import com.bitala.apiprueba.repository.IEmpresaRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    Optional<Empresa> empresaOptional;

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
    public ResponseEntity<Empresa> findById(@PathVariable("id") Long id) {
        empresaOptional = empresaRepository.findById(id);
        return empresaOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //Agrega una nueva Empresa
    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa){
        try {
            Empresa nuevEmpresa = empresaRepository.save(empresa);
            return ResponseEntity.created(URI.create("/api/aunidad/" + nuevEmpresa.getIdEmpresa())).body(nuevEmpresa);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    //Modifica una Empresa por id
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresaData) {
        try {
            empresaOptional = empresaRepository.findById(id);
            if(empresaOptional.isPresent()){
                Empresa empresaExistente = empresaOptional.get();
                BeanUtils.copyProperties(empresaData, empresaExistente, "idEmpresa");
                Empresa empresaActualizada = empresaRepository.save(empresaExistente);
                return ResponseEntity.ok(empresaActualizada);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Elimina una Empresa por id
    @DeleteMapping("/{id}")
	public ResponseEntity<Empresa> deleteEmpresa(@PathVariable("id") Long id) {
        try {
            if(empresaRepository.existsById(id)) {
                empresaRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else return ResponseEntity.notFound().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}

    // Manejo de excepciones genéricas para cualquier otra excepción no capturada
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
