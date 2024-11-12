package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Proizvod {
    @Id
    @Column(nullable = false)
    private String nazivProizvod;
    private String restoran;
    private String kategorijaJelo;
    private Long cijena;
    private String povezniceProizvodi;
    private String vrstaProizvod;
}
