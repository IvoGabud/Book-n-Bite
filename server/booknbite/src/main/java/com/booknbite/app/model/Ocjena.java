package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Ocjena {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOcjena;
    private String grupaKod;
    private String idOcjenjivac;
    private Integer ocjena;
    private Long idJela;
    @ManyToOne
    @JoinColumn(name = "grupa_id", nullable = false)
    private Grupa grupa;

    public Ocjena(){

    }

    public Long getIdJela() {
        return idJela;
    }

    public void setIdJela(Long idJela) {
        this.idJela = idJela;
    }

    public String getGrupaKod() {
        return grupaKod;
    }

    public void setGrupaKod(String grupaKod) {
        this.grupaKod = grupaKod;
    }

    public String getIdOcjenjivac() {
        return idOcjenjivac;
    }

    public void setIdOcjenjivac(String idOcjenjivac) {
        this.idOcjenjivac = idOcjenjivac;
    }

    public Integer getOcjena() {
        return ocjena;
    }

    public void setOcjena(Integer ocjena) {
        this.ocjena = ocjena;
    }
}
