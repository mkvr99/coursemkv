package com.example.coursemkv;

public class User {
    int id_users;
    String firstname;
    String lastname;
    public User(){}
    public User(int id_users, String firstname, String lastname) {
        this.id_users = id_users;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId_users() {
        return id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
