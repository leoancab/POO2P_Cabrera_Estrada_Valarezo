/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author leoan
 */
public class ExportarGrupoController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aceptar();
        cancelar();
    }

    public void aceptar() {
        btnAceptar.setOnAction(t -> {
            System.out.println("a");
            Platform.exit();
        });
    }

    public void cancelar() {
        btnCancelar.setOnAction(t -> {
            Platform.exit();
        });
    }

}
