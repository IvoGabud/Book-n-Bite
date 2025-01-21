package com.booknbite.app.model.request;

import com.booknbite.app.model.UserType;

public class KorisnikBool {

    private String ocjenjivacId;
    private String ocjenjivacIme;
    private String email;
    private boolean isRegistered;
    private UserType userType;
    private Boolean isVerified;
    private Boolean isFilled;
    private Boolean blokiran;

    public KorisnikBool(){

    }

    public Boolean getBlokiran() {
        return blokiran;
    }

    public void setBlokiran(Boolean blokiran) {
        this.blokiran = blokiran;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean verified) {
        isVerified = verified;
    }

    public Boolean getIsFilled() {
        return isFilled;
    }

    public void setIsFilled(Boolean filled) {
        isFilled = filled;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public boolean getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
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

    public void setOcjenjivacIme(String ocjenjivacIme) {
        this.ocjenjivacIme = ocjenjivacIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
