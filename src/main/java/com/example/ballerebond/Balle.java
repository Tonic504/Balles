package com.example.ballerebond;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Balle extends Circle {
    private static final Image PIERRE_IMAGE = new Image("/images/pierre.png");
    private static final Image PAPIER_IMAGE = new Image("/images/feuille.png");
    private static final Image CISEAUX_IMAGE = new Image("/images/ciseaux.png");

    private static final Random RANDOM = new Random();

    private ImageView imageView;


    private Choix choix;
    public double direction;

    public Balle(double x, double y) {
        super(x, y, 20);
        assignerChoixAleatoire();
        initialiserImageView();
        direction = aleatoire(360);
    }

    private void assignerChoixAleatoire() {
        int choixIndex = RANDOM.nextInt(Choix.values().length);
        choix = Choix.values()[choixIndex];
    }

    private void initialiserImageView() {
        switch (choix) {
            case PIERRE:
                imageView = new ImageView(PIERRE_IMAGE);
                break;
            case PAPIER:
                imageView = new ImageView(PAPIER_IMAGE);
                break;
            case CISEAUX:
                imageView = new ImageView(CISEAUX_IMAGE);
                break;
        }
        // Ajustez ici la position de l'image par rapport au cercle
        imageView.setX(getCenterX() - 10);
        imageView.setY(getCenterY() - 10);
        this.setFill(new ImagePattern(imageView.getImage()));
        this.setStroke(Color.BLACK);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Choix getChoix() {
        return choix;
    }

    public void setChoix(Choix choix){
        this.choix = choix;
    }

    public void setImageView(ImageView image) {
        this.setFill(new ImagePattern(image.getImage()));
    }

    public enum Choix {
        PIERRE, PAPIER, CISEAUX
    }

    private int aleatoire(int max){
        Random rand = new Random();
        return rand.nextInt(max +1);
    }
}

