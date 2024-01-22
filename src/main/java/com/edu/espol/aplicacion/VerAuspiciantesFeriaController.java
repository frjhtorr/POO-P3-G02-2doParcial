/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.edu.espol.aplicacion;

import com.espol.personas.Auspiciante;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
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
import javafx.scene.control.DatePicker;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Josh
 */
public class VerAuspiciantesFeriaController implements Initializable {
    private ArrayList<Auspiciante> ausps;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

// Se necesita una feria para este metodo

public void infoAusp(ArrayList<Auspiciante> lstAusp, VBox vbAuspiciantes){

// Supongo que hay un VBox que me ponga los auspiciantes por columna en el controller que estoy trabajando

        vbAuspiciantes.setSpacing(30);
        vbAuspiciantes.getChildren().add(new HBox(new Text("Número de cedula de cada auspiciante")));
        for(Auspiciante ausp: lstAusp){ 
          Button b = new Button("Ver info");        
   
          HBox hb1 = new HBox(new Text(ausp.getCedula()), new Text(ausp.getOwner()),  b);
          hb1.setSpacing(10);
          vbAuspiciantes.getChildren().add(hb1);
          b.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{
            
        VBox redesVBox = new VBox();
        redesVBox.getChildren().add(new Label("Redes Sociales:"));
        for (CuentaRedSocial red : ausp.getLstRedes()) {
            redesVBox.getChildren().add(new Label(red.toString()));
        }
       
          VBox infoVBox = new VBox();
        infoVBox.getChildren().add(new Label("Cédula: " + ausp.getCedula()));
        infoVBox.getChildren().add(new Label("Nombre: " + ausp.getNombre()));
        infoVBox.getChildren().add(new Label("Teléfono: " + ausp.getTelefono()));
        infoVBox.getChildren().add(new Label("Email: " + ausp.getEmail()));
        infoVBox.getChildren().add(new Label("Dirección: " + ausp.getDireccion()));
        infoVBox.getChildren().add(new Label("Web: " + ausp.getWeb()));
        infoVBox.getChildren().add(new Label("Owner: " + ausp.getOwner()));

        // Agregar los VBox al GridPane en diferentes columnas
     
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(20,20,20,20));
        gp.add(infoVBox,2,0);
        gp.add(redesVBox, 0,0);
        //gp.add(standsVBox, 1, 0);
        Stage empStage = new Stage();
        Scene scene = new Scene(gp);
        empStage.setScene(scene);
        empStage.show();

          });
      
    }
    }    
    

}
