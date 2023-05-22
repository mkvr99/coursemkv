package com.example.coursemkv;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private CheckBox admin_box;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button reg;

    @FXML
    private CheckBox user_box;

    @FXML
    private Label welcomelabel;

    JDBCPostgreSQL db;
    Admin admin;

    public void setDb(JDBCPostgreSQL db) {
        this.db = db;
    }

    public void reg(ActionEvent actionEvent) throws IOException {
        db = new JDBCPostgreSQL();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("reg.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            SignUpController newcontrol = loader.getController();
            newcontrol.setDb(db);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enter(ActionEvent actionEvent) throws IOException {
        db = new JDBCPostgreSQL();
        db.Connection();
        if(user_box.isSelected()){
            db.loginUser(login_field.getText(), password_field.getText(), actionEvent);
        } else if(admin_box.isSelected()){
            db.loginAdmin(login_field.getText(), password_field.getText(), actionEvent);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("window_admin.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            AdminControl admControl = loader.getController();
            admControl.setDb(db);
            admControl.setAdmin(db.getAdmin());//newcontrol.setMessages(messages);
            stage.show();
        } else{
            System.out.println("error!");
        }
    }
}