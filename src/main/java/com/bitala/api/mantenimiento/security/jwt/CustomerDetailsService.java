package com.bitala.api.mantenimiento.security.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bitala.api.mantenimiento.models.Usuario;
import com.bitala.api.mantenimiento.service.UsuarioService;

@Service
public class CustomerDetailsService implements UserDetailsService {

    //Anotación para inyección de dependencias
    @Autowired
    private UsuarioService usuarioService;

    private Usuario usuario;

    public CustomerDetailsService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usuario = usuarioService.findByEmail(username);

        if (usuario != null) {
            return new User(usuario.getEmail(), usuario.getPassword(), new ArrayList<>());
        } else{
            throw new UsernameNotFoundException("User not found");
        }
    }

    public Usuario getUserDetails(){
        return usuario;
    }
    
}
