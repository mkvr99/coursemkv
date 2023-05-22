package com.example.coursemkv;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;

public class UserControl {
    public TextArea text_mail;
    public Button send_button;
    public Button close_button;
    public Label label_status;
    private JDBCPostgreSQL db;
    private User user;
    Messages messages;

    public void setUser(User user) {
        this.user = user;
    }

    public void setDb(JDBCPostgreSQL db) {
        this.db = db;
    }


    public void send(ActionEvent actionEvent) throws SQLException {
        db = new JDBCPostgreSQL();
        db.Connection();
        String status = db.createMessage(text_mail.getText(), user);
        label_status.setText(status);
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }
}