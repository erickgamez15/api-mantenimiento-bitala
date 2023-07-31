package com.bitala.api.mantenimiento.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - FOTOSANOMALIA
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "fotos_anomalia")
@EntityListeners(AuditingEntityListener.class)
public class FotosAnomalia {

    /* 
    CREATE TABLE `fotos_anomalia` (
		`id_foto_anomalia` int(11) NOT NULL,
		`id_anomalia` int(11) NOT NULL,
		`foto` varchar(45) NOT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
    
    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
    @Column(name = "id_foto_anomalia")
    private Long idFotoAnomalia;

    @Column(name = "id_anomalia")
    private Long idAnomalia;

    private String foto;

    public FotosAnomalia() {

    }

    //Constructor para inicializar variables
    public FotosAnomalia(Long idFotoAnomalia, Long idAnomalia, String foto) {
        this.idFotoAnomalia = idFotoAnomalia;
        this.idAnomalia = idAnomalia;
        this.foto = foto;
    }

    //Metodos Get y Set
    public Long getIdFotoAnomalia() {
        return idFotoAnomalia;
    }

    public void setIdFotoAnomalia(Long idFotoAnomalia) {
        this.idFotoAnomalia = idFotoAnomalia;
    }

    public Long getIdAnomalia() {
        return idAnomalia;
    }

    public void setIdAnomalia(Long idAnomalia) {
        this.idAnomalia = idAnomalia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "FotosAnomalia [idFotoAnomalia=" + idFotoAnomalia + ", idAnomalia=" + idAnomalia + ", foto=" + foto + "]";
    }
}
