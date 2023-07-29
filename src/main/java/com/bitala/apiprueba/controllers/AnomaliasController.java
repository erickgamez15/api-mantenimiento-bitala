package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.Anomalias;
import com.bitala.apiprueba.repository.IAnomaliasRepository;

import java.util.List;

@RestController
@RequestMapping("/api/anomalia")
public class AnomaliasController {
    
    //Anotación para la inyección de dependencias
    @Autowired
    private IAnomaliasRepository anomaliasRepository;

    //Objeto Anomalias
    Anomalias anomalia;

    @GetMapping
    public List<Anomalias> allAnomalias(){
        return anomaliasRepository.findAll();
    }

    @GetMapping("/{id}")
    public Anomalias findById(@PathVariable("id") Long id){
        return anomaliasRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Anomalias createAnomalia(@RequestBody Anomalias anomalia){
        return anomaliasRepository.save(anomalia);
    }

    @PutMapping("/{id}")
    public Anomalias updateAnomalia(@PathVariable Long id, @RequestBody Anomalias anomaliaData){
        anomalia = anomaliasRepository.findById(id).orElse(null);
        if (anomalia != null) {
            anomalia.setIdUnidad(anomaliaData.getIdUnidad());
            anomalia.setIdChofer(anomaliaData.getIdChofer());
            anomalia.setIdMantenimiento(anomaliaData.getIdMantenimiento());
            anomalia.setAnomalia(anomaliaData.getAnomalia());
            anomalia.setDescripcion(anomaliaData.getDescripcion());
            anomalia.setFecha(anomaliaData.getFecha());
            anomalia.setEstatus(anomaliaData.getEstatus());
            return anomaliasRepository.save(anomalia);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAnomalia(@PathVariable("id") Long id){
        anomaliasRepository.deleteById(id);
    }
}
