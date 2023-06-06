package com.example.coursemkv;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public interface DAO {
    public void Connection();

    public void createUser(String login, String password);

    public void createAdmin(String login, String password);

    public void loginUser(String login, String password, ActionEvent event);

    public void loginAdmin(String login, String password, ActionEvent event);

    public ObservableList<Messages> getMessages(Admin adm);

    public void deleteMessage(int id, ActionEvent event);

    public String createMessage(String text, User user);

    public void update(String text, int idID);
}
