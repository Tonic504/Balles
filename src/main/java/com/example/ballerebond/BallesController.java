package com.example.ballerebond;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallesController {

    @FXML
    private Pane zoneDeJeu;

    private List<Balle> balles = new ArrayList<>();
    private int vitesse = 5;
    private boolean enPause = false;

    private Timeline timeline;

    @FXML
    void ajouterBalles(ActionEvent event) {
        Balle ballePierre = new Balle(redimmension(aleatoire(1000),1000), redimmension(aleatoire(500),500), Balle.Choix.PIERRE);
        balles.add(ballePierre);
        Balle balleFeuille = new Balle(redimmension(aleatoire(1000),1000), redimmension(aleatoire(500),500),  Balle.Choix.PAPIER);
        balles.add(balleFeuille);
        Balle balleCiseaux = new Balle(redimmension(aleatoire(1000),1000), redimmension(aleatoire(500),500),  Balle.Choix.CISEAUX);
        balles.add(balleCiseaux);
        zoneDeJeu.getChildren().add(ballePierre);
        zoneDeJeu.getChildren().add(balleFeuille);
        zoneDeJeu.getChildren().add(balleCiseaux);
        if (timeline == null) {
            timeline = new Timeline(new KeyFrame(Duration.millis(16), e -> deplacerBalles()));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }

    private void deplacerBalles() {
        if (!enPause) {
            for (Balle balle : balles) {

                double dx = vitesse * Math.cos(Math.toRadians(balle.direction));
                double dy = vitesse * Math.sin(Math.toRadians(balle.direction));

                double newX = balle.getCenterX() + dx;
                double newY = balle.getCenterY() + dy;

                if (newX - balle.getRadius() <= 0 || newX + balle.getRadius() >= zoneDeJeu.getWidth()) {
                    balle.direction = 180 - balle.direction; // Inverser la direction horizontale
                    dx = vitesse * Math.cos(Math.toRadians(balle.direction));
                }
                if (newY - balle.getRadius() <= 0 || newY + balle.getRadius() >= zoneDeJeu.getHeight()) {
                    balle.direction = -balle.direction; // Inverser la direction verticale
                    dy = vitesse * Math.sin(Math.toRadians(balle.direction));
                }

                balle.setCenterX(balle.getCenterX() + dx);
                balle.setCenterY(balle.getCenterY() + dy);
            }
            verifierCollisions();
        }
    }

    private void verifierCollisions() {
        for (int i = 0; i < balles.size(); i++) {
            Balle balle1 = balles.get(i);
            for (int j = i + 1; j < balles.size(); j++) {
                Balle balle2 = balles.get(j);
                if (balle1.getBoundsInParent().intersects(balle2.getBoundsInParent())) {
                    jouerPierrePapierCiseaux(balle1, balle2);
                }
            }
        }
    }

    private void jouerPierrePapierCiseaux(Balle balle1, Balle balle2) {
        Balle.Choix choix1 = balle1.getChoix();
        Balle.Choix choix2 = balle2.getChoix();


        if (choix1 == choix2) {

            return; // Égalité
        }

        if ((choix1 == Balle.Choix.PIERRE && choix2 == Balle.Choix.CISEAUX) ||
                (choix1 == Balle.Choix.PAPIER && choix2 == Balle.Choix.PIERRE) ||
                (choix1 == Balle.Choix.CISEAUX && choix2 == Balle.Choix.PAPIER)) {
            // balle1 gagne, balle2 perd
            balle2.setChoix(balle1.getChoix());
            balle2.setImage2(balle1.getChoix());

            System.out.println(choix1 + "/" + choix2);
        } else {
            // balle2 gagne, balle1 perd
            balle1.setChoix(balle2.getChoix());
            balle1.setImage2(balle2.getChoix());
            System.out.println(choix1 + "/" + choix2);
        }
    }

    @FXML
    void mettreEnPause(MouseEvent event) {
        enPause = true;
    }

    @FXML
    void reprendreLeJeu(MouseEvent event) {
        enPause = false;
    }

    @FXML
    void retirerBalles(ActionEvent event) {
        if (!balles.isEmpty()) {
            Balle balle = balles.remove(balles.size() - 1);
            zoneDeJeu.getChildren().remove(balle);
        }
    }

    @FXML
    void retourMenu(ActionEvent event) throws IOException {
        MainApplication.changerScene("main-view.fxml","Menu");
    }


    private int aleatoire(int max){
        Random rand = new Random();
        return rand.nextInt(max +1);
    }

    private int redimmension(int dim, int max){
        if (dim<50){dim+=50;}
        if (dim>max-50){dim-=50;}
        return dim;
    }
}
