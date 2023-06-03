package com.example.coursemkv;


/**
 * Класс, описывающий посетителя
 */

public class User extends myHuman {
    /** Поле id посетителя */
    int id_users;
    /** Поле логин посетителя*/
    String firstname;
    /** Поле пароль посетителя */
    String lastname;

    /**
     * Конструктор - создание нового объекта
     */
    public User(){}

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_users - id посетителя
     * @param firstname - логин посетителя
     * @param lastname - пароль посетителя
     */
    public User(int id_users, String firstname, String lastname) {
        this.id_users = id_users;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Функция получения значения поля {@link User#id_users}
     * @return возвращает id посетителя
     */
    public int getId_users() {
        return id_users;
    }

    /**
     * Процедура определения id пользователя {@link User#id_users}
     * @param id_users - id посетителя
     */
    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    /**
     * Функция получения значения поля {@link User#firstname}
     * @return возвращает логин посетителя
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Процедура определения логина посетителя {@link User#firstname}
     * @param firstname - логин посетителя
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Функция получения значения поля {@link User#lastname}
     * @return возвращает пароль посетителя
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Процедура определения пароля посетителя {@link User#lastname}
     * @param lastname - пароль посетителя
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
