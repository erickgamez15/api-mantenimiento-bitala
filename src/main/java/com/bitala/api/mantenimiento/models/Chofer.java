package com.bitala.api.mantenimiento.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - CHOFER
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "chofer")
@EntityListeners(AuditingEntityListener.class)
public class Chofer {

    /* 
    CREATE TABLE `chofer` (
	    `id_chofer` int(11) NOT NULL,
		`nombre` varchar(128) NOT NULL,
		`apellidos` varchar(128) NOT NULL,
		`correo` varchar(128) NOT NULL,
		`telefono` varchar(16) DEFAULT NULL,
		`password` varchar(64) NOT NULL,
		`no_lista` varchar(45) DEFAULT 'S/N',
		`foto_chofer` varchar(45) DEFAULT 'user_default.png'
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
    
    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
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

    //Metodos Get y Set
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

    //Metodo toString
    @Override
    public String toString() {
        return "Chofer [idChofer=" + idChofer + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", telefono=" + telefono + ", password=" + password + ", noLista=" + noLista + ", fotoChofer=" + fotoChofer + "]";
    }
}
