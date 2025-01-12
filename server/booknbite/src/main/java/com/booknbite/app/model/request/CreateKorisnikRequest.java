package com.booknbite.app.model.request;

import com.booknbite.app.model.UserType;

public class CreateKorisnikRequest {

    private String username;
    private String firstName;
    private String lastName;
    private UserType userType;

    public CreateKorisnikRequest(){

    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
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
