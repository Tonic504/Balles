module com.example.ballerebond {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.ballerebond to javafx.fxml;
    exports com.example.ballerebond;
}