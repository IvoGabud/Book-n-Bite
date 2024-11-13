package com.booknbite.app.model;


public class OcjenjivacBool {

    private String ocjenjivacId;
    private String ocjenjivacIme;
    private String email;
    private boolean registriran;

    public OcjenjivacBool() {
    }

    public String getOcjenjivacId() {
        return ocjenjivacId;
    }

    public void setOcjenjivacId(String ocjenjivacId) {
        this.ocjenjivacId = ocjenjivacId;
    }

    public String getOcjenjivacIme() {
        return ocjenjivacIme;
    }

    public void setOcjenjivacIme(String korisnickoIme) {
        this.ocjenjivacIme = korisnickoIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRegistriran() {
        return registriran;
    }

    public void setRegistriran(boolean registriran) {
        this.registriran = registriran;
    }
}
