package com.booknbite.app.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Grupa {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupa;
    private String kodGrupa;
    private String kategorijaGrupa;

    public Grupa(){

    }

    public Long getIdGrupa() {
        return idGrupa;
    }

    public void setIdGrupa(Long idGrupa) {
        this.idGrupa = idGrupa;
    }

    public String getKodGrupa() {
        return kodGrupa;
    }

    public void setKodGrupa(String kodGrupa) {
        this.kodGrupa = kodGrupa;
    }

    public String getKategorijaGrupa() {
        return kategorijaGrupa;
    }

    public void setKategorijaGrupa(String kategorijaGrupa) {
        this.kategorijaGrupa = kategorijaGrupa;
    }

    //private String lokacijaGrupa;
    //private Long listaJelaId;

    /*
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
     */
}
