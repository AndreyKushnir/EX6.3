package com.company;

//         Player Class
//        Each player has a firstname.
public class Player {
    private String firstname;
    private String lastname;

    public Player(String lastname, String firstname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullname() {
        return lastname + " " + firstname;
    }
}
