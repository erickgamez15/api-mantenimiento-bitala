package com.bitala.apiprueba.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - EMPRESA
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "empresa")
@EntityListeners(AuditingEntityListener.class)
public class Empresa {

    /* 
    CREATE TABLE `empresa` (
		`id_empresa` int(11) NOT NULL,
		`nombre` varchar(128) NOT NULL,
		`correo` varchar(128) NOT NULL,
		`telefono` varchar(16) NOT NULL,
		`direccion` varchar(128) DEFAULT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
    
    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
    @Column(name = "id_empresa")
    private Long idEmpresa;

    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

    public Empresa(){

    }

    //Construtor para inicializar variables
    public Empresa(Long idEmpresa, String nombre, String correo, String telefono, String direccion){
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    //Metodos Get y Set
    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    //Metodo toString
    @Override
    public String toString() {
        return "Empresa [idEmpresa=" + idEmpresa + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + "]";
    }
}
