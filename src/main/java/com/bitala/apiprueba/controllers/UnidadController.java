package com.bitala.apiprueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bitala.apiprueba.models.Unidad;
import com.bitala.apiprueba.repository.IUnidadRepository;

@RestController
@RequestMapping("/api/unidad")
public class UnidadController {
    
    //Anotacion para inyeccion de dependencias
    @Autowired
    private IUnidadRepository unidadRepository;

    //Objeto Unidad
    Unidad unidad;

    @GetMapping
    public List<Unidad> allUnidades(){
        return unidadRepository.findAll();
    }

    @GetMapping("/{id}")
    public Unidad findById(@PathVariable("id") Long id){
        return unidadRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Unidad createUnidad(@RequestBody Unidad unidad){
        return unidadRepository.save(unidad);
    }

    @PutMapping("/{id}")
    public Unidad updateUnidad(@PathVariable Long id, @RequestBody Unidad unidadData){
        unidad = unidadRepository.findById(id).orElse(null);
        if (unidad != null) {
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
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUnidad(@PathVariable("id") Long id){
        unidadRepository.deleteById(id);
    }
}
