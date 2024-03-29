/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.edu.espol.aplicacion;

import com.espol.feria.Feria;
import com.espol.personas.Auspiciante;
import com.espol.personas.Emprendedor;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
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
    private Button cancelButton;
    @FXML
    private ScrollPane sp;
    
    private ArrayList<Auspiciante> auspiciantesGenerales;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        auspiciantesGenerales = MenuFeriasController.auspiciantesGenerales;
        guardarAuspiciante(auspiciantesGenerales);
    }    
    
    private void guardarAuspiciante(ArrayList<Auspiciante> auspiciantes){
        Auspiciante emp= new Auspiciante();
	
        VBox root = new VBox();
        root.setSpacing(10);

        // Controles del formulario

	TextField nombre = new TextField();
        nombre.setPromptText("Nombre del emprendimiento");

	TextField tlf = new TextField();
        tlf.setPromptText("Teléfono");

	TextField email= new TextField();
        email.setPromptText("Email");
	
	TextField direc= new TextField();
        direc.setPromptText("Dirección");
	
	TextField web = new TextField();
        web.setPromptText("Sitio Web");
	
	TextField owner = new TextField();
        owner.setPromptText("Dueño del emprendimiento");

	TextField ced= new TextField();
        ced.setPromptText("Cédula de identidad");

        

        // Agrega los controles al VBox
        root.getChildren().addAll(
		
                new Label("Nombre del emprendimiento"), nombre,
		new Label("Telefono"), tlf,
		new Label("Email"), email,
		new Label("Dirección "), direc,
                new Label("Sitio Web"), web,
                new Label("Dueño de emprendimiento "), owner,
                new Label("Cédula"), ced
                                
        );


        sp.setContent(root);

        // Botón de guardar
        saveButton.setOnAction(event -> {
            // Obtener la información del formulario
            emp.setCedula(ced.getText());
	    emp.setNombre(nombre.getText());
	    emp.setTelefono(tlf.getText());
	    emp.setEmail(email.getText());
	    emp.setDireccion(direc.getText());
	    emp.setWeb(web.getText());
	    emp.setOwner(owner.getText());
	           	    
           auspiciantes.add(emp);
	    
        });

        // Botón de cancelar
        cancelButton.setOnAction(event -> {
            try {
                switchToAuspiciantes();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }); 
        backButton.setOnAction(event -> {
            try {
                switchToFerias();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }); 
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
