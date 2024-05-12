package com.example.ballerebond;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainApplication extends Application {

    static Stage stage;
    @Override
    public void start(Stage sStage) throws IOException {

        FXMLLoader mainFxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene mainScene = new Scene(mainFxmlLoader.load(), 1280, 720);
        stage = sStage;



        stage.setTitle("Menu");
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

    static void changerSceneObjet(String fxml, String titreFenetre) throws IOException {


        stage.setTitle(titreFenetre);

        boolean is3DSupported = Platform.isSupported(ConditionalFeature.SCENE3D);
        if(!is3DSupported) {
            System.out.println("JavaFx 3D n'est pas supporter par votre appareil");
            return;
        }

        Cylinder cylindre = new Cylinder(300,300,300);

        cylindre.setTranslateX(640);
        cylindre.setTranslateY(360);

        cylindre.setRotationAxis(Rotate.X_AXIS);



        Cylinder millieu = new Cylinder(150,500,150);

        millieu.setTranslateX(640);
        millieu.setTranslateY(360);


        boolean fixedEyeAtCameraZero = false;
        PerspectiveCamera camera = new PerspectiveCamera(fixedEyeAtCameraZero);



        Group root = new Group(cylindre, millieu);
        root.setRotationAxis(Rotate.X_AXIS);
        root.setRotate(0);

        Scene scene = new Scene(root, 1280, 720, true);
        scene.setCamera(camera);
        stage.setScene(scene);
        scene.setFill(Color.RED);



        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new KeyValue(root.rotateProperty(), 180)),
                new KeyFrame(Duration.seconds(5),
                        new KeyValue(root.rotateProperty(), 360))
        );

        timeline.setCycleCount(2);
        timeline.setAutoReverse(true); //pour AutoReverse pensez à mettre un deuxième cycle

        timeline.play();


        stage.setScene(scene);
    }
}