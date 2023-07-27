package com.bitala.apiprueba.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@Table(name = "fotos_anomalia")
@EntityListeners(AuditingEntityListener.class)
public class FotosAnomalia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que sea autoincrementable
    @Column(name = "id_foto_anomalia")
    private Long idFotoAnomalia;

    @Column(name = "id_anomalia")
    private Long idAnomalia;

    private String foto;

    public FotosAnomalia() {
    }

    public FotosAnomalia(Long idFotoAnomalia, Long idAnomalia, String foto) {
        this.idFotoAnomalia = idFotoAnomalia;
        this.idAnomalia = idAnomalia;
        this.foto = foto;
    }

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

    @Override
    public String toString() {
        return "FotosAnomalia [idFotoAnomalia=" + idFotoAnomalia + ", idAnomalia=" + idAnomalia + ", foto=" + foto + "]";
    }
}
