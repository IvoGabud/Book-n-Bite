package com.booknbite.app.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Restoran extends Korisnik {
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
    private Boolean blokiran;
    @OneToMany(mappedBy = "restoran", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JeloRestoran> jelaRestoran;

    public Restoran(String nazivRestoran, Double latLok, Double lngLok, String radnoVrijemeOd, String radnoVrijemeDo, CjenovniRang cjenovniRang, String brojTelefona, String poveznicaSlike, String username, String firstName, String lastName, Boolean isVerified, Boolean isFilled, String id, String email, String korIme) {
        this.setKorisnikId(id);
        this.setEmail(email);
        this.setKorisnickoIme(korIme);
        this.setUserType(UserType.RESTORAN);
        this.nazivRestoran = nazivRestoran;
        this.latLok = latLok;
        this.lngLok = lngLok;
        this.radnoVrijemeOd = radnoVrijemeOd;
        this.radnoVrijemeDo = radnoVrijemeDo;
        this.cjenovniRang = cjenovniRang;
        this.brojTelefona = brojTelefona;
        this.poveznicaSlike = poveznicaSlike;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isVerified = isVerified;
        this.isFilled = isFilled;
        this.jelaRestoran = new ArrayList<>();
        this.blokiran = false;
    }

    public Restoran(){
        isVerified = false;
        isFilled = false;
        blokiran = false;
    }

    public Boolean getBlokiran() {
        return blokiran;
    }

    public void setBlokiran(Boolean blokiran) {
        this.blokiran = blokiran;
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

    public Boolean getIsFilled() {
        return isFilled;
    }

    public void setIsFilled(Boolean filled) {
        isFilled = filled;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean verified) {
        isVerified = verified;
    }

    public String getRadnoVrijemeDo() {
        return radnoVrijemeDo;
    }

    public void setRadnoVrijemeDo(String radnoVrijemeDo) {
        this.radnoVrijemeDo = radnoVrijemeDo;
    }

    public String getNazivRestoran() {
        return nazivRestoran;
    }

    public void setNazivRestoran(String nazivRestoran) {
        this.nazivRestoran = nazivRestoran;
    }

    public String getRadnoVrijemeOd() {
        return radnoVrijemeOd;
    }

    public void setRadnoVrijemeOd(String radnoVrijeme) {
        this.radnoVrijemeOd = radnoVrijeme;
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

    public List<JeloRestoran> getJelaRestoran() {
        return jelaRestoran;
    }

    public void setJelaRestoran(List<JeloRestoran> jelaRestoran) {
        this.jelaRestoran = jelaRestoran;
    }
}