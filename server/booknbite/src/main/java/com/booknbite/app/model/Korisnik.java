package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Korisnik {
    @Id
    @Column(nullable = false)
    private Long korisnikId;
    private String email;
    private String korisnickoIme;
}
