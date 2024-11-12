package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Ocjena {
    @Id
    @Column(nullable = false)
    private Long brOcjena;
}
