package com.bitala.api.mantenimiento.controllers;

import org.springframework.web.bind.annotation.*;

import com.bitala.api.mantenimiento.models.Unidad;
import com.bitala.api.mantenimiento.repository.IUnidadRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public Unidad findById(@PathVariable("id") Long id){
       if(unidadRepository.existsById(id)) return unidadRepository.findById(id).orElse(null);
       else return null;
    }

    //Agrega una nueva Unidad
    @PostMapping
    public Unidad createUnidad(@RequestBody Unidad unidad){
        return unidadRepository.save(unidad);
    }

    //Modifica una Unidad por id
    @PutMapping("/{id}")
    public Unidad updateUnidad(@PathVariable Long id, @RequestBody Unidad unidadData){
        Unidad unidad = unidadRepository.findById(id).orElse(null);

        if(unidad != null){
            unidad.setIdEmpresa(unidadData.getIdEmpresa());
            return unidadRepository.save(unidad);
        }else return null;
    }

    //Elimina una Unidad por id
    @DeleteMapping("/{id}")
    public void deleteUnidad(@PathVariable("id") Long id){
        if(unidadRepository.existsById(id)) unidadRepository.deleteById(id);
    }
}
