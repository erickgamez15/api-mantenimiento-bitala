package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.Chofer;
import com.bitala.apiprueba.repository.IChoferRepository;

import java.util.List;

@RestController
@RequestMapping("/api/chofer")
public class ChoferController {

    //Anotación para inyección de dependencias
    @Autowired
    private IChoferRepository choferRepository;
    
    //Objeto Chofer
    Chofer chofer;

    @GetMapping
    public List<Chofer> allChofer(){
        return choferRepository.findAll();
    }

    @GetMapping("/{id}")
    public Chofer findById(@PathVariable("id") Long id){
        return choferRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Chofer createChofer(@RequestBody Chofer chofer){
        return choferRepository.save(chofer);
    }

    @PutMapping("/{id}")
    public Chofer updateChofer(@PathVariable Long id, @RequestBody Chofer choferData){
        chofer = choferRepository.findById(id).orElse(null);
        if (chofer != null) {
            chofer.setNombre(choferData.getNombre());
            chofer.setApellidos(choferData.getApellidos());
            chofer.setCorreo(choferData.getCorreo());
            chofer.setTelefono(choferData.getTelefono());
            chofer.setPassword(choferData.getPassword());
            chofer.setNoLista(choferData.getNoLista());
            chofer.setFotoChofer(choferData.getFotoChofer());
            return choferRepository.save(chofer);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteChofer(@PathVariable("id") Long id){
        choferRepository.deleteById(id);
    }
}
