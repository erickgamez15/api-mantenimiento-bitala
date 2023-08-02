package com.bitala.api.mantenimiento.controllers;

import org.springframework.web.bind.annotation.*;

import com.bitala.api.mantenimiento.models.Verificacion;
import com.bitala.api.mantenimiento.repository.IVerificacionRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - VERIFICACION
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para acceder a Verificacion
@RequestMapping("/api/verificacion")
public class VerificacionController {
    
    //Anotación para inyección de dependencias
    @Autowired
    private IVerificacionRepository verificacionRepository;

    //Constructor para inyección de dependencias
    public VerificacionController(IVerificacionRepository verificacionRepository) {
        this.verificacionRepository = verificacionRepository;
    }

    //Retorna una lista de todos los elementos de Verificacion
    @GetMapping
    public List<Verificacion> allVerificaciones(){
        return verificacionRepository.findAll();
    }

    //Busca una Verificacion por id
    @GetMapping("/{id}")
    public Verificacion findById(@PathVariable("id") Long id){
        if(verificacionRepository.existsById(id)) return verificacionRepository.findById(id).orElse(null);
        else return null;
    }

    //Agrega una nueva Verificacion
    @PostMapping
    public Verificacion createVerificacion(@RequestBody Verificacion verificacion){
        return verificacionRepository.save(verificacion);
    }

    //Modifica una Verificacion por id
    @PutMapping("/{id}")
    public Verificacion updateVerificacion(@PathVariable Long id, @RequestBody Verificacion verificacionData){
        Verificacion verificacion = verificacionRepository.findById(id).orElse(null);

        if (verificacion != null) {
            verificacion.setIdMantenimiento(verificacionData.getIdMantenimiento());
            verificacion.setFechaInicial(verificacionData.getFechaInicial());
            verificacion.setFechaCheckeado(verificacionData.getFechaCheckeado());
            verificacion.setEstatus(verificacionData.getEstatus());
            return verificacionRepository.save(verificacion);
        } else return null;
    }

    //Elimina una Verificacion por id
    @DeleteMapping("/{id}")
    public void deleteVerificacion(@PathVariable("id") Long id){
        if(verificacionRepository.existsById(id)) verificacionRepository.deleteById(id);
    }
}
