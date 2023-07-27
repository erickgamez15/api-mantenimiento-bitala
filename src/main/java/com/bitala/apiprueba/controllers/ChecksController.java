package com.bitala.apiprueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitala.apiprueba.repository.IChecksRepository;

import com.bitala.apiprueba.models.Checks;

@RestController
@RequestMapping("/api/check")
public class ChecksController {

    //Anotación para la inyección de dependencias
    @Autowired
    private IChecksRepository checkRepository;

    @GetMapping
    public Iterable<Checks> allChecks() {
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
    public Checks updateChecks(@PathVariable Long id, @RequestBody Checks checks){
        return checkRepository.save(checks);
    }

    @DeleteMapping("/{id}")
    public void deleteChecks(@PathVariable("id") Long id){
        checkRepository.deleteById(id);
    }
}
