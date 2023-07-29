package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.Chofer;
import com.bitala.apiprueba.repository.IChoferRepository;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - CHOFER
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para acceder a Chofer
@RequestMapping("/api/chofer")
public class ChoferController {

    //Anotación para inyección de dependencias
    @Autowired
    private IChoferRepository choferRepository; 

    //Constructor para inyección de dependencias
    public ChoferController(IChoferRepository choferRepository) {
        this.choferRepository = choferRepository;
    }

    //Retorna una lista de todos los elementos de Chofer
    @GetMapping
    public List<Chofer> allChofer(){
        return choferRepository.findAll();
    }

    //Busca un nuevo Chofer por id
    @GetMapping("/{id}")
    public Chofer findById(@PathVariable("id") Long id){
        if (choferRepository.existsById(id)) return choferRepository.findById(id).orElse(null); 
        else return null;
    }

    //Agrega un nuevo Chofer
    @PostMapping
    public Chofer createChofer(@RequestBody Chofer chofer){
        return choferRepository.save(chofer);
    }

    //Modifica un Chofer por id
    @PutMapping("/{id}")
    public Chofer updateChofer(@PathVariable Long id, @RequestBody Chofer choferData){
        Chofer chofer = new Chofer();

        if (choferRepository.existsById(id)) {
            chofer.setNombre(choferData.getNombre());
            chofer.setApellidos(choferData.getApellidos());
            chofer.setCorreo(choferData.getCorreo());
            chofer.setTelefono(choferData.getTelefono());
            chofer.setPassword(choferData.getPassword());
            chofer.setNoLista(choferData.getNoLista());
            chofer.setFotoChofer(choferData.getFotoChofer());
            return choferRepository.save(chofer);
        } else return null;
    }

    //Elimina un Chofer por id
    @DeleteMapping("/{id}")
    public void deleteChofer(@PathVariable("id") Long id){
        if (choferRepository.existsById(id)) choferRepository.deleteById(id);
    }
}
