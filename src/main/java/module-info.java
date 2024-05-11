module com.example.javasocket1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javasocket1 to javafx.fxml;
    exports com.example.javasocket1;
}