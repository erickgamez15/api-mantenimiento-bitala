package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.VerificacionVehicular;
import com.bitala.apiprueba.repository.IVerificacionVehicularRepository;

import java.util.List;

@RestController
@RequestMapping("/api/verificacion-vehicular")
public class VerificacionVehicularController {
    
    //Anotación para inyección de dependencias
    @Autowired
    private IVerificacionVehicularRepository verVehicularRepository;

    //Objeto verificacionVehicular
    VerificacionVehicular verificacionVehicular;

    @GetMapping
    public List<VerificacionVehicular> allVerificaciones(){
        return verVehicularRepository.findAll();
    }

    @GetMapping("/{id}")
    public VerificacionVehicular findById(@PathVariable("id") Long id){
        return verVehicularRepository.findById(id).orElse(null);
    }

    @PostMapping
    public VerificacionVehicular createVerificacion(@RequestBody VerificacionVehicular vehicular){
        return verVehicularRepository.save(vehicular);
    }

    @PutMapping("/{id}")
    public VerificacionVehicular updateVerificacion(@PathVariable Long id, @RequestBody VerificacionVehicular vehicularData){
        verificacionVehicular = verVehicularRepository.findById(id).orElse(null);
        if (verificacionVehicular != null) {
            verificacionVehicular.setDigitos(vehicularData.getDigitos());
            verificacionVehicular.setpSemestre(vehicularData.getpSemestre());
            verificacionVehicular.setsSemestre(vehicularData.getsSemestre());
            verificacionVehicular.setColor(vehicularData.getColor());
            verificacionVehicular.setAnio(vehicularData.getAnio());
            return verVehicularRepository.save(verificacionVehicular);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteVerificacion(@PathVariable("id") Long id){
        verVehicularRepository.deleteById(id);
    }
}
