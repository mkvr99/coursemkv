package com.example.coursemkv;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminControl implements Initializable {
    public Button endbutton;
    public TableView<Messages> listmail;
    public Button okbutton;
    public TableColumn <Messages, Integer> id_mail;
    public TableColumn <Messages, String> status;
    public TableColumn <Messages, Integer> id_users;
    public TableColumn <Messages, String>text;
    private Messages messages;
    Admin admin;

    JDBCPostgreSQL db;
    public void setDb(JDBCPostgreSQL db) {
        this.db = db;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void start(ActionEvent actionEvent) {
        db = new JDBCPostgreSQL();
        db.Connection();
        db.update(status.getText(), actionEvent);

    }

    public void end(ActionEvent actionEvent) {
        Stage stage = (Stage) endbutton.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        db = new JDBCPostgreSQL();
        db.Connection();



        //listmail.setItems(db.getMessages());
    }

    public void deletemail(ActionEvent actionEvent) {
        db = new JDBCPostgreSQL();
        db.Connection();
        Messages messages = listmail.getSelectionModel().getSelectedItem();
        db.deleteMessage(messages.getMes_id(), actionEvent);
    }

    public void updateInf(ActionEvent actionEvent) {
        id_mail.setCellValueFactory(new PropertyValueFactory<>("mes_id"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        id_users.setCellValueFactory(new PropertyValueFactory<>("id_users"));
        text.setCellValueFactory(new PropertyValueFactory<>("description"));
        listmail.setItems(db.getMessages(admin));
    }
}
