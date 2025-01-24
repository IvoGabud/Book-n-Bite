package com.booknbite.app.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Grupa {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grupaId;
    private String grupaKod;
    private LocalDateTime createdAt;
    private Integer count = 0;
    private String grupaKategorija;
    @OneToMany(mappedBy = "grupa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ocjena> ocjene;

    public Grupa(){}

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }

    public void setOcjene(List<Ocjena> ocjene) {
        this.ocjene = ocjene;
    }

    public Integer getCount() {
        return count;
    }

    public void incrementCount() {
        this.count += 1;
    }

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
