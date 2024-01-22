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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    
    private Feria fs;
    @FXML
    private BorderPane BPferia;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accionesBotones();
        fs = MenuFeriasController.fs;
          VBox feriavb = new VBox();
          feriavb.getChildren().addAll(new Text("Nombre: "+fs.getNombre()),new Text("Codigo: "+fs.getCodFeria()) , new Text("Inicia: "+fs.getFechaIni()+"Finaliza: "+fs.getFechaFin()) , new Text("Con Horario: "+fs.getHorario()) , new Text("Realizado en: "+fs.getLugar()) );
          BPferia.setCenter(feriavb);
          BPferia.setTop(new Text("Feria"));
              
    }  
    private void switchToFerias() throws Exception{
        App.setRoot("MenuFerias");   
    }
    private void switchToMenuVerEmp() throws Exception{
        App.setRoot("MenuVerEmprendedores");   
    }
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
