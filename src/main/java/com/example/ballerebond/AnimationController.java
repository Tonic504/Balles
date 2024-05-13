package com.example.ballerebond;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javafx.scene.media.Media;
public class AnimationController {


    private final Image WIISPORT = new Image("Images/WiiSportFondCD.png");
    private final Image ARKANOID = new Image("Images/ArkanoidFondCD.png");
    private final Image MARIOETSONICJO = new Image("Images/MarioetSonicFondCD.png");
    private final Image MLPIT = new Image("Images/MLPITFondCD.png");
    private final Image OCTOPATHTRAVELERS = new Image("Images/OctopathTravelersFondCD.png");
    private final Image SONICCOLOURS = new Image("Images/SonicColorsFondCD.png");
    private final Image SPLATOONSIDEORDER = new Image("Images/SplatoonSideOrderFondCD.png");
    private final Image TETRISDS = new Image("Images/TetrisDSFondCD.png");

    private MediaPlayer mediaPlayer;
    private Media media;

    private boolean peutChanger = true;



    RotateTransition rotateTransition ;



    @FXML
    private StackPane stackDisque;

    @FXML
    private Circle disque;

    @FXML
    void arreter(ActionEvent event) {
        if (rotateTransition != null) {rotateTransition.pause();}
        if (mediaPlayer!=null){mediaPlayer.pause();}
    }

    @FXML
    void jouer(ActionEvent event) {
        if (rotateTransition==null){
        rotateTransition = new RotateTransition(Duration.seconds(3), stackDisque);
        if (mediaPlayer!=null){mediaPlayer.stop();}
        // Définir l'angle de départ et d'arrivée
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);

        // Définir l'interpolateur pour un mouvement fluide
        rotateTransition.setInterpolator(Interpolator.LINEAR);

        // Répéter l'animation indéfiniment
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        }
        rotateTransition.play();

        if(media==null){
            media = new Media(getClass().getResource("Music/Gallery.mp3").toString());
            peutChanger=false;
        }
        if(peutChanger){
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        peutChanger = false;}
    }


    @FXML
    void jouerArkanoid(ActionEvent event) {
        changerImageCD(ARKANOID);
        changerMusicCD("Music/HeatSink.mp3");
    }

    @FXML
    void jouerMLPIT(ActionEvent event) {
        changerImageCD(MLPIT);
        changerMusicCD("Music/Boss Battle.mp3");
    }

    @FXML
    void jouerMSJO2008(ActionEvent event) {
        changerImageCD(MARIOETSONICJO);
        changerMusicCD("Music/TableTennis.mp3");
    }

    @FXML
    void jouerOctopath(ActionEvent event) {
        changerImageCD(OCTOPATHTRAVELERS);
        changerMusicCD("Music/OCTOPATHTRAVELER.mp3");
    }

    @FXML
    void jouerSonic(ActionEvent event) {
        changerImageCD(SONICCOLOURS);
        changerMusicCD("Music/TerminalVelocity.mp3");
    }

    @FXML
    void jouerSplatoon(ActionEvent event) {
        changerImageCD(SPLATOONSIDEORDER);
        changerMusicCD("Music/NewWorldOrder.mp3");
    }

    @FXML
    void jouerTetris(ActionEvent event) {
        changerImageCD(TETRISDS);
        changerMusicCD("Music/Tetris.mp3");
    }

    @FXML
    void jouerWiiSport(ActionEvent event) {
        changerImageCD(WIISPORT);
        changerMusicCD("Music/WiiSports.mp3");
    }

    @FXML
    void retourBallesRebondissantes(ActionEvent event) throws IOException {
        MainApplication.changerScene("balles-view.fxml","Balles Rebondissantes");
        mediaPlayer.stop();

    }

    @FXML
    void retourMenu(ActionEvent event) throws IOException {
        MainApplication.changerScene("main-view.fxml","Menu");
        mediaPlayer.stop();
    }

    @FXML
    void retourObjet(ActionEvent event) throws IOException {
        MainApplication.changerSceneObjet("Objet 3D");
        mediaPlayer.stop();

    }

    private void changerImageCD(Image cd){
        disque.setFill(new ImagePattern(cd));
    }

    private void changerMusicCD(String chemin){
        if(mediaPlayer!=null){
        mediaPlayer.stop();}
        if(rotateTransition!=null){rotateTransition.pause();}
        String fullPath = getClass().getResource(chemin).toString();
        media =new Media(getClass().getResource(chemin).toString());
        peutChanger=true;
    }



}
