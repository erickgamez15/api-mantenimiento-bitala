package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.Checks;
import com.bitala.apiprueba.repository.IChecksRepository;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - CHECKS
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para acceder a Check
@RequestMapping("/api/check")
public class ChecksController {

    //Anotación para inyección de dependencias
    @Autowired
    private IChecksRepository checkRepository; 

    //Constructor para inyeccion de dependencias
    public ChecksController(IChecksRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    //Retorna una lista de todos los elementos de Check
    @GetMapping
    public List<Checks> allChecks() {
        return checkRepository.findAll();
    }

    //Busca un Check por id
    @GetMapping("/{id}")
    public Checks findById(@PathVariable("id") Long id){
        if (checkRepository.existsById(id)) return checkRepository.findById(id).orElse(null); 
        else return null;
    }

    //Agrega un nuevo Check
    @PostMapping
    public Checks createCheck(@RequestBody Checks check) {
        return checkRepository.save(check);
    }

    //Modifica un Check por id
    @PutMapping("/{id}")
    public Checks updateChecks(@PathVariable Long id, @RequestBody Checks checkData){
        Checks check = new Checks();

        if (checkRepository.existsById(id)) {
            check.setCategoria(checkData.getCategoria());
            check.setDescripcion(checkData.getDescripcion());
            return checkRepository.save(check);
        } else return null;
    }

    //Elimina un Check por id
    @DeleteMapping("/{id}")
    public void deleteChecks(@PathVariable("id") Long id){
        if (checkRepository.existsById(id)) checkRepository.deleteById(id);
    } 
}
