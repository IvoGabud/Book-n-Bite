package com.booknbite.app.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Grupa {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grupaId;
    private String grupaKod;
    private String grupaKategorija;
    @OneToMany(mappedBy = "grupa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ocjena> ocjene;

    public Grupa(){}

    public String getGrupaKod() {
        return grupaKod;
    }

    public void setGrupaKod(String grupaKod) {
        this.grupaKod = grupaKod;
    }

    public String getGrupaKategorija() {
        return grupaKategorija;
    }

    public void setGrupaKategorija(String grupaKategorija) {
        this.grupaKategorija = grupaKategorija;
    }

}
