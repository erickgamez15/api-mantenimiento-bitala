package com.bitala.apiprueba.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "checks")
@EntityListeners(AuditingEntityListener.class)
public class Checks {
    @Id
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

    @Override
    public String toString(){
        return "checks [id_check" + idCheck + ", categoria" + categoria + ", descripcion" + descripcion + "]";
    }
}
