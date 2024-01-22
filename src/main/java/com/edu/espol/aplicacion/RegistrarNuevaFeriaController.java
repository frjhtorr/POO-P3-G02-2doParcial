/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.edu.espol.aplicacion;

import com.espol.feria.Feria;
import com.espol.feria.Seccion;
import com.espol.feria.Stand;
import com.espol.personas.AuspicianteEnFeria;
import com.espol.personas.Emprendedor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Josh
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import com.espol.feria.*;


import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegistrarNuevaFeriaController implements Initializable {

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private VBox vbox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        guardarFeria(MenuFeriasController.ferias);
    }

    public static void actualizarCodigoFeria(Feria feria, ArrayList<Feria> ferias) {
        int i = ferias.size() + 1;
        feria.setCodFeria("FE" + String.format("%03d", i));
    }

    public void guardarFeria(ArrayList<Feria> lstFerias) {
        Feria feria = new Feria();

        VBox root = new VBox();
        root.setSpacing(10);

        // Controles del formulario
        TextField nombre = new TextField();
        nombre.setPromptText("Nombre");

        TextArea descripcion = new TextArea();
        descripcion.setPromptText("Descripción");

        TextField lugar = new TextField();
        lugar.setPromptText("Lugar");

        DatePicker fechaInicio = new DatePicker(LocalDate.now());
        DatePicker fechaFin = new DatePicker(LocalDate.now());

        TextField hora = new TextField();
        hora.setPromptText("Hora");

        TextField minutos = new TextField();
        minutos.setPromptText("Minutos");

        TextField[] cantStandsSeccion = new TextField[4];
        for (int i = 0; i < 4; i++) {
            cantStandsSeccion[i] = new TextField();
            cantStandsSeccion[i].setPromptText("Cant stands sección " + (i + 1));
        }

        // Agrega los controles al VBox
        root.getChildren().addAll(
                new Label("Nombre"), nombre,
                new Label("Descripción"), descripcion,
                new Label("Lugar"), lugar,
                new Label("Fecha de inicio"), fechaInicio,
                new Label("Fecha de fin"), fechaFin,
                new Label("Hora"), hora,
                new Label("Minutos"), minutos
        );

        root.getChildren().addAll(new Label("Cantidad de Stands por sección"));
        root.getChildren().addAll(cantStandsSeccion);


        vbox.getChildren().add(root);

        // Botón de guardar
        saveButton.setOnAction(event -> {
            // Obtener la información del formulario
            feria.setNombre(nombre.getText());
            feria.setDescripcion(descripcion.getText());
            feria.setLugar(lugar.getText());
            feria.setFechaIni(fechaInicio.getValue().toString());
            feria.setFechaFin(fechaFin.getValue().toString());

            int h = Integer.parseInt(hora.getText());
            int m = Integer.parseInt(minutos.getText());
            String horaMinutos = String.format("%02d:%02d", h, m);
            feria.setHorario(horaMinutos);

            // Manejo de stands y secciones (puedes adaptar según tus necesidades)
            // ...

            // Deserializar lista para volver a escribirla, añadirle la feria y darle código
            lstFerias.add(feria);
            actualizarCodigoFeria(feria, lstFerias);
        });

        // Botón de cancelar
        cancelButton.setOnAction(event -> {
            try {
                switchToFerias();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    private void switchToFerias() throws Exception {
        App.setRoot("MenuFerias");
    }
}

