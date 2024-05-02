package com.example.ballerebond;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //initialisation de toute les scenes
        FXMLLoader mainFxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene mainScene = new Scene(mainFxmlLoader.load(), 320, 240);

        FXMLLoader animationFxmlLoader = new FXMLLoader(MainApplication.class.getResource("animation-view.fxml"));
        Scene animationScene = new Scene(mainFxmlLoader.load(), 320, 240);

        FXMLLoader ballesFxmlLoader = new FXMLLoader(MainApplication.class.getResource("balles-view.fxml"));
        Scene ballesScene = new Scene(mainFxmlLoader.load(), 320, 240);

        FXMLLoader objectFxmlLoader = new FXMLLoader(MainApplication.class.getResource("object-view.fxml"));
        Scene objectScene = new Scene(mainFxmlLoader.load(), 320, 240);

        stage.setTitle("Hello!");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}