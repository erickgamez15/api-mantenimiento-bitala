package com.bitala.apiprueba.controllers;

import com.bitala.apiprueba.models.Empresa;
import com.bitala.apiprueba.repository.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpresaController {
    @Autowired
    private IEmpresaRepository empresaRepository;

    @GetMapping("/empresas")
    public List<Empresa> allEmpresas(){
        return empresaRepository.findAll();
    }

    @GetMapping("/empresa/{nombre}")
    public List<Empresa> findByName(@PathVariable("nombre") String nombre) {
        return empresaRepository.findByNombre(nombre);
    }

    @PostMapping("/empresa")
    public Empresa creatEmpresa(@RequestBody Empresa empresa){
        return empresaRepository.save(empresa);
    }
    
    @PutMapping("/empresa/{id}")
    public Empresa updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @DeleteMapping("/person/{id}")
	public void deleteEmpresa(@PathVariable("id") Long id) {
		empresaRepository.deleteById(id);
	}
}
