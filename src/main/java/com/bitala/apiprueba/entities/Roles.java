package com.bitala.apiprueba.entities;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
//name sigue la nomenclatura de SQL
@Table(name = "roles")
@EntityListeners(AuditingEntityListener.class)
public class Roles {
    
    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "nombre_rol", length = 60)
    private String nombreRol;

    public Roles() {

    }

    //Constructor para inicizalizar variables
    public Roles(Long idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    //Metodos Get y Set
    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Roles [idRol=" + idRol + ", nombreRol=" + nombreRol + "]";
    } 
}
