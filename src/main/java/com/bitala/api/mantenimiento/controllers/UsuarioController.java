package com.bitala.api.mantenimiento.controllers;

import org.springframework.web.bind.annotation.*;

import com.bitala.api.mantenimiento.entities.Usuario;
import com.bitala.api.mantenimiento.repository.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//Para indicar que la clase es un controlador
@RestController
//Ruta para acceder a los usuarios
@RequestMapping("/api/usuario")
public class UsuarioController {

    //Anotación para inyección de dependencias
    @Autowired
    private IUsuarioRepository usuarioRepository;

    //Constructor para inyección de dependencias
    public UsuarioController(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> allUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable("id") Long id){
        if (usuarioRepository.existsById(id)) return usuarioRepository.findById(id).orElse(null);
        else return null;
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioData){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if(usuario != null){
            usuario.setNombre(usuarioData.getNombre());
            usuario.setTelefono(usuarioData.getTelefono());
            usuario.setEmail(usuarioData.getEmail());
            usuario.setPassword(usuarioData.getPassword());
            usuario.setEstatus(usuarioData.getEstatus());
            usuario.setRol(usuarioData.getRol());
            return usuarioRepository.save(usuario);
        } else return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id") Long id){
        if (usuarioRepository.existsById(id)) usuarioRepository.deleteById(id);
    }
}
