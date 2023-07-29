package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.FotosAnomalia;
import com.bitala.apiprueba.repository.IFotosAnomaliaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/fotos-anomalia")
public class FotosAnomaliaController {
    
    //Anotación para inyección de dependencias
    @Autowired
    private IFotosAnomaliaRepository fotosAnomaliaRepository;

    //Objeto fotosAnomalia
    FotosAnomalia fotoAnomalia;

    @GetMapping
    public List<FotosAnomalia> allFotos(){
        return fotosAnomaliaRepository.findAll();
    }

    @GetMapping("/{id}")
    public FotosAnomalia findById(@PathVariable("id") Long id){
        return fotosAnomaliaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public FotosAnomalia createFoto(@RequestBody FotosAnomalia fotosAnomalia){
        return fotosAnomaliaRepository.save(fotosAnomalia);
    }

    @PutMapping("/{id}")
    public FotosAnomalia updateFotos(@PathVariable Long id, @RequestBody FotosAnomalia fotosData){
        fotoAnomalia = fotosAnomaliaRepository.findById(id).orElse(null);
        if (fotoAnomalia != null) {
            fotoAnomalia.setIdAnomalia(fotosData.getIdAnomalia());
            fotoAnomalia.setFoto(fotosData.getFoto());
            return fotosAnomaliaRepository.save(fotoAnomalia);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFoto(@PathVariable("id") Long id){
        fotosAnomaliaRepository.deleteById(id);
    }
}
