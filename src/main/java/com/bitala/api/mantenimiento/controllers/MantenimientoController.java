package com.bitala.api.mantenimiento.controllers;

import org.springframework.web.bind.annotation.*;

import com.bitala.api.mantenimiento.models.Mantenimiento;
import com.bitala.api.mantenimiento.repository.IMantenimientoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - MANTENIMIENTO
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para acceder a Mantenimiento
@RequestMapping("/api/mantenimiento")
public class MantenimientoController {
    
    //Anotación para inyeccion de dependencias
    @Autowired
    private IMantenimientoRepository mantenimientoRepository;

    //Constructor para inyección de dependencias
    public MantenimientoController(IMantenimientoRepository mantenimientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
    }

    //Retorna una lista de todos los elementos de Mantenimiento
    @GetMapping
    public List<Mantenimiento> allMantenimientos(){
        return mantenimientoRepository.findAll();
    }

    //Busca un Mantenimiento por id
    @GetMapping("/{id}")
    public Mantenimiento findById(@PathVariable("id") Long id){
        if(mantenimientoRepository.existsById(id)) return mantenimientoRepository.findById(id).orElse(null);
        else return null;
    }

    //Agrega un nuevo Mantenimiento
    @PostMapping
    public Mantenimiento createMantenimiento(@RequestBody Mantenimiento mantenimiento){
        return mantenimientoRepository.save(mantenimiento);
    }

    //Modifica un Mantenimiento por id
    @PutMapping("/{id}")
    public Mantenimiento updateMantenimiento(@PathVariable Long id, @RequestBody Mantenimiento manteData){
        Mantenimiento mantenimiento = new Mantenimiento();

        if (mantenimientoRepository.existsById(id)) {
            mantenimiento.setIdUnidad(manteData.getIdUnidad());
            mantenimiento.setFechaSolicitada(manteData.getFechaSolicitada());
            mantenimiento.setFechaEntrega(manteData.getFechaEntrega());
            mantenimiento.setEstatus(manteData.getEstatus());
            mantenimiento.setObservacion(manteData.getObservacion());
            return mantenimientoRepository.save(mantenimiento);
        } else return null;
    }

    //Elimina un Mantenimiento por id
    @DeleteMapping("/{id}")
    public void deleteMantenimiento(@PathVariable("id") Long id){
        if(mantenimientoRepository.existsById(id)) mantenimientoRepository.deleteById(id);
    }
}
