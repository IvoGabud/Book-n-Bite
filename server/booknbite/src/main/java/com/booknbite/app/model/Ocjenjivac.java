package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Ocjenjivac {
    @Id
    @Column(nullable = false)
    private String ocjenjivacIme;
    private String email;

    public Ocjenjivac() {
    }

    @OneToOne
    @JoinColumn(name = "korisnikId", referencedColumnName = "korisnikId")
    private Korisnik korisnik;

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
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
