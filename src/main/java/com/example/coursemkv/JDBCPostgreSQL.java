package com.example.coursemkv;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDBCPostgreSQL {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/helpmkv";
    static final String USER = "postgres";
    static final String PASS = "mkv";
    Connection connection = null;

    Messages messages;
    Admin admin;

    public User getUser() {
        return user;
    }

    User user;
    JDBCPostgreSQL db;

    public Connection getConnection() {
        return connection;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }
    public Admin getAdmin(){
        return admin;
    }
    public void Connection() {
        System.out.println("Testing connection to PostgreSQL JDBC");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }
        System.out.println("PostgreSQL JDBC Driver successfully connected");

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }


    public void createUser(String login, String password) {
        try {
            this.connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
        String query = "INSERT INTO users(firstname, lastname) VALUES(?, ?)";

            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, login);
                pst.setString(2, password);
                pst.executeUpdate();
                System.out.println("success created user");

            } catch (SQLException error) {
                Logger logger = Logger.getLogger(JDBCPostgreSQL.class.getName());
                logger.log(Level.SEVERE, error.getMessage(), error);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }


    }

    public void createAdmin(String login, String password) {
        try {
            this.connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        String query = "INSERT INTO admins(firstname, lastname) VALUES(?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, login);
            pst.setString(2, password);
            pst.executeUpdate();
            System.out.println("success created user");

        } catch (SQLException error) {
            Logger logger = Logger.getLogger(JDBCPostgreSQL.class.getName());
            logger.log(Level.SEVERE, error.getMessage(), error);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void loginUser(String login, String password, ActionEvent event) {
        try {
            this.connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
        user = new User();
        String query = "SELECT * FROM users WHERE firstname = ? AND lastname = ?";
        ResultSet resultSet;

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, login);
            pst.setString(2, password);
            resultSet = pst.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in the database");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String log = resultSet.getString("firstname");
                    String pass = resultSet.getString("lastname");


                    if (log.equals(login) && pass.equals(password)) {
                            user.setId_users(resultSet.getInt("id_users"));
                            user.setFirstname(log);
                            user.setLastname(pass);
                    } else {
                        System.out.println("Login or password did not match!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Incorrect");
                        alert.show();
                    }
                }
            }



        } catch (SQLException error){
            Logger logger = Logger.getLogger(JDBCPostgreSQL.class.getName());
            logger.log(Level.SEVERE, error.getMessage(), error);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void loginAdmin(String login, String password, ActionEvent event) {
        try {
            this.connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        admin = new Admin();
        String query = "SELECT * FROM admins WHERE firstname = ? AND lastname = ?";
        ResultSet resultSet;

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, login);
            pst.setString(2, password);
            resultSet = pst.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in the database");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String log = resultSet.getString("firstname");
                    String pass = resultSet.getString("lastname");

                    if (log.equals(login) && pass.equals(password)) {
                        admin.setAdmin_id(resultSet.getInt("admin_id"));
                        admin.setFirstname(log);
                        admin.setLastname(pass);

                        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("window_admin.fxml"));
                        Stage stage = new Stage();
                        stage.setScene(new Scene(loader.load()));
                        AdminControl newcontrol = loader.getController();
                        newcontrol.setDb(db);
                        //newcontrol.setMessages(messages);
                        stage.show();

                         */

                    } else {
                        System.out.println("Login or password did not match!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Incorrect");
                        alert.show();
                }
                }
            }

        } catch (SQLException error){
            Logger logger = Logger.getLogger(JDBCPostgreSQL.class.getName());
            logger.log(Level.SEVERE, error.getMessage(), error);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ObservableList<Messages> getMessages(Admin adm) {
        try {
            this.connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        ObservableList<Messages> data = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM message");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Messages message = new Messages(rs.getInt("mes_id"),
                        rs.getString("status"),
                        rs.getInt("id_users"),
                        rs.getString("description")
                );
                System.out.println(message.getMes_id());
                System.out.println(message.getId_users());
                data.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        ResultSet resultSet;
//        String query = "SELECT * FROM message WHERE mes_id = ?";
//
//        try (PreparedStatement pst = connection.prepareStatement(query)) {
//            pst.setInt(1, HelloApplication.id_mail);
//            resultSet = pst.executeQuery();
//
//
//            if (!resultSet.isBeforeFirst()) {
//                System.out.println("mail result empty");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("mail result empty");
//                alert.show();
//            } else {
//                System.out.println("mail not empty");
//            }
//
//            try {
//                while (resultSet.next()) {
//                    Messages event =
//                            new Messages(
//                                    resultSet.getInt("mes_id"),
//                                    resultSet.getString("status"),
//                                    resultSet.getInt("id_users"),
//                                    resultSet.getString("description")
//                            );
//                    data.add(event);
//                }
//            } catch (SQLException error) {
//                System.out.println(error.getMessage());
//            }
//
//
//        } catch (SQLException error) {
//            Logger logger = Logger.getLogger(JDBCPostgreSQL.class.getName());
//            logger.log(Level.SEVERE, error.getMessage(), error);
//
//        }
        return data;
    }

    public void deleteMessage(int id, ActionEvent event) {
        try {
            this.connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        String query = "DELETE FROM message WHERE mes_id = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("delete message");
        } catch (SQLException error) {
            Logger logger = Logger.getLogger(JDBCPostgreSQL.class.getName());
            logger.log(Level.SEVERE, error.getMessage(), error);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String createMessage(String text, User user) {
        try {
            this.connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        String def_mail = "Заявка отправлена";
        String query = "INSERT INTO message(status, id_users, description) VALUES(?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, def_mail);
            pst.setInt(2, user.getId_users());
            pst.setString(3, text);
            pst.executeUpdate();
            System.out.println("success created message");
        } catch (SQLException error) {
            Logger logger = Logger.getLogger(JDBCPostgreSQL.class.getName());
            logger.log(Level.SEVERE, error.getMessage(), error);
        } finally {

            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return def_mail;
    }

    public void update(String text, int idID) {
        try {
            this.connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
        String query = "UPDATE message SET status = ? WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, text);
            pst.setInt(2, idID);
            int n = pst.executeUpdate();  // выполнить UPDATE запрос
            System.out.println("Количество обновлённых строк: " + n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}