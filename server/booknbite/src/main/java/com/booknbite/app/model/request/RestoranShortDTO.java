package com.booknbite.app.model.request;

public class RestoranShortDTO {
    private String nazivRestoran;
    private String korisnikId;
    private Double ocjena = 0.0;

    public Double getOcjena() {
        return ocjena;
    }

    public void setOcjena(Double ocjena) {
        this.ocjena += ocjena;
    }

    public String getNazivRestoran() {
        return nazivRestoran;
    }

    public void setNazivRestoran(String nazivRestoran) {
        this.nazivRestoran = nazivRestoran;
    }

    public String getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(String korisnikId) {
        this.korisnikId = korisnikId;
    }
}
