package com.booknbite.app.model.request;

public class JeloRestoranDTO {
    private String naziv;
    private String opis;
    private String kategorija;
    private String cijena;
    private String alergeni;
    private String slikaJelaUrl;
    private Long jeloRestoranId;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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

    public String getSlikaJelaUrl() {
        return slikaJelaUrl;
    }

    public void setSlikaJelaUrl(String slikaJelaUrl) {
        this.slikaJelaUrl = slikaJelaUrl;
    }

    public Long getJeloRestoranId() {
        return jeloRestoranId;
    }

    public void setJeloRestoranId(Long jeloRestoranId) {
        this.jeloRestoranId = jeloRestoranId;
    }
}
