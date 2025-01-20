package com.booknbite.app.model.request;

import org.springframework.web.multipart.MultipartFile;

public class CreateJeloRestoranRequest {
    private String naziv;
    private String opis;
    private String kategorija;
    private String cijena;
    private String alergeni;
    private MultipartFile imageSrc;

    public CreateJeloRestoranRequest(){

    }

    public CreateJeloRestoranRequest(String naziv, String opis, String kategorija, String cijena, String alergeni, MultipartFile imageSrc) {
        this.naziv = naziv;
        this.opis = opis;
        this.kategorija = kategorija;
        this.cijena = cijena;
        this.alergeni = alergeni;
        this.imageSrc = imageSrc;
    }

    public MultipartFile getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(MultipartFile imageSrc) {
        this.imageSrc = imageSrc;
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
}
