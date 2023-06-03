package com.example.coursemkv;

import com.example.coursemkv.User;
import com.example.coursemkv.JDBCPostgreSQL;
import com.example.coursemkv.Messages;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.sql.SQLException;

public class UserControl {
    public TextArea text_mail;
    public Button send_button;
    public Button close_button;
    public Label label_status;
    public Label label_default;
    public Button end_message;
    public Button load_button;
    public ImageView geoimage;
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

    public void end_message(ActionEvent actionEvent) {

    }

    public void load_button(ActionEvent actionEvent) {
    }
}