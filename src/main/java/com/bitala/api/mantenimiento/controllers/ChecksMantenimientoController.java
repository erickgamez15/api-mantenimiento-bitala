package com.bitala.api.mantenimiento.controllers;

import org.springframework.web.bind.annotation.*;

import com.bitala.api.mantenimiento.models.ChecksMantenimiento;
import com.bitala.api.mantenimiento.repository.IChecksMantenimientoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - CHECKSMANTENIMIENTO
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para acceder a CheckMantenimiento
@RequestMapping("/api/check-mantenimiento")
public class ChecksMantenimientoController {
    
    //Anotación para inyección de dependencias
    @Autowired
    private IChecksMantenimientoRepository checksMantenimientoRepository;

    //Constructor para inyección de dependencias
    public ChecksMantenimientoController(IChecksMantenimientoRepository checksMantenimientoRepository) {
        this.checksMantenimientoRepository = checksMantenimientoRepository;
    }

    //Retorna una lista de todos los elementos de ChecksMantenimiento
    @GetMapping
    public List<ChecksMantenimiento> allChecksMan(){
        return checksMantenimientoRepository.findAll();
    }

    //Busca un CheckMantenimiento por id
    @GetMapping("/{id}")
    public ChecksMantenimiento findById(@PathVariable("id") Long id){
        if(checksMantenimientoRepository.existsById(id)) return checksMantenimientoRepository.findById(id).orElse(null);
        else return null;
    }

    //Agrega un nuevo CheckMantenimiento
    @PostMapping
    public ChecksMantenimiento createChecksMantenimiento(@RequestBody ChecksMantenimiento checkMan){
        return checksMantenimientoRepository.save(checkMan);
    }

    //Modifica un ChecMantenimiento por id
    @PutMapping("/{id}")
    public ChecksMantenimiento updateChecksMantenimiento(@PathVariable Long id, @RequestBody ChecksMantenimiento checkManData){
        ChecksMantenimiento checksMantenimiento = checksMantenimientoRepository.findById(id).orElse(null);

        if(checksMantenimiento != null) {
            checksMantenimiento.setIdVerificacion(checkManData.getIdVerificacion());
            checksMantenimiento.setIdCheck(checkManData.getIdCheck());
            checksMantenimiento.setChecked(checkManData.getChecked());
            return checksMantenimientoRepository.save(checksMantenimiento);
        } else return null;
    }

    //Elimina un CheckMantenimiento por id
    @DeleteMapping("/{id}")
	public void deleteCheksMantenimiento(@PathVariable("id") Long id) {
        if(checksMantenimientoRepository.existsById(id)) checksMantenimientoRepository.deleteById(id);
	}
}
