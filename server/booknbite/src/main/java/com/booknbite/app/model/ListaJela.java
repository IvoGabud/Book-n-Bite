package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class ListaJela {
    @Id
    @Column(nullable = false)
    private Long listaJelaId;
}
