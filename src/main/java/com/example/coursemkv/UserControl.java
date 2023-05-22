package com.example.coursemkv;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;

public class UserControl {
    public TextArea text_mail;
    public Button send_button;
    public Button close_button;
    private JDBCPostgreSQL db;

    public void setDb(JDBCPostgreSQL db) {
        this.db = db;
    }
    

    public void send(ActionEvent actionEvent) throws SQLException {
        db = new JDBCPostgreSQL();
        db.Connection();
        db.createMessage(text_mail.getText(), actionEvent);
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }
}
