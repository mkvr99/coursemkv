module com.example.coursemkv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.coursemkv to javafx.fxml;
    exports com.example.coursemkv;
}