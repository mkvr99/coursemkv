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

public class SignUpController {
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

    public void setDb(JDBCPostgreSQL db) {
        this.db = db;
    }


    public void reg(ActionEvent actionEvent) {
        db = new JDBCPostgreSQL();
        if(user_box.isSelected()){
            db.createUser(login_field.getText(), password_field.getText());
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("authorize.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(loader.load()));
                HelloController newcontrol = loader.getController();
                newcontrol.setDb(db);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(admin_box.isSelected()){
            db.createAdmin(login_field.getText(), password_field.getText());
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("authorize.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(loader.load()));
                HelloController newcontrol = loader.getController();
                newcontrol.setDb(db);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            System.out.println("error!");
        }
    }
}
