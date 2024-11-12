package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Restoran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nazivrRestoran;
    private String lokacija;
    private String radnoVrijeme;
    private CjenovniRang cjenovniRang;
    private String brojTelefona;
    private String poveznicaSlike;

    @OneToOne
    @JoinColumn(name = "korisnikId", referencedColumnName = "korisnikId")
    private Korisnik korisnik;

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
