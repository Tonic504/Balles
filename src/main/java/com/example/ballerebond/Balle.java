package com.example.ballerebond;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.Random;

/**
 * Classe qui est utilisé pour instancier une balle, elle surcharge le Cercle de JavaFx
 */
public class Balle extends Circle {
    private static final Image PIERRE_IMAGE = new Image("/images/pierre.png");
    private static final Image PAPIER_IMAGE = new Image("/images/feuille.png");
    private static final Image CISEAUX_IMAGE = new Image("/images/ciseaux.png");

    private static final Random RANDOM = new Random();

    private ImageView imageView;


    private Choix choix;
    public double direction;

    /**
     * permet de créer une balle à partir du controller
     * @param x
     * @param y
     * @param choix
     */
    public Balle(double x, double y, Choix choix) {
        super(x, y, 20);
        this.choix = choix;
        initialiserImageView();
        direction = aleatoire(360);
    }

    /**
     * permet de mettre l'image à la création de la balle
     */
    private void initialiserImageView() {
        switch (choix) {
            case PIERRE:
                this.setFill(new ImagePattern(PIERRE_IMAGE));
                break;
            case PAPIER:
                this.setFill(new ImagePattern(PAPIER_IMAGE));
                break;
            case CISEAUX:
                this.setFill(new ImagePattern(CISEAUX_IMAGE));
                break;
        }


        this.setStroke(Color.BLACK);
    }


    /**
     * permet de retourner le choix de la balle
     * @return
     */
    public Choix getChoix() {
        return choix;
    }

    /**
     * permet de modifier le choix de la balle
     * @param choix
     */
    public void setChoix(Choix choix){
        this.choix = choix;
    }


    /**
     * permet de modifier l'image
     * @param choix
     */
    public void setImage(Choix choix){
        switch (choix) {
            case PIERRE:
                this.setFill(new ImagePattern(PIERRE_IMAGE));
                break;
            case PAPIER:
                this.setFill(new ImagePattern(PAPIER_IMAGE));
                break;
            case CISEAUX:
                this.setFill(new ImagePattern(CISEAUX_IMAGE));
                break;
        }
    }

    /**
     * énumérateur avec les trois état du pierre feuille ciseaux
     */
    public enum Choix {
        PIERRE, PAPIER, CISEAUX
    }

    /**
     * fonction pour retourner un chiffre aléatoire entre un maximum et 0
     * @param max
     * @return
     */
    private int aleatoire(int max){
        Random rand = new Random();
        return rand.nextInt(max +1);
    }

}

