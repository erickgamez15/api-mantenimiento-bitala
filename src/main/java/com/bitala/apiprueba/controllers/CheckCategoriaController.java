package com.bitala.apiprueba.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitala.apiprueba.models.CheckCategoria;
import com.bitala.apiprueba.repository.ICheckCategoriaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/check-categoria")
public class CheckCategoriaController {

    //Anotación para inyección de dependencias
    @Autowired
    private ICheckCategoriaRepository checkCategoriaRepository;

    //Objeto CheckCategoria
    CheckCategoria checkCategoria;

    @GetMapping
    public List<CheckCategoria> allCategorias(){
        return checkCategoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public CheckCategoria findById(@PathVariable("id") Long id){
        return checkCategoriaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public CheckCategoria createCategoria(@RequestBody CheckCategoria categoria){
        return checkCategoriaRepository.save(categoria);
    }

    @PutMapping("/{id}")
    public CheckCategoria updateCategoria(@PathVariable Long id, @RequestBody CheckCategoria categoriaData) {
        checkCategoria = checkCategoriaRepository.findById(id).orElse(null);
        if(checkCategoria != null){
            checkCategoria.setNombre(categoriaData.getNombre());
            return checkCategoriaRepository.save(checkCategoria);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable("id") Long id) {
		checkCategoriaRepository.deleteById(id);
	}
}
