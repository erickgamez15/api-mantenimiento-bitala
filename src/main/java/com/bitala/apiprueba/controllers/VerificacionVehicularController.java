package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.VerificacionVehicular;
import com.bitala.apiprueba.repository.IVerificacionVehicularRepository;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - VERIFICACIONVEHICULAR
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para acceder a VerificacionVehicular
@RequestMapping("/api/verificacion-vehicular")
public class VerificacionVehicularController {
    
    //Anotación para inyección de dependencias
    @Autowired
    private IVerificacionVehicularRepository verVehicularRepository;

    //Constructor para inyección de dependencias
    public VerificacionVehicularController(IVerificacionVehicularRepository verVehicularRepository) {
        this.verVehicularRepository = verVehicularRepository;
    }

    //Retorna una lista de todos los elementos de VerificacionVehicular
    @GetMapping
    public List<VerificacionVehicular> allVerificaciones(){
        return verVehicularRepository.findAll();
    }

    //Busca una VerificacionVehicular por id
    @GetMapping("/{id}")
    public VerificacionVehicular findById(@PathVariable("id") Long id){
        if(verVehicularRepository.existsById(id)) return verVehicularRepository.findById(id).orElse(null);
        else return null;
    }

    //Agrega una nueva VerificacionVehicular
    @PostMapping
    public VerificacionVehicular createVerificacion(@RequestBody VerificacionVehicular vehicular){
        return verVehicularRepository.save(vehicular);
    }

    //Modifica una VerificacionVehicular por id
    @PutMapping("/{id}")
    public VerificacionVehicular updateVerificacion(@PathVariable Long id, @RequestBody VerificacionVehicular vehicularData){
        VerificacionVehicular verificacionVehicular = new VerificacionVehicular();

        if (verVehicularRepository.existsById(id)) {
            verificacionVehicular.setDigitos(vehicularData.getDigitos());
            verificacionVehicular.setpSemestre(vehicularData.getpSemestre());
            verificacionVehicular.setsSemestre(vehicularData.getsSemestre());
            verificacionVehicular.setColor(vehicularData.getColor());
            verificacionVehicular.setAnio(vehicularData.getAnio());
            return verVehicularRepository.save(verificacionVehicular);
        } else return null;
    }

    //Elimina una VerificacionVehicular por id
    @DeleteMapping("/{id}")
    public void deleteVerificacion(@PathVariable("id") Long id){
        if(verVehicularRepository.existsById(id)) verVehicularRepository.deleteById(id);
    }
}
