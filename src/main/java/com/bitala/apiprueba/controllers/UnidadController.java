package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.Unidad;
import com.bitala.apiprueba.repository.IUnidadRepository;

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

    @GetMapping
    public List<Unidad> allUnidades(){
        return unidadRepository.findAll();
    }

    @GetMapping("/{id}")
    public Unidad findById(@PathVariable("id") Long id){
        if(unidadRepository.existsById(id)) return unidadRepository.findById(id).orElse(null);
        else return null;
    }

    @PostMapping
    public Unidad createUnidad(@RequestBody Unidad unidad){
        return unidadRepository.save(unidad);
    }

    @PutMapping("/{id}")
    public Unidad updateUnidad(@PathVariable Long id, @RequestBody Unidad unidadData){
        Unidad unidad = new Unidad();

        if (unidadRepository.existsById(id)) {
            unidad.setIdEmpresa(unidadData.getIdEmpresa());
            unidad.setIdVehiculo(unidadData.getIdVehiculo());
            unidad.setIdControlVehicular(unidadData.getIdControlVehicular());
            unidad.setClave(unidadData.getClave());
            unidad.setMarca(unidadData.getMarca());
            unidad.setModelo(unidadData.getModelo());
            unidad.setAnio(unidadData.getAnio());
            unidad.setMotor(unidadData.getMotor());
            unidad.setVin(unidadData.getVin());
            unidad.setPlacas(unidadData.getPlacas());
            unidad.setEstatus(unidadData.getEstatus());
            unidad.setFotoUnidad(unidad.getFotoUnidad());
            return unidadRepository.save(unidad);
        } else return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUnidad(@PathVariable("id") Long id){
        if(unidadRepository.existsById(id)) unidadRepository.deleteById(id);
    }
}
