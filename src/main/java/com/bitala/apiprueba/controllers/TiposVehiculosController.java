package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.TiposVehiculos;
import com.bitala.apiprueba.repository.ITiposVehiculosRepository;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - TIPOSVEHICULOS
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para acceder a TiposVehiculo
@RequestMapping("/api/tipo-vehiculo")
public class TiposVehiculosController {
    
    //Anotación para inyección de dependencias
    @Autowired
    private ITiposVehiculosRepository tiposVehiculosRepository;

    //Construtor para inyección de dependencias
    public TiposVehiculosController(ITiposVehiculosRepository tiposVehiculosRepository) {
        this.tiposVehiculosRepository = tiposVehiculosRepository;
    }

    //Retorna una lista de todos los elementos Tipos Vehiculos
    @GetMapping
    public List<TiposVehiculos> allTiposVehiculos(){
        return tiposVehiculosRepository.findAll();
    }

    //Busca un TipoVehiculo por id
    @GetMapping("/{id}")
    public TiposVehiculos findById(@PathVariable("id") Long id){
        if(tiposVehiculosRepository.existsById(id)) return tiposVehiculosRepository.findById(id).orElse(null);
        else return null;
    }

    //Agrega un nuevo TipoVehiculo
    @PostMapping
    public TiposVehiculos createTipoVehiculo(@RequestBody TiposVehiculos tipoVehiculo){
        return tiposVehiculosRepository.save(tipoVehiculo);
    }

    //Modifica un TipoVehiculo por id
    @PutMapping("/{id}")
    public TiposVehiculos updtateTipos(@PathVariable Long id, @RequestBody TiposVehiculos tipoData){
        TiposVehiculos tiposVehiculos = new TiposVehiculos();
        
        if (tiposVehiculosRepository.existsById(id)) {
            tiposVehiculos.setIdVehiculo(tipoData.getIdVehiculo());
            tiposVehiculos.setTipo_vehiculo(tipoData.getTipo_vehiculo());
            return tiposVehiculosRepository.save(tiposVehiculos);
        } else return null;
    }

    //Elimina un TipoVehiculo por id
    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable("id") Long id){
        if(tiposVehiculosRepository.existsById(id)) tiposVehiculosRepository.deleteById(id);
    }
}
