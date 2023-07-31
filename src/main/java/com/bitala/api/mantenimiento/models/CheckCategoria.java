package com.bitala.api.mantenimiento.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - CHECKCATEGORIA
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "check_categoria")
@EntityListeners(AuditingEntityListener.class)
public class CheckCategoria {

    /*
    CREATE TABLE `check_categoria` (
		`id_categoria` int(11) NOT NULL,
		`nombre` varchar(45) DEFAULT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
    
    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
    @Column(name = "id_categoria")
    private Long idCategoria;

    private String nombre;

    public CheckCategoria() {
    }

    //Constructor para inicializar variables
    public CheckCategoria(Long idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    //Metodos Get y Set
    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "CheckCategoria [idCategoria=" + idCategoria + ", nombre=" + nombre + "]";
    }
}
