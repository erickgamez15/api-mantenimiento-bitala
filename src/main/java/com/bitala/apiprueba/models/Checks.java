package com.bitala.apiprueba.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - CHECKS
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "checks")
@EntityListeners(AuditingEntityListener.class)
public class Checks {

    /* 
    CREATE TABLE `checks` (
		`id_check` int(11) NOT NULL,
		`categoria` int(11) NOT NULL,
		`descripcion` varchar(128) NOT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
    
    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
    @Column(name = "id_check")
    private Long idCheck;
    
    private Long categoria;
    private String descripcion;

    public Checks(){

    }

    //Constructor para inicializar variables
    public Checks(Long idCheck, Long categoria, String descripcion){
        this.idCheck = idCheck;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    //Metodos Get y Set
    public Long getIdCheck(){
        return idCheck;
    }

    public void setIdCheck(Long idCheck){
        this.idCheck = idCheck;
    }

    public Long getCategoria(){
        return categoria;
    }

    public void setCategoria(Long categoria){
        this.categoria = categoria;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Checks [idCheck=" + idCheck + ", categoria=" + categoria + ", descripcion=" + descripcion + "]";
    }
}
