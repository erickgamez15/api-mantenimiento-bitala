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
@RequestMapping("/api/empresa")
public class EmpresaController {

    //Anotación para inyección de dependencias
    @Autowired
    private IEmpresaRepository empresaRepository;

    //Objeto Empressa
    Empresa empresa;

    @GetMapping
    public List<Empresa> allEmpresas(){
        return empresaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Empresa findById(@PathVariable("id") Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return empresaRepository.save(empresa);
    }
    
    @PutMapping("/{id}")
    public Empresa updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresaData) {
        empresa = empresaRepository.findById(id).orElse(null);
        if(empresa != null){
            empresa.setNombre(empresaData.getNombre());
            empresa.setCorreo(empresaData.getCorreo());
            empresa.setTelefono(empresaData.getTelefono());
            empresa.setDireccion(empresaData.getDireccion());
            return empresaRepository.save(empresa);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
	public void deleteEmpresa(@PathVariable("id") Long id) {
		empresaRepository.deleteById(id);
	}
}
