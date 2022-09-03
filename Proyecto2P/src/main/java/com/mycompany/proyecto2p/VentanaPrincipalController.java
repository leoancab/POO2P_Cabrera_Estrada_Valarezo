/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leoan
 */
public class VentanaPrincipalController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private ImageView ivCopa;
    @FXML
    private ImageView ivCampeones;
    @FXML
    private Button btnPartidos;
    @FXML
    private Button btnCopas;
    @FXML
    private Label lbTitulo;
    @FXML
    private HBox hbTitulo;
    @FXML
    private HBox hbImagen;
    @FXML
    private HBox hbBotones;

    /**
     * Metodo que inicializa el controller de la VentanaPrincipal. En este
     * metodo se encuentran imagenes que tienen relacion al futbol. Tambien se
     * encuentran los botones que inicializan otras ventanas como Consulta de
     * Partidos y Consulta de Mundiales.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hbTitulo = new HBox();
        hbImagen = new HBox();
        hbBotones = new HBox();
        lbTitulo = new Label("Copa Mundial de la FIFA Brasil 2014");
        btnPartidos = new Button("CONSULTA DE PARTIDOS");
        btnCopas = new Button("CONSULTA DE COPAS MUNDIALES");

        try ( FileInputStream input = new FileInputStream(App.pathImg + "copa2014.jpg")) {
            Image imagen = new Image(input);
            ivCopa = new ImageView(imagen);
            ivCopa.setFitWidth(100);
            ivCopa.setFitHeight(100);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error. Vuelva a intentar.");
        }
        try ( FileInputStream input = new FileInputStream(App.pathImg + "campeones.jpg")) {
            Image imagen = new Image(input);
            ivCampeones = new ImageView(imagen);
            ivCampeones.setFitWidth(600);
            ivCampeones.setFitHeight(400);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error. Vuelva a intentar.");
        }

        hbTitulo.setPrefHeight(100);
        hbImagen.setPrefHeight(400);
        hbBotones.setPrefHeight(100);

        lbTitulo.setFont(new Font(36));
        hbTitulo.setAlignment(Pos.CENTER);
        hbTitulo.setSpacing(20);
        hbTitulo.getChildren().addAll(lbTitulo, ivCopa);

        hbImagen.getChildren().add(ivCampeones);
        hbImagen.setAlignment(Pos.CENTER);

        btnPartidos.setTextFill(Color.WHITE);
        btnCopas.setTextFill(Color.WHITE);
        btnPartidos.setStyle("-fx-background-color:blue;");
        btnCopas.setStyle("-fx-background-color:blue;");
        hbBotones.setAlignment(Pos.CENTER);
        hbBotones.setSpacing(100);
        hbBotones.getChildren().addAll(btnPartidos, btnCopas);

        root.getChildren().addAll(hbTitulo, hbImagen, hbBotones);

        btnPartidos.setOnAction((ActionEvent t) -> {
            try {
                consultaPartidos(t);
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Error: Vuelva a intentar.");
            }
        });
        btnCopas.setOnAction((ActionEvent t) -> {
            try {
                consultaCopas(t);
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Error: Vuelva a intentar.");
            }
        });
    }

    /**
     * Este método se encarga de cargar el fxml de Consulta de Partidos,
     * iniciando su stage.
     *
     */
    @FXML
    public void consultaPartidos(Event t) throws IOException {
        FXMLLoader fxmLoader = new FXMLLoader(App.class.getResource("/fxml/ConsultaPartidos.fxml"));
        Parent root2 = fxmLoader.load();
        Scene scene = new Scene(root2);
        Stage stage = new Stage();
        stage.setTitle("CONSULTA DE PARTIDOS");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Este método se encarga de cargar el fxml de Consulta de Copas, iniciando
     * su stage.
     *
     */
    @FXML
    public void consultaCopas(Event t) throws IOException {
        FXMLLoader fxmLoader = new FXMLLoader(App.class.getResource("/fxml/ConsultaCopas.fxml"));
        Parent root2 = fxmLoader.load();
        Scene scene = new Scene(root2);
        Stage stage = new Stage();
        stage.setTitle("CONSULTA DE COPAS MUNDIALES");
        stage.setScene(scene);
        stage.show();
    }

}
