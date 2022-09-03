package com.mycompany.proyecto2p;

import Modelo.Jugador;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DetalleEquiposController implements Initializable {

    @FXML
    private ImageView I1;

    @FXML
    private ImageView I2;

    @FXML
    private ImageView I3;

    @FXML
    private ImageView I4;

    @FXML
    private ImageView I5;

    @FXML
    private ImageView I6;

    @FXML
    private ImageView I7;

    @FXML
    private ImageView I8;

    @FXML
    private ImageView I9;

    @FXML
    private ImageView I10;

    @FXML
    private ImageView I11;

    @FXML
    private ImageView I12;

    @FXML
    private ImageView I13;

    @FXML
    private ImageView I14;

    @FXML
    private ImageView I15;

    @FXML
    private ImageView I16;

    @FXML
    private ImageView I17;

    @FXML
    private ImageView I18;

    @FXML
    private ImageView I19;

    @FXML
    private ImageView I20;

    @FXML
    private ImageView I21;

    @FXML
    private ImageView I22;

    @FXML
    private ImageView I23;

    @FXML
    private ImageView I24;

    @FXML
    private ImageView I25;

    @FXML
    private ImageView I26;

    @FXML
    private ImageView I27;

    @FXML
    private ImageView I28;

    @FXML
    private ImageView I29;

    @FXML
    private ImageView I30;

    @FXML
    private ImageView I31;

    @FXML
    private ImageView I32;

    @FXML
    private ImageView I33;

    @FXML
    private ImageView I34;

    @FXML
    private ImageView I35;

    @FXML
    private ImageView I36;

    @FXML
    private ImageView I37;

    @FXML
    private ImageView I38;

    @FXML
    private ImageView I39;

    @FXML
    private ImageView I40;

    @FXML
    private ImageView I41;

    @FXML
    private ImageView I42;

    @FXML
    private ImageView I43;

    @FXML
    private ImageView I44;

    @FXML
    private ImageView I45;

    @FXML
    private ImageView I46;

    @FXML
    private Label J1;

    @FXML
    private Label J2;

    @FXML
    private Label J3;

    @FXML
    private Label J4;

    @FXML
    private Label J5;

    @FXML
    private Label J6;

    @FXML
    private Label J7;

    @FXML
    private Label J8;

    @FXML
    private Label J9;

    @FXML
    private Label J10;

    @FXML
    private Label J11;

    @FXML
    private Label J12;

    @FXML
    private Label J13;

    @FXML
    private Label J14;

    @FXML
    private Label J15;

    @FXML
    private Label J16;

    @FXML
    private Label J17;

    @FXML
    private Label J18;

    @FXML
    private Label J19;

    @FXML
    private Label J20;

    @FXML
    private Label J21;

    @FXML
    private Label J22;

    @FXML
    private Label J23;

    @FXML
    private Label J24;

    @FXML
    private Label J25;

    @FXML
    private Label J26;

    @FXML
    private Label J27;

    @FXML
    private Label J28;

    @FXML
    private Label J29;

    @FXML
    private Label J30;

    @FXML
    private Label J31;

    @FXML
    private Label J32;

    @FXML
    private Label J33;

    @FXML
    private Label J34;

    @FXML
    private Label J35;

    @FXML
    private Label J36;

    @FXML
    private Label J37;

    @FXML
    private Label J38;

    @FXML
    private Label J39;

    @FXML
    private Label J40;

    @FXML
    private Label J41;

    @FXML
    private Label J42;

    @FXML
    private Label J43;

    @FXML
    private Label J44;

    @FXML
    private Label J45;

    @FXML
    private Label J46;

    @FXML
    private Label equipo1;

    @FXML
    private Label equipo2;

    @FXML
    private HBox hbequipo1;

    @FXML
    private HBox hbequipo2;

    @FXML
    private VBox root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Jugador> listequipo1 = new ArrayList();
        ArrayList<Jugador> listequipo2 = new ArrayList();
        equipo1.setText(ConsultaPartidosController.partidoSelecc.getLocal());
        equipo2.setText(ConsultaPartidosController.partidoSelecc.getVisitante());

        ObservableList<Node> childrens1 = hbequipo1.getChildren();
        ObservableList<Node> childrens2 = hbequipo2.getChildren();

        for (int i = 0; i < childrens1.size(); i++) {
            if (ConsultaPartidosController.partidoSelecc.getInicialLocal().equals(ConsultaPartidosController.jugadoresPartido.get(i).getInicialesEquipo())) {
                listequipo1.add(ConsultaPartidosController.jugadoresPartido.get(i));
            } else {
                listequipo2.add(ConsultaPartidosController.jugadoresPartido.get(i));
            }
        }

        for (int i = 0; i < listequipo1.size(); i++) {
            final int c = i;
            modificarVBox((VBox) childrens1.get(i), listequipo1.get(i), generadorAleatorio());
            childrens1.get(i).addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
                int indice = childrens1.indexOf(childrens1.get(c));
                mostrarJugador(listequipo1.get(indice));
            });
        }

        for (int i = 0; i < listequipo2.size(); i++) {
            final int c = i;
            modificarVBox((VBox) childrens2.get(i), listequipo2.get(i), generadorAleatorio());
            childrens2.get(i).addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
                int indice = childrens2.indexOf(childrens2.get(c));
                mostrarJugador(listequipo2.get(indice));
            });
        }
    }

    public int generadorAleatorio() {
        int numAle = (int) Math.floor(Math.random() * (15 - 5 + 1) + 5); //Numero aleatorio entre 5 y 15
        return numAle;
    }

    public void modificarVBox(VBox v, Jugador jb, int num) {
        v.getChildren().clear();
        Label lb = new Label();
        lb.setText(jb.getNombre());
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * num);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                try (FileInputStream input = new FileInputStream(App.pathImg + "/JUGADORES/" + jb.getNombre() + ".jpg")) {
                    ImageView img = new ImageView();
                    Image imagen = new Image(input);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            img.setImage(imagen);
                            img.setFitWidth(100);
                            img.setPreserveRatio(true);
                            v.getChildren().add(img);
                            v.getChildren().add(lb);
                        }
                    });
                } catch (FileNotFoundException e) {
                    System.out.println("Imagen de jugador no encontrada.");
                } catch (IOException e2) {
                    System.out.println("Error, vuelva a intentar.");
                }
            }
        });
        t1.start();
    }

    public void mostrarJugador(Jugador jb1) {
        VBox vb1 = new VBox();
        vb1.setAlignment(Pos.CENTER);
        vb1.setSpacing(10);

        Label lb1 = new Label();
        lb1.setFont(new Font(22));
        lb1.setText(jb1.getNombre());
        vb1.getChildren().add(lb1);
        Label lbcontador = new Label();

        try (FileInputStream input = new FileInputStream(App.pathImg + "/JUGADORES/" + jb1.getNombre() + ".jpg")) {
            ImageView img = new ImageView();
            Image imagen = new Image(input);
            img.setImage(imagen);
            img.setFitWidth(100);
            img.setPreserveRatio(true);
            vb1.getChildren().add(img);
        } catch (FileNotFoundException e) {
            System.out.println("Imagen de jugador no encontrada.");
        } catch (IOException e2) {
            System.out.println("Error, vuelva a intentar.");
        }
        VBox vbpequenio = new VBox();
        vbpequenio.setAlignment(Pos.CENTER);
        vbpequenio.setStyle("-fx-background-color:chartreuse;");
        Label dato1 = new Label();
        Label dato2 = new Label();
        Label dato3 = new Label();

        dato1.setText(jb1.getInicialesEquipo());
        dato2.setText("CAMISETA NRO " + jb1.getNumero());
        String tecnico = jb1.getEntrenador().split(" ")[0] + " " + jb1.getEntrenador().split(" ")[1];
        tecnico = tecnico.toUpperCase();
        dato3.setText("DIR. TEC. " + tecnico);
        vbpequenio.getChildren().addAll(dato1, dato2, dato3);
        vb1.getChildren().addAll(vbpequenio, lbcontador);

        Scene scene = new Scene(vb1, 200, 300);
        Stage stage = new Stage();
        stage.setResizable(false);
        //No modificar tamano ventana
        stage.setScene(scene);
        stage.show();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i >= 0; i--) {
                    final int c = i;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lbcontador.setText("Mostrando por " + c + " segundos");
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        stage.close();
                    }
                });
            }
        });
        t1.start();
    }
}
