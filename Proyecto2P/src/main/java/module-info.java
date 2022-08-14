module com.mycompany.proyecto2p {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyecto2p to javafx.fxml;
    exports com.mycompany.proyecto2p;
}
