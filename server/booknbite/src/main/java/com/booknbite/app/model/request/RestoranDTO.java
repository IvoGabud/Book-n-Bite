package com.booknbite.app.model.request;

import com.booknbite.app.model.CjenovniRang;

public class RestoranDAO {
    private String nazivRestoran;
    private String lokacija;
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

    public String getNazivRestoran() {
        return nazivRestoran;
    }

    public void setNazivRestoran(String nazivRestoran) {
        this.nazivRestoran = nazivRestoran;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
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
