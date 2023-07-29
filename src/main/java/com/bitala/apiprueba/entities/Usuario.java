package com.bitala.apiprueba.entities;

import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(
    name = "usuarios", 
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_name"}), 
        @UniqueConstraint(columnNames = {"email"}) 
    }
)
public class Usuario {
    
    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
    @Column(name = "id_usuario")
    private Long idUsuario;

    private String nombre;

    @Column(name = "user_name")
    private String userName;

    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles")
    private Set<Roles> roles = new HashSet<>();
}
