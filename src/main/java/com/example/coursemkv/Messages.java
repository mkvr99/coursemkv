package com.example.coursemkv;

import java.util.Date;

public class Messages {
    public int mes_id;
    public String status;
    public int id_users;
    public String description;

    public Messages(int id_mes, String status, int id_users, String description) {
        this.mes_id = id_mes;
        this.status = status;
        this.id_users = id_users;
        this.description = description;
    }

    public int getMes_id() {
        return mes_id;
    }

    public void setMes_id(int id) {
        this.mes_id = mes_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String name) {
        this.status = status;
    }

    public int getId_user() {
        return id_users;
    }

    public void setId_user(Date date_start) {
        this.id_users = id_users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(Date date_end) {
        this.description = description;
    }
}