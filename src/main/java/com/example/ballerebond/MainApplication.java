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

    static void changerSceneObjet(String fxml, String titreFenetre) throws IOException {


        stage.setTitle(titreFenetre);

        boolean is3DSupported = Platform.isSupported(ConditionalFeature.SCENE3D);
        if(!is3DSupported) {
            System.out.println("JavaFx 3D n'est pas supporter par votre appareil");
            return;
        }

        Cylinder Cylindre = new Cylinder(100,100,100);
        Cylindre.setCullFace(CullFace.NONE);
        Cylindre.setTranslateX(250);
        Cylindre.setTranslateY(100);

        Cylindre.setRotationAxis(Rotate.X_AXIS);
        Cylindre.setRotate(30);


        Sphere sphere = new Sphere(80);

        sphere.setTranslateX(250);
        sphere.setTranslateY(100);

        boolean fixedEyeAtCameraZero = false;
        PerspectiveCamera camera = new PerspectiveCamera(fixedEyeAtCameraZero);
        camera.setTranslateX(0);
        camera.setTranslateY(-50);


        Group root = new Group(Cylindre, sphere);
        root.setRotationAxis(Rotate.X_AXIS);
        root.setRotate(0);

        Scene scene = new Scene(root, 500, 300, true);
        scene.setCamera(camera);
        stage.setScene(scene);
        scene.setFill(Color.RED);

        final Timeline timeline2 = new Timeline();

        Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5),
                new KeyValue(root.rotateProperty(), 360)),
                new KeyFrame(Duration.seconds(1),
                        new KeyValue(root.rotateProperty(), 180))
        );

        timeline.setCycleCount(4);
        timeline.setAutoReverse(true);

        timeline.play();


        stage.setScene(scene);
    }
}