package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.TiposVehiculos;
import com.bitala.apiprueba.repository.ITiposVehiculosRepository;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-vehiculo")
public class TiposVehiculosController {
    
    @Autowired
    private ITiposVehiculosRepository tiposVehiculosRepository;

    //Objeto tipoVehiculo
    TiposVehiculos tiposVehiculos;

    @GetMapping
    public List<TiposVehiculos> allTiposVehiculos(){
        return tiposVehiculosRepository.findAll();
    }

    @GetMapping("/{id}")
    public TiposVehiculos findById(@PathVariable("id") Long id){
        return tiposVehiculosRepository.findById(id).orElse(tiposVehiculos);
    }

    @PostMapping
    public TiposVehiculos createTipoVehiculo(@RequestBody TiposVehiculos tipoVehiculo){
        return tiposVehiculosRepository.save(tipoVehiculo);
    }

    @PutMapping("/{id}")
    public TiposVehiculos updtateTipos(@PathVariable Long id, @RequestBody TiposVehiculos tipoData){
        tiposVehiculos = tiposVehiculosRepository.findById(id).orElse(null);
        if (tiposVehiculos != null) {
            tiposVehiculos.setIdVehiculo(tipoData.getIdVehiculo());
            tiposVehiculos.setTipo_vehiculo(tipoData.getTipo_vehiculo());
            return tiposVehiculosRepository.save(tiposVehiculos);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable("id") Long id){
        tiposVehiculosRepository.deleteById(id);
    }
}
