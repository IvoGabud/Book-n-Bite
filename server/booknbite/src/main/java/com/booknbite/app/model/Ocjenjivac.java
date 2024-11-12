package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Ocjenjivac {
    @Id
    @Column(nullable = false)
    private String ocjenjivacId;
    private String ocjenjivacIme;
    private String email;

    public Ocjenjivac() {
    }

    public String getOcjenjivacId() {
        return ocjenjivacId;
    }

    public void setOcjenjivacId(String korisnikId) {
        this.ocjenjivacId = korisnikId;
    }

    public String getOcjenjivacIme() {
        return ocjenjivacIme;
    }

    public void setOcjenjivacIme(String korisnickoIme) {
        this.ocjenjivacIme = korisnickoIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
