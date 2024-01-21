/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.edu.espol.aplicacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import com.espol.feria.*;
import com.espol.personas.*;
import com.espol.redes.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Josh
 */
public class MenuFeriasController implements Initializable {

    @FXML
    private Button buttonNuevaFeria;
    @FXML
    private VBox VBoxFerias;
    @FXML
    private Button VerAuspi;   
    @FXML
    private Button Verstands;

    //Atributos del MenuFeriasControler
    
    // Comienzo a definir algunas ferias y a tener la lista
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        VBoxFerias.setSpacing(10);
       for(Feria f: ferias){ 
          Button b = new Button("Ver info");
          HBox hb1 = new HBox(new Text(f.getNombre()) , new Text(f.getCodFeria()), b);
          hb1.setSpacing(20);
         VBoxFerias.getChildren().add(hb1);
         VBoxFerias.setSpacing(20);
          // A partir de aqui hay el submenu que me lleva a ver la info de la feria
          // Y las creaciones de botones que conecten con los demás menus
          b.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{
          Stage stfe = new Stage();
          BorderPane bp = new BorderPane();
          VBox feriavb = new VBox();
          feriavb.getChildren().addAll(new Text("Nombre: "+f.getNombre()),new Text("Codigo: "+f.getCodFeria()) , new Text("Inicia: "+f.getFechaIni()+"Finaliza: "+f.getFechaFin()) , new Text("Con Horario: "+f.getHorario()) , new Text("Realizado en: "+f.getLugar()) );
          Button btemp = new Button("Ver Emprendedores");
          Button btaup = new Button("Ver Auspiciantes");
          Button bteditfe = new Button("Editar Feria");
          Button btstand = new Button("Ver Stands");
          HBox hb = new HBox(btemp , btaup , bteditfe, btstand);
          hb.setSpacing(25);
          bp.setCenter(feriavb);
          bp.setBottom(hb);
          bp.setTop(new Text("Feria"));
          stfe.setScene(new Scene(bp));
          stfe.show();
          
          
          btstand.setOnAction(e -> {
              try {
                  switchToStands();
              } catch (Exception ex) {
              }
          });

           });
        
        }
    }
        

    @FXML
    private void switchToAuspiciantes() throws Exception{
        App.setRoot("MenuVerAuspiciantes");   
    }
    @FXML
    private void switchToStands() throws Exception{
        App.setRoot("MenuStands");   
    }
    
}

