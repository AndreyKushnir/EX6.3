package com.company;

//         Player Class
//        Each player has a firstname.
class Player {

    private String firstname;
    private String lastname;

    Player(String lastname, String firstname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    String getFirstname() {
        return firstname;
    }

    String getLastname() {
        return lastname;
    }

    String getFullname() {
        return lastname + " " + firstname;
    }
}
