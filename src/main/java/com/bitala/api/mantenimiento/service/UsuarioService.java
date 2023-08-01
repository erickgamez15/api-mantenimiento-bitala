package com.bitala.api.mantenimiento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitala.api.mantenimiento.models.Usuario;
import com.bitala.api.mantenimiento.repository.IUsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private IUsuarioRepository usuarioRepository;

    public Usuario findByEmail(String email){
        return usuarioRepository.findByEmail(email);   
    }
}
