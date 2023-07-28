package com.bitala.apiprueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bitala.apiprueba.models.Mantenimiento;
import com.bitala.apiprueba.repository.IMantenimientoRepository;

@RestController
@RequestMapping("/api/mantenimiento")
public class MantenimientoController {
    
    //Anotación para inyeccion de dependencias
    @Autowired
    private IMantenimientoRepository mantenimientoRepository;

    //Objeto Mantenimiento
    Mantenimiento mantenimiento;

    @GetMapping
    public List<Mantenimiento> allMantenimientos(){
        return mantenimientoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mantenimiento findById(@PathVariable("id") Long id){
        return mantenimientoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Mantenimiento createMantenimiento(@RequestBody Mantenimiento mantenimiento){
        return mantenimientoRepository.save(mantenimiento);
    }

    @PutMapping("/{id}")
    public Mantenimiento updateMantenimiento(@PathVariable Long id, @RequestBody Mantenimiento manteData){
        mantenimiento = mantenimientoRepository.findById(id).orElse(null);
        if (mantenimiento != null) {
            mantenimiento.setIdUnidad(manteData.getIdUnidad());
            mantenimiento.setFechaSolicitada(manteData.getFechaSolicitada());
            mantenimiento.setFechaEntrega(manteData.getFechaEntrega());
            mantenimiento.setEstatus(manteData.getEstatus());
            mantenimiento.setObservacion(manteData.getObservacion());
            return mantenimientoRepository.save(mantenimiento);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMantenimiento(@PathVariable("id") Long id){
        mantenimientoRepository.deleteById(id);
    }
}
