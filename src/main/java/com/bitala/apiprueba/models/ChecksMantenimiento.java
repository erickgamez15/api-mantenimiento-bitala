package com.bitala.apiprueba.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@Table(name = "checks_mantenimiento")
@EntityListeners(AuditingEntityListener.class)
public class ChecksMantenimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que sea autoincrementable
    @Column(name = "id_check_man")
    private Long idCheckMan;
    
    @Column(name = "id_verificacion")
    private Long idVerificacion;

    @Column(name = "id_check")
    private Long idCheck;

    private String checked = "false";

    public ChecksMantenimiento(){
        
    }

    public ChecksMantenimiento(Long idCheckMan, Long idVerificacion, Long idCheck, String checked) {
        this.idCheckMan = idCheckMan;
        this.idVerificacion = idVerificacion;
        this.idCheck = idCheck;
        this.checked = checked;
    }

    public Long getIdCheckMan() {
        return idCheckMan;
    }

    public void setIdCheckMan(Long idCheckMan) {
        this.idCheckMan = idCheckMan;
    }

    public Long getIdVerificacion() {
        return idVerificacion;
    }

    public void setIdVerificacion(Long idVerificacion) {
        this.idVerificacion = idVerificacion;
    }

    public Long getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(Long idCheck) {
        this.idCheck = idCheck;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "ChecksMantenimiento [idCheckMan=" + idCheckMan + ", idVerificacion=" + idVerificacion + ", idCheck=" + idCheck + ", checked=" + checked + "]";
    }
}
