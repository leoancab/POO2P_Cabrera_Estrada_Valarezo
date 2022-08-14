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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
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
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hbTitulo=new HBox();
        hbImagen=new HBox();
        hbBotones=new HBox();
        try(FileInputStream input=new FileInputStream(App.pathImg+"copa2014.jpg")){
            Image imagen=new Image(input);
            ivCopa =new ImageView(imagen);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        lbTitulo=new Label("Copa Mundial de la FIFA Brasil 2014");
        hbTitulo.getChildren().addAll(lbTitulo,ivCopa);
        root.getChildren().add(lbTitulo);
    }    
    
}
