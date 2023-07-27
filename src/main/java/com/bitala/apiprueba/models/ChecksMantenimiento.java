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

    @ManyToOne
    @JoinColumn(name = "id_check")
    private Checks idCheck;

    private String checked = "false";

    public ChecksMantenimiento(){
        
    }

    public ChecksMantenimiento(Long idCheckMan, Long idVerificacion, Checks idCheck, String checked) {
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

    public Checks getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(Checks idCheck) {
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
