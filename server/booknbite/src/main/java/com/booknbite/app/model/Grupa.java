package com.booknbite.app.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Grupa {
    @Id
    @Column(nullable = false)
    private Long idGrupa;
    private Long kodGrupa;
    private String kategorijaGrupa;
    private String lokacijaGrupa;
    private Long listaJelaId;

    @ManyToOne
    @JoinColumn(name = "listaJelaId", referencedColumnName = "listaJelaId")
    private ListaJela listaJela;

    @OneToMany
    @JoinColumn(name = "korisnikId", referencedColumnName = "idGrupa")
    private List<Ocjenjivac> ocjenjivaci;

    public ListaJela getListaJela() {
        return listaJela;
    }

    public void setListaJela(ListaJela listaJela) {
        this.listaJela = listaJela;
    }

    public List<Ocjenjivac> getOcjenjivaci() {
        return ocjenjivaci;
    }

    public void setOcjenjivaci(List<Ocjenjivac> ocjenjivaci) {
        this.ocjenjivaci = ocjenjivaci;
    }
}
