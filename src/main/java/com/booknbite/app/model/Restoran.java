package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Restoran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long korisnikId;
    private String nazivrRestoran;
    private String lokacija;
    private String radnoVrijeme;
    private CjenovniRang cjenovniRang;
    private String brojTelefona;
    private String poveznicaSlike;
}
