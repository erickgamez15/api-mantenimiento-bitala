package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.ControlVehicular;
import com.bitala.apiprueba.repository.IControlVehicularRepository;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - CONTROLVEHICULAR
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para accder a ControlVehicular
@RequestMapping("/api/control-vehicular")
public class ControlVehicularController {
    
    //Anotación para inyeccion de dependencias
    @Autowired
    private IControlVehicularRepository controlRepository; 

    //Constructor para inyección de dependencias
    public ControlVehicularController(IControlVehicularRepository controlRepository) {
        this.controlRepository = controlRepository;
    }

    //Retorna una lista de todos los elementos de ControlVehicular
    @GetMapping
    public List<ControlVehicular> allControl(){
        return controlRepository.findAll();
    }

    //Busca un ControlVehicular por id
    @GetMapping("/{id}")
    public ControlVehicular findById(@PathVariable("id") Long id){
        if (controlRepository.existsById(id)) return controlRepository.findById(id).orElse(null);
        else return null;
    }

    //Agrega un nuevo ControlVehicular
    @PostMapping
    public ControlVehicular createControlVehicular(@RequestBody ControlVehicular controlVehicular){
        return controlRepository.save(controlVehicular);
    }

    //Modifica un ControlVehicular por id
    @PutMapping("/{id}")
    public ControlVehicular updateControlVehicular(@PathVariable Long id, @RequestBody ControlVehicular cVehicularData){
        ControlVehicular controlVehicular = new ControlVehicular();

        if (controlRepository.existsById(id)) {
            controlVehicular.setFechaPSemestre(cVehicularData.getFechaPSemestre());
            controlVehicular.setDocPSemestre(cVehicularData.getDocPSemestre());
            controlVehicular.setCheckedPagoPs(cVehicularData.getCheckedPagoPs());
            controlVehicular.setFechaSSemestre(cVehicularData.getFechaSSemestre());
            controlVehicular.setDocSSemestre(cVehicularData.getDocSSemestre());
            controlVehicular.setCheckedPagoSs(cVehicularData.getCheckedPagoSs());
            return controlRepository.save(controlVehicular);
        } else return null;
    }

    //Elimina un ControlVehicular por id
    @DeleteMapping("/{id}")
    public void deleteControlVehicular(@PathVariable("id") Long id){
        if (controlRepository.existsById(id)) controlRepository.deleteById(id);   
    }
}
