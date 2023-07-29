package com.bitala.apiprueba.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - CHECKSMANTENIMIENTO
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "checks_mantenimiento")
@EntityListeners(AuditingEntityListener.class)
public class ChecksMantenimiento {

    /* 
    CREATE TABLE `checks_mantenimiento` (
	    `id_check_man` int(11) NOT NULL,
	    `id_verificacion` int(11) NOT NULL,
	    `id_check` int(11) NOT NULL,
	    `checked` varchar(15) DEFAULT 'false'
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
    
    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
    @Column(name = "id_check_man")
    private Long idCheckMan;
    
    @Column(name = "id_verificacion")
    private Long idVerificacion;

    @Column(name = "id_check")
    private Long idCheck;

    private String checked = "false";

    public ChecksMantenimiento(){
        
    }

    //Constructor para inicializar variables
    public ChecksMantenimiento(Long idCheckMan, Long idVerificacion, Long idCheck, String checked) {
        this.idCheckMan = idCheckMan;
        this.idVerificacion = idVerificacion;
        this.idCheck = idCheck;
        this.checked = checked;
    }

    //Metodos Get y Set
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

    //Metodo toString
    @Override
    public String toString() {
        return "ChecksMantenimiento [idCheckMan=" + idCheckMan + ", idVerificacion=" + idVerificacion + ", idCheck=" + idCheck + ", checked=" + checked + "]";
    }
}
