/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p;

import Modelo.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    @FXML
    private Button btnConsultar;
    @FXML
    private VBox vbResultados;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarEquipos();
        buscarPartido();
    }

    public void llenarFases() {
        cbFase.getItems().addAll("Group", "Round of 16", "Quarter-finals", "Semi-finals", "Final");
    }

    public void llenarGrupos() {
        cbGrupo.getItems().addAll("A", "B", "C", "D", "E", "F", "G", "H");
    }

    public ArrayList<Jugador> crearJugadores() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        ArrayList<String> listaJugadores = ManejoArchivos.LeeFichero("WorldCupPlayersBrasil2014.csv");
        listaJugadores.forEach(linea -> {
            jugadores.add(new Jugador(linea.split(",")[0].trim(),
                    linea.split(",")[1].trim(), linea.split(",")[2].trim(),
                    linea.split(",")[3].trim(), linea.split(",")[4].trim(),
                    linea.split(",")[5].trim(), linea.split(",")[6].trim()));
        });
        return jugadores;
    }

    public ArrayList<Partido> crearPartidos() {
        ArrayList<Partido> partidos = new ArrayList<>();
        ArrayList<String> listaPartidos = ManejoArchivos.LeeFichero("WorldCupMatchesBrasil2014.csv");
        listaPartidos.forEach(linea -> {
            partidos.add(new Partido(linea.split(",")[0].trim(),
                    linea.split(",")[1].trim(), linea.split(",")[2].trim(),
                    linea.split(",")[3].trim(), linea.split(",")[4].trim(),
                    linea.split(",")[5].trim(), linea.split(",")[6].trim(),
                    linea.split(",")[7].trim(), linea.split(",")[8].trim(),
                    linea.split(",")[9].trim(), linea.split(",")[10].trim(),
                    linea.split(",")[11].trim(), linea.split(",")[12].trim(),
                    linea.split(",")[13].trim(), linea.split(",")[14].trim(),
                    linea.split(",")[15].trim(), linea.split(",")[16].trim(),
                    linea.split(",")[17].trim(), linea.split(",")[18].trim(),
                    linea.split(",")[19].trim()));
        });
        return partidos;
    }

    public void llenarEquipos() {
        llenarFases();
        cbFase.setOnAction(t -> {
            cbGrupo.getItems().clear();
            cbEquipo1.getItems().clear();
            cbEquipo2.getItems().clear();
            vbResultados.getChildren().clear();
            String faseSelecc = cbFase.getValue();
            if (faseSelecc.equals("Group")) {
                llenarGrupos();
                cbGrupo.setOnAction(e -> {
                    ArrayList<String> equiposLocal = new ArrayList<>();
                    cbEquipo1.getItems().clear();
                    cbEquipo2.getItems().clear();
                    vbResultados.getChildren().clear();
                    String grupoSelecc = cbGrupo.getValue();
                    for (Partido p : crearPartidos()) {
                        if (p.getGrupo().split(" ")[0].equals("Group")) {
                            if (p.getGrupo().split(" ")[1].equals(grupoSelecc)) {
                                if (!equiposLocal.contains(p.getLocal())) {
                                    equiposLocal.add(p.getLocal());
                                }
                            }
                        }
                    }
                    cbEquipo1.getItems().addAll(equiposLocal);
                    cbEquipo1.setOnAction(f -> {
                        ArrayList<String> equiposVisita = new ArrayList<>();
                        cbEquipo2.getItems().clear();
                        vbResultados.getChildren().clear();
                        String equipoSelecc = cbEquipo1.getValue();
                        for (Partido p : crearPartidos()) {
                            if (p.getGrupo().split(" ")[0].equals("Group")) {
                                if (p.getGrupo().split(" ")[1].equals(grupoSelecc)) {
                                    if (!equiposVisita.contains(p.getVisitante())) {
                                        if (!p.getVisitante().equals(equipoSelecc)) {
                                            equiposVisita.add(p.getVisitante());
                                        }
                                    }
                                }
                            }
                        }
                        cbEquipo2.setOnAction(h -> {
                            vbResultados.getChildren().clear();
                        });
                        cbEquipo2.getItems().addAll(equiposVisita);
                    });
                });
            } else if (!faseSelecc.equals("Group")) {
                ArrayList<String> equiposLocal = new ArrayList<>();
                cbEquipo1.getItems().clear();
                cbEquipo2.getItems().clear();
                vbResultados.getChildren().clear();
                for (Partido p : crearPartidos()) {
                    if (p.getGrupo().equals(faseSelecc)) {
                        if (!equiposLocal.contains(p.getLocal())) {
                            equiposLocal.add(p.getLocal());
                        }
                    }
                }
                cbEquipo1.getItems().addAll(equiposLocal);
                cbEquipo1.setOnAction(g -> {
                    ArrayList<String> equiposVisita = new ArrayList<>();
                    cbEquipo2.getItems().clear();
                    vbResultados.getChildren().clear();
                    String equipoSelecc = cbEquipo1.getValue();
                    for (Partido p : crearPartidos()) {
                        if (p.getGrupo().equals(faseSelecc)) {
                            if (!equiposVisita.contains(p.getVisitante())) {
                                if (!p.getVisitante().equals(equipoSelecc)) {
                                    equiposVisita.add(p.getVisitante());
                                }
                            }
                        }
                    }
                    cbEquipo2.setOnAction(h -> {
                        vbResultados.getChildren().clear();
                    });
                    cbEquipo2.getItems().addAll(equiposVisita);
                });
            }
        });
    }

    public void camposVacios() {
        Alert info = new Alert(Alert.AlertType.ERROR);
        info.setTitle("CAMPOS IMCOMPLETOS");
        info.setHeaderText("Faltan campos por escoger.");
        info.setContentText("Vuelva a intentar.");
        info.showAndWait();
    }

    public void partidoNoEncontrado() {
        Alert info = new Alert(Alert.AlertType.ERROR);
        info.setTitle("PARTIDO NO ENCONTRADO");
        info.setHeaderText("No se encontro el partido.");
        info.setContentText("Vuelva a intentar.");
        info.showAndWait();
    }

    public void buscarPartido() {
        btnConsultar.setOnAction(t -> {
            vbResultados.getChildren().clear();
            if (cbFase.getValue() == null || cbEquipo1.getValue() == null || cbEquipo2.getValue() == null) {
                camposVacios();
            } else {
                Partido partidoSelecc = null;
                for (int p = 0; p < crearPartidos().size(); p++) {
                    if (crearPartidos().get(p).getLocal().equals(cbEquipo1.getValue()) && crearPartidos().get(p).getVisitante().equals(cbEquipo2.getValue())) {
                        partidoSelecc = crearPartidos().get(p);
                    }
                }
                if (partidoSelecc != null) {
                    VBox vbBotones = new VBox();
                    Button btnExportarResultados = new Button("EXPORTAR RESULTADOS DE GRUPO");
                    Button btnDetalleEquipos = new Button("VER DETALLE DE EQUIPOS");
                    btnExportarResultados.setStyle("-fx-background-color:blue;");
                    btnDetalleEquipos.setStyle("-fx-background-color:blue;");
                    btnExportarResultados.setTextFill(Color.WHITE);
                    btnDetalleEquipos.setTextFill(Color.WHITE);
                    vbBotones.setSpacing(10);
                    vbBotones.setAlignment(Pos.CENTER);
                    vbBotones.setPrefHeight(200);
                    vbBotones.getChildren().addAll(btnExportarResultados, btnDetalleEquipos);
                    HBox hbMostranDatos = new HBox();
                    VBox vbDatosPartido = new VBox();
                    Label lbResultado = new Label("Resultado del partido");
                    lbResultado.setFont(new Font(14));
                    vbDatosPartido.setPrefWidth(125);
                    hbMostranDatos.setSpacing(20);
                    hbMostranDatos.setAlignment(Pos.CENTER);
                    vbResultados.setAlignment(Pos.TOP_CENTER);
                    vbDatosPartido.getChildren().addAll(
                            new Label(partidoSelecc.getDateTime()),
                            new Label(partidoSelecc.getGrupo()),
                            new Label(partidoSelecc.getEstadio()),
                            new Label(partidoSelecc.getCiudad()));
                    hbMostranDatos.getChildren().addAll(vbDatosPartido, equipoPartido(partidoSelecc.getLocal()), puntuacionPartido(partidoSelecc), equipoPartido(partidoSelecc.getVisitante()));
                    vbResultados.getChildren().addAll(lbResultado, hbMostranDatos, vbBotones);
                    exportarGrupo(btnExportarResultados);
                } else {
                    partidoNoEncontrado();
                }
            }
        });
    }

    public HBox equipoPartido(String equipo) {
        HBox hbEquipo = new HBox();
        Label lbEquipo = new Label(equipo.toUpperCase());
        lbEquipo.setFont(new Font(18));
        ImageView ivBandera = null;
        try (FileInputStream input = new FileInputStream(App.pathImg + equipo + ".jpg")) {
            Image imagen = new Image(input);
            ivBandera = new ImageView(imagen);
            ivBandera.setFitWidth(30);
            ivBandera.setPreserveRatio(true);
        } catch (FileNotFoundException e) {
            System.out.println("Imagen no encontrada.");
        } catch (IOException e) {
            System.out.println("Error. Vuelva a intentar.");
        }
        hbEquipo.getChildren().addAll(ivBandera, lbEquipo);
        hbEquipo.setSpacing(10);
        hbEquipo.setPrefWidth(125);
        hbEquipo.setAlignment(Pos.CENTER);
        return hbEquipo;
    }

    public VBox puntuacionPartido(Partido p) {
        VBox vbR = new VBox();
        vbR.setAlignment(Pos.CENTER);
        Label lbFinal = new Label("FINAL DEL PARTIDO");
        Label lbResultado = new Label(p.getGolesLocalTotal() + "-" + p.getGolesVisitaTotal());
        lbResultado.setTextFill(Color.BLUE);
        vbR.getChildren().addAll(lbFinal, lbResultado);
        vbR.setPrefWidth(125);
        return vbR;
    }

    public void exportarGrupo(Button b) {
        b.setOnAction(p -> {
            try {
                FXMLLoader fxmLoader = new FXMLLoader(App.class.getResource("/fxml/ExportarGrupo.fxml"));
                Parent root2 = fxmLoader.load();
                Scene scene = new Scene(root2);
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
