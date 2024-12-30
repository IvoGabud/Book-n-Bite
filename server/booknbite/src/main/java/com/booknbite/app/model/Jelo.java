package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Jelo {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jeloId;
    private String imageSrc;
    private String nazivJela;
    private String opisJela;
    private String cijena;
    private String alergeni;
    private Integer initialOcjena = 0;
    private String grupaKategorija;

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getNazivJela() {
        return nazivJela;
    }

    public void setNazivJela(String nazivJela) {
        this.nazivJela = nazivJela;
    }

    public String getOpisJela() {
        return opisJela;
    }

    public void setOpisJela(String opisJela) {
        this.opisJela = opisJela;
    }

    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }

    public String getAlergeni() {
        return alergeni;
    }

    public void setAlergeni(String alergeni) {
        this.alergeni = alergeni;
    }

    public Integer getInitialOcjena() {
        return initialOcjena;
    }

    public void setInitialOcjena(Integer initialOcjena) {
        this.initialOcjena = initialOcjena;
    }

    public String getGrupaKategorija() {
        return grupaKategorija;
    }

    public void setGrupaKategorija(String grupaKategorija) {
        this.grupaKategorija = grupaKategorija;
    }
}
