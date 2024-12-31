package com.booknbite.app.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Restoran extends Korisnik {
    private String nazivRestoran;
    private String lokacija;
    private String radnoVrijeme;
    private CjenovniRang cjenovniRang;
    private String brojTelefona;
    private String poveznicaSlike;
    @OneToMany(mappedBy = "restoran", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JeloRestoran> jelaRestoran;
}