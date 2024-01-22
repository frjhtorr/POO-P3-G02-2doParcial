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
public class EditarEmprendedorController implements Initializable {

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private VBox vbDatos;
    
   
    @FXML
    private ScrollPane sp;
    @FXML
    private Button backButton;
    
    private Feria fs ;
    private Emprendedor emp;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fs = MenuFeriasController.fs;
        emp=MenuVerEmprendedoresController.emp;
        editarEmprendedor(fs);
        accionesBotones();
        // TODO
    }
    
    public void mostrarDatosEmprendedor(Emprendedor e){
        System.out.println("EditarDatos");
    }
    
    public void editarEmprendedor(Feria feria) {
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
                
                new Label("Servicios"), servicios
                
        );


        sp.setContent(root);

        // Botón de guardar
        saveButton.setOnAction(event -> {
            // Obtener la información del formulario
	    String cod = fs.getCodFeria();
            for(Feria f : MenuFeriasController.ferias){
                if(cod.equals(f.getCodFeria())){
                    for(Emprendedor e : f.getLstEmprendedores()){
                        if(e.getCedula().equals(emp.getCedula())){
                            e.setNombre(nombre.getText());
                            e.setTelefono(tlf.getText());
                            e.setEmail(email.getText());
                            e.setDireccion(direc.getText());
                            e.setWeb(web.getText());
                            e.setOwner(owner.getText());
                            e.setServicios(servicios.getText());
                        }
                            
                    }
                }
            }
	    
        });

        
        
    }
    
    private void switchToFerias() throws Exception {
        App.setRoot("MenuFerias");
    }
    private void switchToVerEmprendedores() throws Exception {
        App.setRoot("MenuFerias");
    }
    private void accionesBotones(){
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
    
    
}
