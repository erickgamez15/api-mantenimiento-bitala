package com.bitala.api.mantenimiento.controllers;

import org.springframework.web.bind.annotation.*;

import com.bitala.api.mantenimiento.models.Anomalias;
import com.bitala.api.mantenimiento.repository.IAnomaliasRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - ANOMALIAS
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para acceder a Anomalias
@RequestMapping("/api/anomalia")
public class AnomaliasController {
    
    //Anotación para inyección de dependencias
    @Autowired
    private IAnomaliasRepository anomaliasRepository;

    //Constructor para inyeccion de dependencias
    public AnomaliasController(IAnomaliasRepository anomaliasRepository) {
        this.anomaliasRepository = anomaliasRepository;
    }

    //Retorna una lista de todos los elementos de Anomalias
    @GetMapping
    public List<Anomalias> allAnomalias(){
        return anomaliasRepository.findAll();
    }

    //Busca una Anomalia por id
    @GetMapping("/{id}")
    public Anomalias findById(@PathVariable("id") Long id){
        if (anomaliasRepository.existsById(id)) return anomaliasRepository.findById(id).orElse(null);
        else return null;
    }

    //Agrega una nueva Anomalia
    @PostMapping
    public Anomalias createAnomalia(@RequestBody Anomalias anomalia){
        return anomaliasRepository.save(anomalia);
    }

    //Modifica una Anomalia por id
    @PutMapping("/{id}")
    public Anomalias updateAnomalia(@PathVariable Long id, @RequestBody Anomalias anomaliaData){
        Anomalias anomalia = new Anomalias();

        if (anomaliasRepository.existsById(id)) {
            anomalia.setIdUnidad(anomaliaData.getIdUnidad());
            anomalia.setIdChofer(anomaliaData.getIdChofer());
            anomalia.setIdMantenimiento(anomaliaData.getIdMantenimiento());
            anomalia.setAnomalia(anomaliaData.getAnomalia());
            anomalia.setDescripcion(anomaliaData.getDescripcion());
            anomalia.setFecha(anomaliaData.getFecha());
            anomalia.setEstatus(anomaliaData.getEstatus());
            return anomaliasRepository.save(anomalia);
        } else return null;
    }

    //Elimina una Anomalia por id
    @DeleteMapping("/{id}")
    public void deleteAnomalia(@PathVariable("id") Long id){
        if(anomaliasRepository.existsById(id)) anomaliasRepository.deleteById(id);
    }
}
