/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.edu.espol.aplicacion;

import static com.edu.espol.aplicacion.MenuFeriasController.ferias;
import static com.edu.espol.aplicacion.MenuFeriasController.fs;
import com.espol.feria.Feria;
import com.espol.personas.Emprendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
    
    private ArrayList<Emprendedor> emprendedores;
    public static Emprendedor emp;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        emprendedores=MenuFeriasController.fs.getLstEmprendedores();
        // TODO
        
        accionesBotones();
        
        vbEmprendedores.setSpacing(10);
        for(Emprendedor f: emprendedores){ 
          Button b = new Button("Editar");
          HBox hb1 = new HBox(new Text(f.getNombre()) , new Text(f.getEmail()), b);
          hb1.setSpacing(20);
         vbEmprendedores.getChildren().add(hb1);
         vbEmprendedores.setSpacing(20);
          // A partir de aqui hay el submenu que me lleva a ver la info de la feria
          // Y las creaciones de botones que conecten con los demás menus
          b.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{
              emp = new Emprendedor();
              emp= f;
             try {
                  switchToEditarEmprendedor();
              } catch (Exception ex) {
              }
       });
        
        }
    }
    @FXML
    private void switchToEditarEmprendedor() throws Exception{
        App.setRoot("EditarEmprendedor");   
    }
    
    @FXML
    private void switchToNuevoEmprendedor() throws Exception{
        App.setRoot("RegistrarNuevoEmprendedor");   
    }
    
    @FXML
    private void switchToVerInfoFeria() throws Exception{
        App.setRoot("VerInfoFeria");  
    }
    
    private void accionesBotones(){
        backButton.setOnAction(e -> {
                  try {
                      switchToVerInfoFeria();
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
