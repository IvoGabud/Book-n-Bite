package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class JeloRestoran {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jeloRestoranId;
    @ManyToOne
    @JoinColumn(name = "restoran_id", nullable = false)
    private Restoran restoran;
}
