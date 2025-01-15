package com.booknbite.app.model;

import jakarta.persistence.*;

@Entity
public class Ocjenjivac extends Korisnik {

    private String username;
    private String firstName;
    private String lastName;
    private String groupCode;

    public Ocjenjivac() {}

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
