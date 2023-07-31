package com.bitala.api.mantenimiento.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
    
    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "estatus")
    private String estatus;

    @Column(name = "rol")
    private String rol;

    public Usuario() {

    }

    public Usuario(Long idUsuario, String nombre, String telefono, String email, String password, String estatus, String rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.estatus = estatus;
        this.rol = rol;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", password=" + password + ", estatus=" + estatus + ", rol=" + rol + "]";
    }
}
