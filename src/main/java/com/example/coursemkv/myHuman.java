package com.example.coursemkv;

/**
 * Абстрактный класс, на основе которого создаются
 * производные классы в зависимости от возможного типа пользователя системы
 */
public abstract class myHuman {
    int id;
    String firstname;
    String lastname;

    public myHuman(){}

    public myHuman(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
