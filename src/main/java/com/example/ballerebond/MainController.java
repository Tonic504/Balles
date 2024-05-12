package com.example.ballerebond;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.io.IOException;

import static javafx.application.Platform.exit;

public class MainController {

    @FXML
    void demmarerAnimation(ActionEvent event) throws IOException {
        MainApplication.changerScene("animation-view.fxml","animation");

    }

    @FXML
    void demmarerBalles(ActionEvent event) throws IOException {
        MainApplication.changerScene("balles-view.fxml","Jeu des balles rebondissantes");

    }

    @FXML
    void demmarerObjet(ActionEvent event) throws IOException {
        MainApplication.changerSceneObjet("object-view.fxml","Objet 3D");

    }

    @FXML
    void quitterApplication(ActionEvent event) {
        exit();
    }

}
