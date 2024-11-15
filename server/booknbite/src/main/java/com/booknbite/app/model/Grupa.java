package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Grupa {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupa;
    private String groupCode;
    private String kategorijaGrupa;

    public Grupa(){

    }

    public Long getIdGrupa() {
        return idGrupa;
    }

    public void setIdGrupa(Long idGrupa) {
        this.idGrupa = idGrupa;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String kodGrupa) {
        this.groupCode = kodGrupa;
    }

    public String getKategorijaGrupa() {
        return kategorijaGrupa;
    }

    public void setKategorijaGrupa(String kategorijaGrupa) {
        this.kategorijaGrupa = kategorijaGrupa;
    }

}
