package com.example.ballerebond;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class AnimationController {


    private final Image WIISPORT = new Image("Images/WiiSportFondCD.png");
    private final Image ARKANOID = new Image("Images/ArkanoidFondCD.png");
    private final Image MARIOETSONICJO = new Image("Images/MarioetSonicFondCD.png");
    private final Image MLPIT = new Image("Images/MLPITFondCD.png");
    private final Image OCTOPATHTRAVELERS = new Image("Images/OctopathTravelersFondCD.png");
    private final Image SONICCOLOURS = new Image("Images/SonicColorsFondCD.png");
    private final Image SPLATOONSIDEORDER = new Image("Images/SplatoonSideOrderFondCD.png");
    private final Image TETRISDS = new Image("Images/TetrisDSFondCD.png");


    @FXML
    private StackPane Stackdisque;

    @FXML
    private Circle disque;

    @FXML
    void arreter(ActionEvent event) {

    }

    @FXML
    void jouer(ActionEvent event) {

    }

    @FXML
    void jouerArkanoid(ActionEvent event) {
        changerImageCD(ARKANOID);
    }

    @FXML
    void jouerMLPIT(ActionEvent event) {
changerImageCD(MLPIT);
    }

    @FXML
    void jouerMSJO2008(ActionEvent event) {
changerImageCD(MARIOETSONICJO);
    }

    @FXML
    void jouerOctopath(ActionEvent event) {
changerImageCD(OCTOPATHTRAVELERS);
    }

    @FXML
    void jouerSonic(ActionEvent event) {
changerImageCD(SONICCOLOURS);
    }

    @FXML
    void jouerSplatoon(ActionEvent event) {
changerImageCD(SPLATOONSIDEORDER);
    }

    @FXML
    void jouerTetris(ActionEvent event) {
changerImageCD(TETRISDS);
    }

    @FXML
    void jouerWiiSport(ActionEvent event) {
changerImageCD(WIISPORT);
    }

    @FXML
    void retourBallesRebondissantes(ActionEvent event) throws IOException {
        MainApplication.changerScene("balles-view.fxml","Balles Rebondissantes");

    }

    @FXML
    void retourMenu(ActionEvent event) throws IOException {
    MainApplication.changerScene("main-view.fxml","Menu");
    }

    @FXML
    void retourObjet(ActionEvent event) throws IOException {
        MainApplication.changerSceneObjet("Objet 3D");

    }

    private void changerImageCD(Image cd){
        disque.setFill(new ImagePattern(cd));
    }

}
