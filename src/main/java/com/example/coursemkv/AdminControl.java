package com.example.coursemkv;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
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
    public TableColumn <Messages, Integer> admin_click;
    public TableColumn <Messages, String> user_click;
    public Button load_button;
    public ImageView geoimage;
    private Messages messages;
    Admin admin;
    ObservableList<Messages> observableListMessages;
    @FXML
    TableColumn сol0, col1, col2,col3,col4, col5;
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

    public void start() {
        db = new JDBCPostgreSQL();
        db.Connection();
        db.update(status.getText(), messages.getMes_id());

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
        сol0 = new TableColumn("№ заявки");
        col1 = new TableColumn("Статус");
        col2 = new TableColumn("№ посетителя");
        col3 = new TableColumn("Примечание");
        col4 = new TableColumn("Утв_1");
        col5 = new TableColumn("Утв_2");
        listmail.setEditable(true);
        observableListMessages = db.getMessages(admin);

        сol0.setMinWidth(15); // ширина
        сol0.setCellValueFactory(new PropertyValueFactory<Messages, Integer>("mes_id"));
        col1.setMinWidth(60); // ширина
        col1.setCellValueFactory(new PropertyValueFactory<Messages, String>("status"));
        col2.setMinWidth(60); // ширина
        col2.setCellValueFactory(new PropertyValueFactory<Messages, Integer>("id_users"));
        col3.setMinWidth(60); // ширина
        col3.setCellValueFactory(new PropertyValueFactory<Messages, String>("description"));
        col3.setMinWidth(60); // ширина
        col4.setCellValueFactory(new PropertyValueFactory<Messages, Integer>("admin_click"));
        col4.setMinWidth(60); // ширина
        col5.setCellValueFactory(new PropertyValueFactory<Messages, String>("user_click"));
        col5.setMinWidth(60); // ширина

        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col1.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Messages, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Messages, String> t) {
                        ((Messages) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setStatus(t.getNewValue());
                        int idd = ((Messages) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).getMes_id();
                        System.out.println(idd);
                        db.update(t.getNewValue(),  ((Messages) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).getMes_id());
                    }
                }
        );
        listmail.getColumns().add(сol0);
        listmail.getColumns().add(col1);
        listmail.getColumns().add(col2);
        listmail.getColumns().add(col3);
        listmail.getColumns().add(col4);
        listmail.getColumns().add(col5);
        listmail.setItems(observableListMessages);
    }

    public void end_message(ActionEvent actionEvent) {

    }

    public void load_button(ActionEvent actionEvent) {
    }
}