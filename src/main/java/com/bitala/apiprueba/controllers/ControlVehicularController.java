package com.bitala.apiprueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bitala.apiprueba.models.ControlVehicular;
import com.bitala.apiprueba.repository.IControlVehicularRepository;

@RestController
@RequestMapping("/api/control-vehicular")
public class ControlVehicularController {
    
    //Anotación para inyeccion de dependencias
    @Autowired
    private IControlVehicularRepository controlRepository;

    //Objeto ControlVehicular
    ControlVehicular controlVehicular;

    @GetMapping
    public List<ControlVehicular> allControl(){
        return controlRepository.findAll();
    }

    @GetMapping("/{id}")
    public ControlVehicular findById(@PathVariable("id") Long id){
        return controlRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ControlVehicular createControlVehicular(@RequestBody ControlVehicular controlVehicular){
        return controlRepository.save(controlVehicular);
    }

    @PutMapping("/{id}")
    public ControlVehicular updateControlVehicular(@PathVariable Long id, @RequestBody ControlVehicular cVehicularData){
        controlVehicular = controlRepository.findById(id).orElse(null);
        if (controlVehicular != null) {
            controlVehicular.setFechaPSemestre(cVehicularData.getFechaPSemestre());
            controlVehicular.setDocPSemestre(cVehicularData.getDocPSemestre());
            controlVehicular.setCheckedPagoPs(cVehicularData.getCheckedPagoPs());
            controlVehicular.setFechaSSemestre(cVehicularData.getFechaSSemestre());
            controlVehicular.setDocSSemestre(cVehicularData.getDocSSemestre());
            controlVehicular.setCheckedPagoSs(cVehicularData.getCheckedPagoSs());
            return controlRepository.save(controlVehicular);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteControlVehicular(@PathVariable("id") Long id){
        controlRepository.deleteById(id);
    }
}
