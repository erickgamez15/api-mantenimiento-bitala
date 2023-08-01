package com.bitala.api.mantenimiento.controllers;

import org.springframework.web.bind.annotation.*;

import com.bitala.api.mantenimiento.models.Usuario;
import com.bitala.api.mantenimiento.repository.IUsuarioRepository;
import com.bitala.api.mantenimiento.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

//Para indicar que la clase es un controlador
@RestController
//Ruta para acceder a los usuarios
@RequestMapping("/api/usuario")
public class UsuarioController {

    //Anotación para inyección de dependencias
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    Usuario usuario;

    //Constructor para inyección de dependencias
    public UsuarioController(IUsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
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

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> findByEmail(@PathVariable("email") String email){
        usuario = usuarioService.findByEmail(email);
        
        if (usuario != null) return ResponseEntity.ok(usuario);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioData){
       usuario = usuarioRepository.findById(id).orElse(null);

        if(usuario != null){
            usuario.setNombre(usuarioData.getNombre());
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
