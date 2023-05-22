package com.example.coursemkv;

public class User {
    int users_id;
    String firstname;
    String lastname;

    public User(int users_id, String firstname, String lastname) {
        this.users_id = users_id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
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
