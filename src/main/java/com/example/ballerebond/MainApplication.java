package com.example.ballerebond;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    static Stage stage;
    @Override
    public void start(Stage sStage) throws IOException {

        FXMLLoader mainFxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene mainScene = new Scene(mainFxmlLoader.load(), 1280, 720);
        stage = sStage;



        stage.setTitle("Hello!");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    static void changerScene(String fxml, String titreFenetre) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(fxml));
        Scene scene = new Scene(loader.load(),1280,720);

        stage.setTitle(titreFenetre);
        stage.setScene(scene);
    }
}