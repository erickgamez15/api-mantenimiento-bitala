package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bitala.apiprueba.models.Unidad;
import com.bitala.apiprueba.repository.IUnidadRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - UNIDAD
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para acceder a Unidad
@RequestMapping("/api/unidad")
public class UnidadController {
    
    //Anotacion para inyeccion de dependencias
    @Autowired
    private IUnidadRepository unidadRepository;

    //Objeto Optional<Unidad>
    Optional<Unidad> unidadOptional;

    //Constructor para inyección de dependencias
    public UnidadController(IUnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }

    //Retorna una lista de todos los elementos de Unidad
    @GetMapping
    public List<Unidad> allUnidades(){
        return unidadRepository.findAll();
    }

    //Busca una Unidad por id
    @GetMapping("/{id}")
    public ResponseEntity<Unidad> findById(@PathVariable("id") Long id){
        unidadOptional = unidadRepository.findById(id);
        return unidadOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //Agrega una nueva Unidad
    @PostMapping
    public ResponseEntity<Unidad> createUnidad(@RequestBody Unidad unidad){
        try {
            Unidad nuevaUnidad = unidadRepository.save(unidad);
            return ResponseEntity.created(URI.create("/api/unidad/" + nuevaUnidad.getIdUnidad())).body(nuevaUnidad);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Modifica una Unidad por id
    @PutMapping("/{id}")
    public ResponseEntity<Unidad> updateUnidad(@PathVariable Long id, @RequestBody Unidad unidadData){
        try {
            unidadOptional = unidadRepository.findById(id);
            if (unidadOptional.isPresent()) {
                Unidad unidadExistente = unidadOptional.get();
                BeanUtils.copyProperties(unidadData, unidadExistente, "id");
                Unidad unidadActualizada = unidadRepository.save(unidadExistente);
                return ResponseEntity.ok(unidadActualizada);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Elimina una Unidad por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Unidad> deleteUnidad(@PathVariable("id") Long id){
        try {
            if(unidadRepository.existsById(id)) {
                unidadRepository.deleteById(id);
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
