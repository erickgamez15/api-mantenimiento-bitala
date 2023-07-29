package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.ChecksMantenimiento;
import com.bitala.apiprueba.repository.IChecksMantenimientoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/check-mantenimiento")
public class ChecksMantenimientoController {
    
    //Anotación para inyección de dependencias
    @Autowired
    private IChecksMantenimientoRepository checksMantenimientoRepository;

    //Objeto ChecksMantenimiento
    ChecksMantenimiento checksMantenimiento;

    @GetMapping
    public List<ChecksMantenimiento> allChecksMan(){
        return checksMantenimientoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ChecksMantenimiento findById(@PathVariable("id") Long id){
        return checksMantenimientoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ChecksMantenimiento createChecksMantenimiento(@RequestBody ChecksMantenimiento checkMan){
        return checksMantenimientoRepository.save(checkMan);
    }

    @PutMapping("/{id}")
    public ChecksMantenimiento updateChecksMantenimiento(@PathVariable Long id, @RequestBody ChecksMantenimiento checkManData){
        checksMantenimiento = checksMantenimientoRepository.findById(id).orElse(checkManData);
        if (checksMantenimiento != null) {
            checksMantenimiento.setIdVerificacion(checkManData.getIdVerificacion());
            checksMantenimiento.setIdCheck(checkManData.getIdCheck());
            checksMantenimiento.setChecked(checkManData.getChecked());
            return checksMantenimientoRepository.save(checksMantenimiento);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
	public void deleteCheksMantenimiento(@PathVariable("id") Long id) {
		checksMantenimientoRepository.deleteById(id);
	}
}
