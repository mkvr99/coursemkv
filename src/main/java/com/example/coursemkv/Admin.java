package com.example.coursemkv;

public class Admin {
    int admin_id;
    String firstname;
    String lastname;

    public Admin(int admin_id, String firstname, String lastname) {
        this.admin_id = admin_id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Admin(){}
    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
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
