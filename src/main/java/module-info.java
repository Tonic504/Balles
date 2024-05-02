module com.example.ballerebond {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ballerebond to javafx.fxml;
    exports com.example.ballerebond;
}