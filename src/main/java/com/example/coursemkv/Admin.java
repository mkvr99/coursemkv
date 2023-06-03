package com.example.coursemkv;

/**
 * Класс, описывающий админстратора
 */

public class Admin extends myHuman {
    /** Поле id администратора */
    int admin_id;
    /** Поле логин администратора */
    String firstname;
    /** Поле пароль администратора */
    String lastname;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param admin_id - id администратора
     * @param firstname - логин
     * @param lastname - пароль
     */
    public Admin(int admin_id, String firstname, String lastname) {
        this.admin_id = admin_id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Конструктор - создание нового объекта
     */
    public Admin(){}

    /**
     * Функция получения значения поля {@link Admin#admin_id}
     * @return возвращает id администратора
     */
    public int getAdmin_id() {
        return admin_id;
    }

    /**
     * Процедура определения id пользователя {@link Admin#admin_id}
     * @param admin_id - id администратора
     */
    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    /**
     * Функция получения значения поля {@link Admin#firstname}
     * @return возвращает логин администратора
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Процедура определения логина пользователя {@link Admin#firstname}
     * @param firstname - логин администратора
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Функция получения значения поля {@link Admin#lastname}
     * @return возвращает пароль администратора
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Процедура определения пароля пользователя {@link Admin#lastname}
     * @param lastname - пароль администратора
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
