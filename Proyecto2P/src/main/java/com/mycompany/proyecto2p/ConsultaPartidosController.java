/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p;

import Modelo.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
        cbFase.setOnAction((ActionEvent t) -> {
            llenarGrupos(t);
        });
        System.out.println(ManejoArchivos.LeeFichero("WorldCupMatchesBrasil2014.csv").get(0).split("|")[0]);
        }

    public void llenarFases() {
        cbFase.getItems().addAll("Group", "Round of 16", "Quarter-finals", "Semi-finals", "Final");
    }

    public void llenarGrupos(ActionEvent t) {
        String fase = cbFase.getSelectionModel().getSelectedItem();
        if (fase.equals("Group")) {
            cbGrupo.getItems().addAll("A", "B", "C", "D", "E", "F", "G", "H");
        }
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
            partidos.add(new Partido(Integer.parseInt(linea.split("|")[0].trim()),
                    linea.split("|")[1].trim(), linea.split("|")[2].trim(), linea.split("|")[3].trim(),
                    linea.split("|")[4].trim(), linea.split("|")[5].trim(),
                    Integer.parseInt(linea.split("|")[6].trim()),
                    Integer.parseInt(linea.split("|")[7].trim()),
                    linea.split("|")[8].trim(),
                    linea.split("|")[9].trim(), Integer.parseInt(linea.split("|")[10].trim()),
                    Integer.parseInt(linea.split("|")[11].trim()),
                    Integer.parseInt(linea.split("|")[12].trim()), linea.split("|")[13].trim(),
                    linea.split("|")[14].trim(), linea.split("|")[15].trim(),
                    Integer.parseInt(linea.split("|")[16].trim()),
                    Integer.parseInt(linea.split("|")[17].trim()),
                    linea.split("|")[18].trim(), linea.split("|")[19].trim()));
        });
        return partidos;
    }

    public ArrayList<String> equipos1(ArrayList<Partido> partidos) {
        ArrayList<String> listaEquipo1 = new ArrayList<>();
        partidos.forEach(p -> {
            if (!listaEquipo1.contains(p.getLocal())) {
                listaEquipo1.add(p.getLocal());
            }
        });
        return listaEquipo1;
    }
}
