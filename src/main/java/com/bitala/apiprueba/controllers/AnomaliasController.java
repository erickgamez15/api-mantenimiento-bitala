package com.bitala.apiprueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bitala.apiprueba.models.Anomalias;
import com.bitala.apiprueba.repository.IAnomaliasRepository;

@RestController
@RequestMapping("/api/anomalia")
public class AnomaliasController {
    
    //Anotación para la inyección de dependencias
    @Autowired
    private IAnomaliasRepository anomaliasRepository;

    //Objeto Anomalias
    Anomalias anomalias;

    @GetMapping
    public List<Anomalias> allAnomalias(){
        return anomaliasRepository.findAll();
    }
}
