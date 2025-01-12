package com.booknbite.app.model;

import jakarta.persistence.*;

@MappedSuperclass
public class Korisnik {
    @Id
    @Column(nullable = false)
    private String korisnikId;
    private String email;
    private String korisnickoIme;

    public String getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(String korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
}
