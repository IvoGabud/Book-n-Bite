package com.booknbite.app.model.request;

public class JeloRestoranDTO {
    private String nazivJela;
    private String opisJela;
    private String kategorija;
    private String cijena;
    private String alergeni;
    private String imageSrc;
    private Long jeloRestoranId;

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

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
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

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Long getJeloRestoranId() {
        return jeloRestoranId;
    }

    public void setJeloRestoranId(Long jeloRestoranId) {
        this.jeloRestoranId = jeloRestoranId;
    }
}
