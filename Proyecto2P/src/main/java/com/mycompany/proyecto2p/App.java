/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2p;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author leoan
 */
public class App extends Application {

    private static Scene scene;

    public static String pathFiles = "src/main/resources/files/";
    public static String pathImg = "src/main/resources/images/";

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmLoader = new FXMLLoader(App.class.getResource("/fxml/VentanaPrincipal.fxml"));
        Parent root = fxmLoader.load();
        scene = new Scene(root, 800, 600);
        stage.setTitle("COPA MUNDIAL BRASIL 2014");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
