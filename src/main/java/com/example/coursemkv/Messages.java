package com.example.coursemkv;

/**
 * Класс, описывающий заявку
 */

public class Messages {

    /** Поле id заявки */
    public int mes_id;

    /** Поле статус заявки */
    public String status;

    /** Поле id посетителя */
    public int id_users;

    /** Поле примечание к заявке */
    public String description;

    /** Поле нажатия кнопки администратором */
    public boolean admin_click;

    /** Поле нажатия кнопки посетителем */
    public boolean user_click;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id_mes - id заявки
     * @param status - статус заявки
     * @param id_users - id посетителя
     * @param description - примечание к заявке
     * @param admin_click - проверка нажатия кнопки администратором
     * @param user_click - проверка нажатия кнопки посетителем
     */
    public Messages(int id_mes, String status, int id_users, String description, boolean admin_click, boolean user_click) {
        this.mes_id = id_mes;
        this.status = status;
        this.id_users = id_users;
        this.description = description;
        this.admin_click = admin_click;
        this.user_click = user_click;
    }

    /**
     * Функция получения значения поля {@link Messages#mes_id}
     * @return возвращает id заявки
     */
    public int getMes_id() {
        return mes_id;
    }

    /**
     * Процедура определения id пользователя {@link Messages#mes_id}
     * @param id - id заявки
     */
    public void setMes_id(int id) {
        this.mes_id = mes_id;
    }

    /**
     * Функция получения значения поля {@link Messages#admin_click}
     * @return возвращает true/false в зависимости от нажатия кнопки
     */
    public boolean isAdmin_click() {
        return admin_click;
    }

    /**
     * Процедура определения нажатия кнопки администратором {@link Messages#admin_click}
     * @param admin_click - проверка нажатия кнопки администратором
     */
    public void setAdmin_click(boolean admin_click) {
        this.admin_click = admin_click;
    }

    /**
     * Функция получения значения поля {@link Messages#user_click}
     * @return возвращает true/false в зависимости от нажатия кнопки
     */
    public boolean isUser_click() {
        return user_click;
    }

    /**
     * Процедура определения нажатия кнопки посетителем {@link Messages#user_click}
     * @param user_click - проверка нажатия кнопки посетителем
     */
    public void setUser_click(boolean user_click) {
        this.user_click = user_click;
    }

    /**
     * Функция получения значения поля {@link Messages#status}
     * @return возвращает id посетителя
     */
    public String getStatus() {
        return status;
    }

    /**
     * Процедура определения id пользователя {@link Messages#status}
     * @param name - статус заявки
     */
    public void setStatus(String name) {
        this.status = status;
    }

    /**
     * Функция получения значения поля {@link Messages#id_users}
     * @return возвращает id посетителя
     */
    public int getId_users() {
        return id_users;
    }

    /**
     * Процедура определения id пользователя {@link Messages#id_users}
     * @param id_users - id посетителя
     */
    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    /**
     * Функция получения значения поля {@link Messages#description}
     * @return возвращает примечание к заявке
     */
    public String getDescription() {
        return description;
    }

    /**
     * Процедура определения примечания {@link Messages#description}
     * @param description - примечание к заявке
     */
    public void setDescription(String description) {
        this.description = description;
    }
}