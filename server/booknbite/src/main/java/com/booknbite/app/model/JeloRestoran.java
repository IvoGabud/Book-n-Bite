package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class JeloRestoran {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jeloRestoranId;
    @ManyToOne
    @JoinColumn(name = "restoran_id", nullable = false)
    private Restoran restoran;
    private String naziv;
    private String opis;
    private String kategorija;
    private String cijena;
    private String alergeni;
    private String slikaJelaUrl;

    public JeloRestoran(Long jeloRestoranId, Restoran restoran, String naziv, String opis, String kategorija, String cijena, String alergeni, String slikaJelaUrl) {
        this.jeloRestoranId = jeloRestoranId;
        this.restoran = restoran;
        this.naziv = naziv;
        this.opis = opis;
        this.kategorija = kategorija;
        this.cijena = cijena;
        this.alergeni = alergeni;
        this.slikaJelaUrl = slikaJelaUrl;
    }

    public JeloRestoran() {

    }

    public Long getJeloRestoranId() {
        return jeloRestoranId;
    }

    public void setJeloRestoranId(Long jeloRestoranId) {
        this.jeloRestoranId = jeloRestoranId;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

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
}
