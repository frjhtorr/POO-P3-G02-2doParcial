/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.edu.espol.aplicacion;

import com.espol.personas.Auspiciante;
import com.espol.personas.SectorCubierto;
import static com.espol.personas.SectorCubierto.ALIMENTACION;
import static com.espol.personas.SectorCubierto.EDUCACION;
import static com.espol.personas.SectorCubierto.SALUD;
import static com.espol.personas.SectorCubierto.VESTIMENTA;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Josh
 */
public class RegistrarNuevoAuspicianteController implements Initializable {

    @FXML
    private Button saveButton;
    @FXML
    private Button backButton;
    @FXML
    private VBox vB;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtNombre;
    @FXML
    private ComboBox<SectorCubierto> cbSectores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<SectorCubierto> sectores = FXCollections.observableArrayList(SectorCubierto.values());
        cbSectores.setItems(sectores);
        Auspiciante aus = new Auspiciante();
        aus.setCedula(txtCedula.getText());
        aus.setNombre(txtNombre.getText());
        cbSectores.setOnAction(event -> {
        SectorCubierto selectedSector = cbSectores.getValue();
        aus.setSectorCubierto(selectedSector);
        });
        saveButton.setOnAction(e -> {
              try {
                  guardarAuspiciante(aus);
              } catch (Exception ex) {
              }
          });
        guardarAuspiciante(aus);
        
        backButton.setOnAction(e -> {
              try {
                  switchToFerias();
              } catch (Exception ex) {
              }
          });
    }    
    
    private void guardarAuspiciante(Auspiciante aus){
          try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream("auspiciantes.ser"))) {
                archivo.writeObject(aus);
                mostrarAlerta("Éxito", "Auspiciante guardado con éxito", AlertType.INFORMATION);
                archivo.flush(); //los datos se escribirán inmediatamente en el archivo 
            }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            }
    }
    private void mostrarAlerta(String titulo, String mensaje, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null); // Para no mostrar el encabezado
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    private void switchToFerias() throws Exception{
        App.setRoot("MenuFerias");   
    }
    
    private void switchToAuspiciantes() throws Exception{
        App.setRoot("MenuVerAuspiciantes");   
    }
    
}
