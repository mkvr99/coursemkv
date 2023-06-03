module com.example.coursemkv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.xml.crypto;


    opens com.example.coursemkv to javafx.fxml;
    exports com.example.coursemkv;
//    opens com.example.coursemkv.controls to javafx.fxml;
//    opens com.example.coursemkv.model to javafx.fxml;
}