package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Restoran {
    @Id
    @Column(nullable = false)
    private String nazivrRestoran;
    private String lokacija;
    private String radnoVrijeme;
    private CjenovniRang cjenovniRang;
    private String brojTelefona;
    private String poveznicaSlike;
}
