package com.booknbite.app.model.request;

public class CreateRestoranInfo {

    private String nazivRestoran;
    private String odVrijeme;
    private String doVrijeme;
    private Double latLok;
    private Double lngLok;
    private String brTelefon;
    private String link;

    public CreateRestoranInfo(){

    }

    public Double getLatLok() {
        return latLok;
    }

    public void setLatLok(Double latLok) {
        this.latLok = latLok;
    }

    public Double getLngLok() {
        return lngLok;
    }

    public void setLngLok(Double lngLok) {
        this.lngLok = lngLok;
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
