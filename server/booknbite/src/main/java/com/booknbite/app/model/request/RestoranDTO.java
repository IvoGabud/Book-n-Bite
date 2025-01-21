package com.booknbite.app.model.request;

import com.booknbite.app.model.CjenovniRang;

public class RestoranDTO {
    private String id;
    private String nazivRestoran;
    private Double latLok;
    private Double lngLok;
    private String radnoVrijemeOd;
    private String radnoVrijemeDo;
    private CjenovniRang cjenovniRang;
    private String brojTelefona;
    private String poveznicaSlike;
    private String username;
    private String firstName;
    private String lastName;
    private Boolean isVerified;
    private Boolean isFilled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNazivRestoran() {
        return nazivRestoran;
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

    public void setNazivRestoran(String nazivRestoran) {
        this.nazivRestoran = nazivRestoran;
    }

    public String getRadnoVrijemeOd() {
        return radnoVrijemeOd;
    }

    public void setRadnoVrijemeOd(String radnoVrijemeOd) {
        this.radnoVrijemeOd = radnoVrijemeOd;
    }

    public String getRadnoVrijemeDo() {
        return radnoVrijemeDo;
    }

    public void setRadnoVrijemeDo(String radnoVrijemeDo) {
        this.radnoVrijemeDo = radnoVrijemeDo;
    }

    public CjenovniRang getCjenovniRang() {
        return cjenovniRang;
    }

    public void setCjenovniRang(CjenovniRang cjenovniRang) {
        this.cjenovniRang = cjenovniRang;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getPoveznicaSlike() {
        return poveznicaSlike;
    }

    public void setPoveznicaSlike(String poveznicaSlike) {
        this.poveznicaSlike = poveznicaSlike;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public Boolean getFilled() {
        return isFilled;
    }

    public void setFilled(Boolean filled) {
        isFilled = filled;
    }
}
