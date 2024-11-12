package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Administrator {
    @Id
    @Column(nullable = false)
    private String adminIme;

    /*
    @OneToOne
    @JoinColumn(name = "korisnikId", referencedColumnName = "korisnikId")
    private Korisnik korisnik;


    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
     */
}
