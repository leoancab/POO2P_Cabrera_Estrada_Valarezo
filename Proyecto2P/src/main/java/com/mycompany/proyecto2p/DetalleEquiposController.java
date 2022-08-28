package com.mycompany.proyecto2p;

import Modelo.Jugador;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

            }else{
                listequipo2.add(ConsultaPartidosController.jugadoresPartido.get(i));
                
            }
            
        }
        
        for (int i = 0; i < listequipo1.size(); i++) {
            modificarVBox((VBox)childrens1.get(i), listequipo1.get(i));
        }
        
        for (int i = 0; i < listequipo2.size(); i++) {
            modificarVBox((VBox)childrens2.get(i), listequipo2.get(i));
        }

    }

    public void mostrarAleatorio(HBox hb, ArrayList<Jugador> listJB) {
        int numAle = (int) Math.random() * 24; // No incluye el ultimo numero por eso 24
        hb.getChildren().get(numAle);

    }

    public void modificarVBox(VBox v, Jugador jb) {
        v.getChildren().clear();
        Label lb = new Label();
        lb.setText(jb.getNombre());

        try (FileInputStream input = new FileInputStream(App.pathImg + "/JUGADORES/" + jb.getNombre() + ".jpg")) {
            ImageView img = new ImageView();
            Image imagen = new Image(input);
            img.setImage(imagen);
            img.setFitWidth(100);
            img.setPreserveRatio(true);

            v.getChildren().add(img);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
        v.getChildren().add(lb);
    }

    
    
    public void mostrarJugador(VBox vb1){
        vb1.setOnMouseClicked(e->{
            VBox ventanita = new VBox();
            
        try (FileInputStream input = new FileInputStream() {
            ImageView img = new ImageView();
            Image imagen = new Image(input);
            img.setImage(imagen);
            img.setFitWidth(100);
            img.setPreserveRatio(true);
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
            
          
            Label nombreJug = new Label();
            Label detallesJug = new Label();
            Label contador = new Label();
            
            ventanita.getChildren().addAll(nombreJug,img,detallesJug,contador);
            
            
        }
        );
        
    }

}
