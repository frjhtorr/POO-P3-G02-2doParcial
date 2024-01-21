/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.edu.espol.aplicacion;

import com.espol.feria.Feria;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Josh
 */
public class VerInfoFeriaController implements Initializable {

    @FXML
    private Button verEmpButton;
    @FXML
    private Button verAuspiciantesButton;
    @FXML
    private Button editarFeriaButton;
    @FXML
    private Button verStandsButton;
    @FXML
    private Button backButton;
    @FXML
    private VBox vb;
    @FXML
    private Label lblNC;
    
    private Feria fs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accionesBotones();
        fs = MenuFeriasController.fs;
        
    }  
    private void switchToFerias() throws Exception{
        App.setRoot("MenuFerias");   
    }
    private void switchToMenuVerEmp() throws Exception{
        App.setRoot("MenuVerEmprendedores");   
    }
    @FXML
    private void switchToStands() throws Exception{
        App.setRoot("MenuStands");   
    }
    private void switchToEditarFeria() throws Exception{
        App.setRoot("EditarFeria");   
    }
    
    private void switchToVerAuspiciantesFeria() throws Exception{
        App.setRoot("EditarFeria");   
    }
    
    private void accionesBotones(){
        backButton.setOnAction(e -> {
              try {
                  switchToFerias();
              } catch (Exception ex) {
              }
          });  
        verEmpButton.setOnAction(e -> {
                  try {
                      switchToMenuVerEmp();
                  } catch (Exception ex) {
                  }
              }); 
        verStandsButton.setOnAction(e -> {
                  try {
                      switchToStands();
                  } catch (Exception ex) {
                  }
              }); 
        editarFeriaButton.setOnAction(e -> {
                  try {
                      switchToEditarFeria();
                  } catch (Exception ex) {
                  }
              });
        verAuspiciantesButton.setOnAction(e -> {
                  try {
                      switchToVerAuspiciantesFeria();
                  } catch (Exception ex) {
                  }
              });
    }
       
    
}
