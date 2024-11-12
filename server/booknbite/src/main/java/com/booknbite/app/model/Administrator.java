package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Administrator {
    @Id
    @Column(nullable = false)
    private Long korisnikId;
}
