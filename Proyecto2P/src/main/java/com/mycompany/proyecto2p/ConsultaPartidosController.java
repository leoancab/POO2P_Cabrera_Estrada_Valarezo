/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author leoan
 */
public class ConsultaPartidosController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private ComboBox<String> cbFase;
    @FXML
    private ComboBox<String> cbGrupo;
    @FXML
    private ComboBox<String> cbEquipo1;
    @FXML
    private ComboBox<String> cbEquipo2;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarFases();
    }

    public void llenarFases() {
        cbFase.getItems().addAll("Grupos", "Ronda de 16", "Cuartos de Final", "Semifinal", "Final");
    }

}
