package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Grupa {
    @Id
    @Column(nullable = false)
    private Long idGrupa;
    private Long kodGrupa;
    private String kategorijaGrupa;
    private String lokacijaGrupa;
    private Long listaJelaId;
}
