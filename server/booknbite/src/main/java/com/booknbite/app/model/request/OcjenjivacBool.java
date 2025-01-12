package com.booknbite.app.model.request;

import com.booknbite.app.model.UserType;

public class OcjenjivacBool{

    private String ocjenjivacId;
    private String ocjenjivacIme;
    private String email;
    private boolean isRegistered;
    private UserType userType;

    public OcjenjivacBool(){

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
