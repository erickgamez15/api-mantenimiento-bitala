package com.bitala.apiprueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitala.apiprueba.models.VerificacionVehicular;
import com.bitala.apiprueba.repository.IVerificacionVehicularRepository;

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
