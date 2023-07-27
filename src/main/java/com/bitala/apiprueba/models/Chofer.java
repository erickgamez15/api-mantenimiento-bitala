package com.bitala.apiprueba.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@Table(name = "chofer")
@EntityListeners(AuditingEntityListener.class)
public class Chofer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que sea autoincrementable
    @Column(name = "id_chofer")
    private Long idChofer;
    
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String password;

    @Column(name = "no_lista")
    private String noLista;

    @Column(name = "foto_chofer")
    private String fotoChofer;

    public Chofer(){

    }

    //Constructor para inicialziar variables
    public Chofer(Long idChofer, String nombre, String apellidos, String correo, String telefono, String password, String noLista, String fotoChofer) {
        this.idChofer = idChofer;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
        this.noLista = noLista;
        this.fotoChofer = fotoChofer;
    }

    public Long getIdChofer() {
        return idChofer;
    }

    public void setIdChofer(Long idChofer) {
        this.idChofer = idChofer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoLista() {
        return noLista;
    }

    public void setNoLista(String noLista) {
        this.noLista = noLista;
    }

    public String getFotoChofer() {
        return fotoChofer;
    }

    public void setFotoChofer(String fotoChofer) {
        this.fotoChofer = fotoChofer;
    }

    @Override
    public String toString() {
        return "Chofer [idChofer=" + idChofer + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", telefono=" + telefono + ", password=" + password + ", noLista=" + noLista + ", fotoChofer=" + fotoChofer + "]";
    }
}
