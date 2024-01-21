/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.edu.espol.aplicacion;

import com.espol.personas.Emprendedor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Josh
 */
public class MenuVerEmprendedoresController implements Initializable {

    @FXML
    private Button buttonNuevoEmprendedor;
    @FXML
    private VBox vbEmprendedores;
    @FXML
    private Button backButton;
    
    private ArrayList<Emprendedor> emps;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        emps=MenuFeriasController.fs.getLstEmprendedores();
        // TODO
         
    }  
    
    private void switchToVerInfoFerias() throws Exception{
        App.setRoot("VerInfoFeria");   
    }
    
    private void switchToNuevoEmprendedor() throws Exception{
        App.setRoot("RegistrarNuevoEmprendedor");   
    }
    
    private void accionesBotones(){
        backButton.setOnAction(e -> {
                  try {
                      switchToVerInfoFerias();
                  } catch (Exception ex) {
                  }
              }); 
        buttonNuevoEmprendedor.setOnAction(e -> {
                  try {
                      switchToNuevoEmprendedor();
                  } catch (Exception ex) {
                  }
              });
    }
    
}
