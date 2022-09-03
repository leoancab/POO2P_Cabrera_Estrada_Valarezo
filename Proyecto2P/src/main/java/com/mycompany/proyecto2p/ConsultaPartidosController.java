/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p;

import Modelo.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    public ComboBox<String> cbEquipo1;
    @FXML
    public ComboBox<String> cbEquipo2;
    @FXML
    private Button btnConsultar;
    @FXML
    private VBox vbResultados;

    public static Partido partidoSelecc;

    public static ArrayList<Jugador> jugadoresPartido = new ArrayList<>();
    public static ArrayList<Partido> partidos = new ArrayList<>();
    // Lo hice estatico para poder llamarlo en Detalle Equipo

    public String getCbEquipo1() {
        String nombre = cbEquipo1.getValue();
        return nombre;
    }

    public String getCbEquipo2() {
        return cbEquipo2.getValue();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearPartidos(partidos);
        llenarEquipos();
        buscarPartido();
    }
  /**
     * Este método se encarga de llenar el comboBox de fases para ordenar los
     * equipos.
     *
     *
     */
    public void llenarFases() {
        cbFase.getItems().addAll("Group", "Round of 16", "Quarter-finals", "Semi-finals", "Final");
    }
 /**
     * Este método se encarga de llenar el comboBox de grupos para proximamente
     * ordenar los equipos
     *
     */
    public void llenarGrupos() {
        cbGrupo.getItems().addAll("A", "B", "C", "D", "E", "F", "G", "H");
    }

    /**
     * Este método se encarga de crear los objetos Jugador en base a la lectura
     * del archivo "WorldCupPlayersBrasil2014.csv" y retorna una lista con
     * estos.
     *
     * @return ArrayList
     */
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
 /**
     * Este método se encarga de crear los objetos Partido en base a la lectura
     * del archivo "WorldCupPlayersBrasil2014.csv" y retorna una lista con
     * estos.
     *
     * @return ArrayList
     */
    public ArrayList<Partido> crearPartidos(ArrayList<Partido> p) {
        ArrayList<String> listaPartidos = ManejoArchivos.LeeFichero("WorldCupMatchesBrasil2014.csv");
        listaPartidos.forEach(linea -> {
            p.add(new Partido(linea.split(",")[0].trim(),
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
        return p;
    }
   /**
     * Este método se encarga de cargar los comboBox de los equipos, verificando
     * si los valores de los demas comboBox coinciden, separando entre equipos.
     *
     */
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
                    for (Partido p : partidos) {
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
                        for (Partido p : partidos) {
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
                cbGrupo.setValue("");
                ArrayList<String> equiposLocal = new ArrayList<>();
                cbEquipo1.getItems().clear();
                cbEquipo2.getItems().clear();
                vbResultados.getChildren().clear();
                for (Partido p : partidos) {
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
                    for (Partido p : partidos) {
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
/**
     * Este método se encarga de lanzar una alerta de tipo ERROR si alguno de
     * los comboBox necesarios no han sido seleccionados.
     *
     */
    public void camposVacios() {
        Alert info = new Alert(Alert.AlertType.ERROR);
        info.setTitle("CAMPOS IMCOMPLETOS");
        info.setHeaderText("Faltan campos por escoger.");
        info.setContentText("Vuelva a intentar.");
        info.showAndWait();
    }

    /**
     * Este método se encarga de lanzar una alerta de tipo ERROR si los equipos
     * seleccionados no han tenido un partido.
     *
     */
    public void partidoNoEncontrado() {
        Alert info = new Alert(Alert.AlertType.ERROR);
        info.setTitle("PARTIDO NO ENCONTRADO");
        info.setHeaderText("No se encontro el partido.");
        info.setContentText("Vuelva a intentar.");
        info.showAndWait();
    }
/**
     * Este método se encarga de recorrer la lista de partidos, verificando si
     * alguno de estos partidos cumple las caracteristicas seleccionadas por el
     * usuario, como fase; grupo y equipos, una vez que lo encuentra se encarga
     * de buscar su puntaje, ordenarlo alfabeticamente y los carga a la escena
     * correspondiente.
     *
     */
    public void buscarPartido() {
        btnConsultar.setOnAction(t -> {
            vbResultados.getChildren().clear();
            if (cbFase.getValue() == null || cbEquipo1.getValue() == null || cbEquipo2.getValue() == null) {
                camposVacios();
            } else {
                partidoSelecc = null;
                for (int p = 0; p < partidos.size(); p++) {
                    if (partidos.get(p).getLocal().equals(cbEquipo1.getValue()) && partidos.get(p).getVisitante().equals(cbEquipo2.getValue()) && partidos.get(p).getGrupo().equals((cbFase.getValue() + " " + cbGrupo.getValue()).trim())) {
                        partidoSelecc = partidos.get(p);
                    }
                }
                if (partidoSelecc != null) {
                    VBox vbBotones = new VBox();
                    Button btnExportarResultados = new Button("EXPORTAR RESULTADOS DE GRUPO");
                    Button btnDetalleEquipos = new Button("VER DETALLE DE EQUIPOS");
                    //IMPORTANTE
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
                    if (partidoSelecc.compareTo(partidoSelecc) == -1) {
                        VBox vbR = new VBox();
                        vbR.setAlignment(Pos.CENTER);
                        Label lbFinal = new Label("FINAL DEL PARTIDO");
                        Label lbResultado2 = new Label(partidoSelecc.getGolesLocalTotal() + "-" + partidoSelecc.getGolesVisitaTotal());
                        lbResultado2.setTextFill(Color.BLUE);
                        vbR.getChildren().addAll(lbFinal, lbResultado2);
                        vbR.setPrefWidth(125);
                        hbMostranDatos.getChildren().addAll(vbDatosPartido, equipoPartido(partidoSelecc.getLocal()), vbR, equipoPartido(partidoSelecc.getVisitante()));
                    } else if (partidoSelecc.compareTo(partidoSelecc) == 1) {
                        VBox vbR = new VBox();
                        vbR.setAlignment(Pos.CENTER);
                        Label lbFinal = new Label("FINAL DEL PARTIDO");
                        Label lbResultado2 = new Label(partidoSelecc.getGolesVisitaTotal() + "-" + partidoSelecc.getGolesLocalTotal());
                        lbResultado2.setTextFill(Color.BLUE);
                        vbR.getChildren().addAll(lbFinal, lbResultado2);
                        vbR.setPrefWidth(125);
                        hbMostranDatos.getChildren().addAll(vbDatosPartido, equipoPartido(partidoSelecc.getVisitante()), vbR, equipoPartido(partidoSelecc.getLocal()));
                    } else if (partidoSelecc.compareTo(partidoSelecc) == 0) {
                        VBox vbR = new VBox();
                        vbR.setAlignment(Pos.CENTER);
                        Label lbFinal = new Label("FINAL DEL PARTIDO");
                        Label lbResultado2 = new Label(partidoSelecc.getGolesLocalTotal() + "-" + partidoSelecc.getGolesVisitaTotal());
                        lbResultado2.setTextFill(Color.BLUE);
                        vbR.getChildren().addAll(lbFinal, lbResultado2);
                        vbR.setPrefWidth(125);
                        hbMostranDatos.getChildren().addAll(vbDatosPartido, equipoPartido(partidoSelecc.getLocal()), vbR, equipoPartido(partidoSelecc.getVisitante()));
                    }
                    vbResultados.getChildren().addAll(lbResultado, hbMostranDatos, vbBotones);
                    confirmacion(btnExportarResultados);
                    detalleEquipos(btnDetalleEquipos);
                } else {
                    partidoNoEncontrado();
                }
            }
        });
    }
/**
     * Este método se encarga de crear un HBox que incluye todos los datos del
     * equipo. Como bandera y nombre.
     *
     * @return HBox
     */
    public HBox equipoPartido(String equipo) {
        HBox hbEquipo = new HBox();
        Label lbEquipo = new Label(equipo.toUpperCase());
        lbEquipo.setFont(new Font(18));
        try {
            ImageView ivBandera = null;
            try (FileInputStream input = new FileInputStream(App.pathImg + equipo + ".jpg")) {
                Image imagen = new Image(input);
                ivBandera = new ImageView(imagen);
                ivBandera.setFitWidth(30);
                ivBandera.setPreserveRatio(true);
                hbEquipo.getChildren().add(ivBandera);
            } catch (FileNotFoundException e) {
                System.out.println("Imagen no encontrada.");
            } catch (IOException e) {
                System.out.println("Error. Vuelva a intentar.");
            }
        } catch (NullPointerException e3) {
            System.out.println("Imagen no encontrada.");
        }
        hbEquipo.setSpacing(10);
        hbEquipo.setPrefWidth(125);
        hbEquipo.setAlignment(Pos.CENTER);
        hbEquipo.getChildren().add(lbEquipo);
        return hbEquipo;
    }
 /**
     * Este método se encarga de lanzar una alerta de tipo CONFIRMATION para
     * confirmar la exportacion del archivo serializado del equipo.
     *
     * @param b Boton para la confirmacion de la serializacion.
     */
    public void confirmacion(Button b) {
        b.setOnAction(c -> {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("CONFIRMACION");
            alerta.setHeaderText("Esta seguro de que desea exportar el grupo de jugadores?");
            alerta.showAndWait();
            if (alerta.getResult().getText().equals("Aceptar")) {
                obtenerJugadoresPartido();
                serializarJugadores();
            } else {
                alerta.close();
            }
        });
    }
/**
     * Este método se encarga de añadir todos los jugadores, que participaron en
     * el partido seleccionado, a una lista estatica para poder hacer uso de la
     * misma en otros metodos.
     *
     */
    public void obtenerJugadoresPartido() {
        if (cbFase.getValue().equals("Group")) {
            String grupoSelecc = cbGrupo.getValue();
            for (Jugador j : crearJugadores()) {
                for (Partido p : partidos) {
                    if (p.getGrupo().equals(cbFase + " " + grupoSelecc)) {
                        if (p.getLocal().equals(cbEquipo1.getValue()) && p.getVisitante().equals(cbEquipo2.getValue())) {
                            if (p.getMatchID().equals(j.getMatchID())) {
                                if (!jugadoresPartido.contains(j)) {
                                    jugadoresPartido.add(j);
                                }
                            }
                        }
                    }
                }
            }
        } else if (!cbFase.getValue().equals("Group")) {
            for (Jugador j : crearJugadores()) {
                for (Partido p : partidos) {
                    if (p.getGrupo().equals(cbFase.getValue())) {
                        if (p.getLocal().equals(cbEquipo1.getValue()) && p.getVisitante().equals(cbEquipo2.getValue())) {
                            if (p.getMatchID().equals(j.getMatchID())) {
                                if (!jugadoresPartido.contains(j)) {
                                    jugadoresPartido.add(j);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
/**
     * Este método se encarga de serializar los jugadores, es decir crear un
     * archivo que contiene esa lista para poder ser deserializado en otro
     * metodo.
     *
     */
    public void serializarJugadores() {
        try (ObjectOutputStream obOut = new ObjectOutputStream(new FileOutputStream(App.pathFiles + "listaJugadoresSerializada.bin"))) {
            obOut.writeObject(jugadoresPartido);
            System.out.println("Lista serializada");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: No se pudo serializar.");
        }
    }
/**
     * Este método se encarga de crear y cargar un nuevo Stage para mostrar los
     * detalles de cada equipo participante en un partido.
     *
     * @param btn Boton encargado de lanzar el nuevo Stage.
     */
    @FXML
    public void detalleEquipos(Button btn) {
        btn.setOnAction(e -> {
            jugadoresPartido.clear();
            obtenerJugadoresPartido();
            FXMLLoader fxmLoader = new FXMLLoader(App.class.getResource("/fxml/DetalleEquipos.fxml"));
            Parent root2;
            try {
                root2 = fxmLoader.load();
                Scene scene = new Scene(root2);
                Stage stage = new Stage();
                stage.setTitle("DETALLE DE EQUIPOS");
                stage.setScene(scene);
                stage.show();
                Stage stage2 = (Stage) btn.getScene().getWindow();
                stage2.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

    }
}
