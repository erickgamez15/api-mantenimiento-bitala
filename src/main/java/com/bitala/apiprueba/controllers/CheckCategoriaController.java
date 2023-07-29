package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.CheckCategoria;
import com.bitala.apiprueba.repository.ICheckCategoriaRepository;

import java.util.List;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * CONTROLLER - CHECKCATEGORIA
 * 
 * version 1.0
 */

//Indica que la clase es un controlador
@RestController
//Ruta para acceder a CheckCategoria
@RequestMapping("/api/check-categoria")
public class CheckCategoriaController {

    //Anotación para inyección de dependencias
    @Autowired
    private ICheckCategoriaRepository checkCategoriaRepository;

    //Constructor para inyección de dependencias
    public CheckCategoriaController(ICheckCategoriaRepository checkCategoriaRepository) {
        this.checkCategoriaRepository = checkCategoriaRepository;
    }

    //Retorna una lista de todos los elementos de CheckCategoria
    @GetMapping
    public List<CheckCategoria> allCategorias(){
        return checkCategoriaRepository.findAll();
    }

    //Busca un CheckCategoria por id
    @GetMapping("/{id}")
    public CheckCategoria findById(@PathVariable("id") Long id){
        if (checkCategoriaRepository.existsById(id)) return checkCategoriaRepository.findById(id).orElse(null);
        else return null;
    }

    //Agrega un nuevo CheckCategoria
    @PostMapping
    public CheckCategoria createCategoria(@RequestBody CheckCategoria categoria){
        return checkCategoriaRepository.save(categoria);
    }

    //Modifica un CheckCategoria por id
    @PutMapping("/{id}")
    public CheckCategoria updateCategoria(@PathVariable Long id, @RequestBody CheckCategoria categoriaData) {
        CheckCategoria checkCategoria = new CheckCategoria();

        if(checkCategoriaRepository.existsById(id)){
            checkCategoria.setNombre(categoriaData.getNombre());
            return checkCategoriaRepository.save(checkCategoria);
        } else return null;
    }

    //Elimina un CheckCategoria por id
    @DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable("id") Long id) {
        if (checkCategoriaRepository.existsById(id)) checkCategoriaRepository.deleteById(id);
	}
}
