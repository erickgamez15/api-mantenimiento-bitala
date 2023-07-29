package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.Verificacion;
import com.bitala.apiprueba.repository.IVerificacionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/verificacion")
public class VerificacionController {
    
    //Anotación para inyección de dependencias
    @Autowired
    private IVerificacionRepository verificacionRepository;

    //Objeto Verificación
    Verificacion verificacion;

    @GetMapping
    public List<Verificacion> allVerificaciones(){
        return verificacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Verificacion findById(@PathVariable("id") Long id){
        return verificacionRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Verificacion createVerificacion(@RequestBody Verificacion verificacion){
        return verificacionRepository.save(verificacion);
    }

    @PutMapping("/{id}")
    public Verificacion updateVerificacion(@PathVariable Long id, @RequestBody Verificacion verificacionData){
        verificacion = verificacionRepository.findById(id).orElse(null);
        if (verificacion != null) {
            verificacion.setIdMantenimiento(verificacionData.getIdMantenimiento());
            verificacion.setFechaInicial(verificacionData.getFechaInicial());
            verificacion.setFechaCheckeado(verificacionData.getFechaCheckeado());
            verificacion.setEstatus(verificacionData.getEstatus());
            return verificacionRepository.save(verificacion);
        } else {
            return null;
        }
    }
}
