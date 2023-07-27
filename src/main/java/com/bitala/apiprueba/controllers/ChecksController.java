package com.bitala.apiprueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bitala.apiprueba.repository.IChecksRepository;

import com.bitala.apiprueba.models.Checks;

@RestController
@RequestMapping("/api/check")
public class ChecksController {

    //Anotación para la inyección de dependencias
    @Autowired
    private IChecksRepository checkRepository;

    //Objeto Checks
    Checks check;

    @GetMapping
    public List<Checks> allChecks() {
        return checkRepository.findAll();
    }

    @GetMapping("/{id}")
    public Checks findById(@PathVariable("id") Long id){
        return checkRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Checks createCheck(@RequestBody Checks check) {
        return checkRepository.save(check);
    }

    @PutMapping("/{id}")
    public Checks updateChecks(@PathVariable Long id, @RequestBody Checks checkData){
        check = checkRepository.findById(id).orElse(null);
        if (check != null) {
            check.setCategoria(checkData.getCategoria());
            check.setDescripcion(checkData.getDescripcion());
            return checkRepository.save(check);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteChecks(@PathVariable("id") Long id){
        checkRepository.deleteById(id);
    }
}
