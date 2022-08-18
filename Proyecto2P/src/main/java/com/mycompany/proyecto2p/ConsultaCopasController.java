/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p;

import Modelo.Copa;
import Modelo.ManejoArchivos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author leoan
 */
public class ConsultaCopasController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private HBox hbTitulo;
    @FXML
    private HBox hbConsultar;
    @FXML
    private Label lbTitulo;
    @FXML
    private Label lbYear;
    @FXML
    private TextField tfYear;
    @FXML
    private Button btnConsultar;
    @FXML
    private HBox hbDatos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hbTitulo = new HBox();
        lbTitulo = new Label("Consulta Historica de Copas Mundiales");
        hbConsultar = new HBox();
        lbYear = new Label("Año:");
        tfYear = new TextField();
        btnConsultar = new Button("CONSULTAR");
        //hbDatos = new HBox();

        hbTitulo.getChildren().add(lbTitulo);
        lbTitulo.setFont(new Font(24));
        hbTitulo.setPrefHeight(50);
        hbTitulo.setAlignment(Pos.CENTER);

        btnConsultar.setStyle("-fx-background-color:blue;");
        btnConsultar.setTextFill(Color.WHITE);

        hbConsultar.getChildren().addAll(lbYear, tfYear, btnConsultar);
        hbConsultar.setAlignment(Pos.CENTER);
        hbConsultar.setSpacing(20);
        hbConsultar.setPrefHeight(50);

        hbDatos = new HBox();
        hbDatos.setPrefHeight(300);

        root.getChildren().addAll(hbTitulo, hbConsultar, hbDatos);
        btnConsultar.setOnAction((ActionEvent t) -> {
            obtenerMundial(t);
        });
    }

    public ArrayList<Copa> crearCopas() {
        ArrayList<Copa> mundiales = new ArrayList<>();
        ArrayList<String> copas = ManejoArchivos.LeeFichero("WorldCups.csv");
        copas.forEach(linea -> {
            mundiales.add(new Copa(linea.split(",")[0], linea.split(",")[1],
                    linea.split(",")[2], linea.split(",")[3], linea.split(",")[4],
                    linea.split(",")[5], Integer.parseInt(linea.split(",")[6]),
                    Integer.parseInt(linea.split(",")[7]),
                    Integer.parseInt(linea.split(",")[8]), linea.split(",")[9]));
        });
        return mundiales;
    }

    public void obtenerMundial(ActionEvent t) {
        hbDatos.getChildren().clear();
        if (!listaAños().contains(tfYear.getText())) {
            añoIncorrecto();
        }
        crearCopas().forEach(c -> {
            if (tfYear.getText().equals(c.getYear())) {
                Label lbGanador = new Label(c.getGanador());
                Label lbSegundo = new Label(c.getSegundo());
                Label lbTercero = new Label(c.getTercero());
                Label lbCuarto = new Label(c.getCuarto());
                Label lbGoles = new Label(String.valueOf(c.getGolesAnotados()));
                Label lbEquipos = new Label(String.valueOf(c.getEquiposCalificados()));
                Label lbPartidos = new Label(String.valueOf(c.getPartidosJugados()));
                Label lbAsistencia = new Label(c.getAsistencia());

                VBox vbPremios = new VBox();
                VBox vbDatos = new VBox();

                Label lbPremio = new Label("Premios");
                lbPremio.setFont(new Font(20));
                lbPremio.setPrefHeight(20);

                HBox hbPosicion = new HBox();

                Label lbDatos = new Label("Datos Generales");
                lbDatos.setFont(new Font(20));
                vbDatos.getChildren().addAll(lbDatos,
                        new Label("Goles anotados: " + lbGoles.getText()),
                        new Label("Equipos: " + lbEquipos.getText()),
                        new Label("Partidos jugados: " + lbPartidos.getText()),
                        new Label("Asistencia: " + lbAsistencia.getText()));
                vbDatos.setPrefWidth(200);
                vbDatos.setSpacing(10);

                VBox vbPosiciones = new VBox();
                VBox vbPaises = new VBox();
                VBox vbCopas = new VBox();
                vbPosiciones.setPrefWidth(100);
                vbPaises.setPrefWidth(100);
                vbCopas.setPrefWidth(200);
                vbPosiciones.setSpacing(10);
                vbPaises.setSpacing(10);
                vbCopas.setSpacing(10);
                vbPosiciones.getChildren().addAll(new Label("Ganador"), new Label("Segundo"), new Label("Tercero"), new Label("Cuarto"));

                obtenerBandera(lbGanador, vbPaises);
                obtenerBandera(lbSegundo, vbPaises);
                obtenerBandera(lbTercero, vbPaises);
                obtenerBandera(lbCuarto, vbPaises);

                hbPosicion.getChildren().addAll(vbPosiciones, vbPaises, vbCopas);
                vbPremios.getChildren().addAll(lbPremio, hbPosicion);

                imagenesCopa(obtenerCantidadCopas(lbGanador.getText()), vbCopas);
                imagenesCopa(obtenerCantidadCopas(lbSegundo.getText()), vbCopas);
                imagenesCopa(obtenerCantidadCopas(lbTercero.getText()), vbCopas);
                imagenesCopa(obtenerCantidadCopas(lbCuarto.getText()), vbCopas);

                hbDatos.getChildren().addAll(vbPremios, vbDatos);
            }
        });
        tfYear.clear();

    }

    public ArrayList<String> listaAños() {
        ArrayList<String> years = new ArrayList<>();
        crearCopas().forEach(c -> {
            if (!years.contains(c.getYear())) {
                years.add(c.getYear());
            }
        });
        return years;
    }

    public int obtenerCantidadCopas(String equipo) {
        int copas = 0;
        for (Copa g : crearCopas()) {
            if (g.getGanador().equals(equipo)) {
                copas++;
            }
        }
        return copas;
    }

    public void imagenesCopa(int cantidadCopas, VBox vbCopas) {
        HBox hbCopas = new HBox();
        hbCopas.setPrefHeight(20);
        for (int i = 0; i < cantidadCopas; i++) {
            ImageView ivCopas = null;
            try (FileInputStream input = new FileInputStream(App.pathImg + "copaMundial.jpg")) {
                Image imagen = new Image(input);
                ivCopas = new ImageView(imagen);
                ivCopas.setFitWidth(20);
                ivCopas.setFitHeight(20);
                hbCopas.getChildren().add(ivCopas);
            } catch (FileNotFoundException e) {
                System.out.println("Imagen no encontrada.");
            } catch (IOException e) {
                System.out.println("Error. Vuelva a intentar.");
            }
        }
        vbCopas.getChildren().add(hbCopas);
    }

    public void añoIncorrecto() {
        Alert info = new Alert(Alert.AlertType.ERROR);
        info.setTitle("AÑO INCORRECTO");
        info.setHeaderText("Año no encontrado.");
        info.setContentText("Vuelva a intentar.");
        info.showAndWait();
    }

    public void obtenerBandera(Label equipo, VBox vbPaises) {
        HBox hbBandera = new HBox();
        hbBandera.setSpacing(5);
        ImageView ivBandera = null;
        try (FileInputStream input = new FileInputStream(App.pathImg + equipo.getText() + ".jpg")) {
            ivBandera = new ImageView();
            Image imBandera = new Image(input);
            ivBandera.setImage(imBandera);
            ivBandera.setFitWidth(20);
            ivBandera.setPreserveRatio(true);
            hbBandera.getChildren().add(ivBandera);
        } catch (FileNotFoundException e) {
            System.out.println("Imagen no encontrada.");
        } catch (IOException e) {
            System.out.println("Error. Vuelva a intentar.");
        }
        hbBandera.getChildren().add(equipo);
        vbPaises.getChildren().add(hbBandera);
    }
}
