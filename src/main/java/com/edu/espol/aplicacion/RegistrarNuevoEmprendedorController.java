/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.edu.espol.aplicacion;

import com.espol.feria.Feria;
import com.espol.personas.Emprendedor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class RegistrarNuevoEmprendedorController implements Initializable {
    private Feria fs ;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private ScrollPane sp;
    @FXML
    private Button backButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fs = MenuFeriasController.fs;
        guardarEmprendedor(fs);
    }    
    
    public void guardarEmprendedor(Feria feria) {
        Emprendedor emp= new Emprendedor();
	
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

        TextArea servicios= new TextArea();
        servicios.setPromptText("Servicios ofrecidos por emprendedor");

        // Agrega los controles al VBox
        root.getChildren().addAll(
		
                new Label("Nombre del emprendimiento"), nombre,
		new Label("Telefono"), tlf,
		new Label("Email"), email,
		new Label("Dirección "), direc,
                new Label("Sitio Web"), web,
                new Label("Dueño de emprendimiento "), owner,
                new Label("Cédula"), ced,
                new Label("Servicios"), servicios
                
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
	    emp.setServicios(servicios.getText());
       	    
	    String cod = fs.getCodFeria();
            for(Feria f : MenuFeriasController.ferias){
                if(cod.equals(f.getCodFeria())){
                    f.getLstEmprendedores().add(emp);
                }
            }
	    
        });

        // Botón de cancelar
        cancelButton.setOnAction(event -> {
            try {
                switchToVerEmprendedores();
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
    
    private void switchToFerias() throws Exception {
        App.setRoot("MenuFerias");
    }
    private void switchToVerEmprendedores() throws Exception {
        App.setRoot("MenuFerias");
    }
    
    
    
    
}
