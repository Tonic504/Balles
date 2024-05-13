package com.example.ballerebond;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.io.IOException;

import static javafx.application.Platform.exit;

/**
 * Menu principal qui regroupe tout les chemins pour aller aux autres activités
 */
public class MainController {
    /**
     * démmare l'application de l'animation
     * @param event
     * @throws IOException
     */
    @FXML
    void demmarerAnimation(ActionEvent event) throws IOException {
        MainApplication.changerScene("animation-view.fxml","animation");

    }

    /**
     * démarre l'application des balles rebondissantes
     * @param event
     * @throws IOException
     */
    @FXML
    void demmarerBalles(ActionEvent event) throws IOException {
        MainApplication.changerScene("balles-view.fxml","Jeu des balles rebondissantes");

    }

    /**
     * démarre l'objet 3D
     * @param event
     * @throws IOException
     */
    @FXML
    void demmarerObjet(ActionEvent event) throws IOException {
        MainApplication.changerSceneObjet("Objet 3D");

    }

    /**
     * Éteint l'application
     * @param event
     */
    @FXML
    void quitterApplication(ActionEvent event) {
        exit();
    }

}
