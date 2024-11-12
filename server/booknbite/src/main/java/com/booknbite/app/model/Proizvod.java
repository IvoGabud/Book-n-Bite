package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Proizvod {
    @Id
    @Column(nullable = false)
    private String nazivProizvod;
    private String kategorijaJelo;
    private Long cijena;
    private String povezniceProizvodi;
    private String vrstaProizvod;

    @ManyToOne
    @JoinColumn(name = "korisnikId", referencedColumnName = "korisnikId")
    private Restoran restoran;

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}
