package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Ocjenjivac {
    @Id
    @Column(nullable = false)
    private String ocjenjivacId;
    private String ocjenjivacIme;
    private String email;
    private String username;
    private String firstName;
    private String lastName;

    public Ocjenjivac() {
    }

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

    public String getOcjenjivacId() {
        return ocjenjivacId;
    }

    public void setOcjenjivacId(String ocjenjivacId) {
        this.ocjenjivacId = ocjenjivacId;
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
}
