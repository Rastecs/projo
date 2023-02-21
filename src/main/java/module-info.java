module com.example.projo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.projo to javafx.fxml;
    exports com.example.projo;
}