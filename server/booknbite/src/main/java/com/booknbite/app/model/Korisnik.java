package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Korisnik {
    @Id
    @Column(nullable = false)
    private String korisnikId;
    private String korisnickoIme;
    private String email;

    public Korisnik() {
    }

    public String getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(String korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
