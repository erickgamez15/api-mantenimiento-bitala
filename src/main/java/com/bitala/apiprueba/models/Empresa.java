package com.bitala.apiprueba.models;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "empresa")
@EntityListeners(AuditingEntityListener.class)
public class Empresa {
    @Id
    @Column(name = "id_empresa")
    private Long idEmpresa;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

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

    @Override
    public String toString() {
        return "empresa [id_empresa" + idEmpresa + ", nombre" + nombre + ", correo" + correo + ", telefono" + telefono + ", direccion" + direccion +"]";
    }
}
