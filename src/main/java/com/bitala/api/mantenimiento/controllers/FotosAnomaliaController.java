package com.bitala.api.mantenimiento.controllers;

import org.springframework.web.bind.annotation.*;

import com.bitala.api.mantenimiento.models.FotosAnomalia;
import com.bitala.api.mantenimiento.repository.IFotosAnomaliaRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - FOTOSANOMALIA
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para acceder a FotosAnomalia
@RequestMapping("/api/fotos-anomalia")
public class FotosAnomaliaController {
    
    //Anotación para inyección de dependencias
    @Autowired
    private IFotosAnomaliaRepository fotosAnomaliaRepository; 

    //Construtor para inyección de dependencias
    public FotosAnomaliaController(IFotosAnomaliaRepository fotosAnomaliaRepository) {
        this.fotosAnomaliaRepository = fotosAnomaliaRepository;
    }

    //Retorna una lista de todos los elementos de FotosAnomalia
    @GetMapping
    public List<FotosAnomalia> allFotos(){
        return fotosAnomaliaRepository.findAll();
    }

    //Busca una FotoAnomalia por id
    @GetMapping("/{id}")
    public FotosAnomalia findById(@PathVariable("id") Long id){
        if(fotosAnomaliaRepository.existsById(id)) return fotosAnomaliaRepository.findById(id).orElse(null);
        else return null;
    }

    //Agrega una nueva FotoAnomalia
    @PostMapping
    public FotosAnomalia createFoto(@RequestBody FotosAnomalia fotosAnomalia){
        return fotosAnomaliaRepository.save(fotosAnomalia);
    }

    //Modifica una FotoAnomalia por id
    @PutMapping("/{id}")
    public FotosAnomalia updateFotos(@PathVariable Long id, @RequestBody FotosAnomalia fotosData){
        FotosAnomalia fotoAnomalia = fotosAnomaliaRepository.findById(id).orElse(fotosData);

        if (fotosAnomaliaRepository.existsById(id)) {
            fotoAnomalia.setIdAnomalia(fotosData.getIdAnomalia());
            fotoAnomalia.setFoto(fotosData.getFoto());
            return fotosAnomaliaRepository.save(fotoAnomalia);
        } else return null;
    }

    //Elimina una FotoAnomalia por id
    @DeleteMapping("/{id}")
    public void deleteFoto(@PathVariable("id") Long id){
        if(fotosAnomaliaRepository.existsById(id)) fotosAnomaliaRepository.deleteById(id);
    }
}
