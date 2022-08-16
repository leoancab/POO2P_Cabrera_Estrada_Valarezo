/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p;

import Modelo.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML
    private Button btnConsultar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarFases();
        cbFase.setOnAction(t -> {
            cbGrupo.getItems().clear();
            cbEquipo1.getItems().clear();
            cbEquipo2.getItems().clear();
            String faseSelecc = cbFase.getValue();
            if (faseSelecc.equals("Group")) {
                llenarGrupos();
                cbGrupo.setOnAction(e -> {
                    ArrayList<String> equiposLocal = new ArrayList<>();
                    cbEquipo1.getItems().clear();
                    cbEquipo2.getItems().clear();
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
                        cbEquipo2.getItems().addAll(equiposVisita);
                    });
                });
            } else if (!faseSelecc.equals("Group")) {
                ArrayList<String> equiposLocal = new ArrayList<>();
                cbEquipo1.getItems().clear();
                cbEquipo2.getItems().clear();
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
                    cbEquipo2.getItems().addAll(equiposVisita);
                });
            }
        });
        btnConsultar.setOnAction(t -> {
        });
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
            jugadores.add(new Jugador(Integer.parseInt(linea.split(",")[0].trim()),
                    Integer.parseInt(linea.split(",")[1].trim()), linea.split(",")[2].trim(),
                    linea.split(",")[3].trim(), linea.split(",")[4].trim(),
                    Integer.parseInt(linea.split(",")[5].trim()), linea.split(",")[6].trim(),
                    linea.split(",")[7].trim(), linea.split(",")[8].trim()));
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
}
