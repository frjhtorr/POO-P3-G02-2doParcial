module com.edu.espol.aplicacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.edu.espol.aplicacion to javafx.fxml;
    exports com.edu.espol.aplicacion;
}
