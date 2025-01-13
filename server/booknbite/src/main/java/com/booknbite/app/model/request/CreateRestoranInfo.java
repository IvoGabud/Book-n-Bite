package com.booknbite.app.model.request;

public class CreateRestoranInfo {

    private String nazivRestoran;
    private String odVrijeme;
    private String doVrijeme;
    private String adresa;
    private String brTelefon;
    private String link;

    public CreateRestoranInfo(){

    }

    public String getNazivRestoran() {
        return nazivRestoran;
    }

    public void setNazivRestoran(String nazivRestoran) {
        this.nazivRestoran = nazivRestoran;
    }

    public String getOdVrijeme() {
        return odVrijeme;
    }

    public void setOdVrijeme(String odVrijeme) {
        this.odVrijeme = odVrijeme;
    }

    public String getDoVrijeme() {
        return doVrijeme;
    }

    public void setDoVrijeme(String doVrijeme) {
        this.doVrijeme = doVrijeme;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrTelefon() {
        return brTelefon;
    }

    public void setBrTelefon(String brTelefon) {
        this.brTelefon = brTelefon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
