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
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

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
 
    // Comienzo a definir algunas ferias y a tener la lista
    
    public static Feria crearFeria(){
        Feria feria = new Feria();
        feria.setCodFeria("FE001");
        feria.setNombre("Feria del Mueble 2024");
        feria.setDescripcion("Venta de muebles de emprendimientos de guayaquileños");
        feria.setLugar("Centro de convenciones");
        feria.setFechaIni("2024-06-15");
        feria.setFechaFin("2024-06-17");
        feria.setHorario("10h00-14h00");
        feria.setLugar("Centro de convenciones");
        ArrayList<AuspicianteEnFeria> lstAuspiciantes= new ArrayList<>();
        ArrayList<Emprendedor> lstEmprendedores= new ArrayList<>();
        feria.setLstAuspiciantes(lstAuspiciantes);
        feria.setLstEmprendedores(lstEmprendedores);
        
        Seccion[] seccionesFeria = new Seccion[4];
        String[] letras = {"A","B","C","D"};
        int j = 0;
        for(String letra : letras){
            Seccion seccion = new Seccion();
            ArrayList<Stand> stands = new ArrayList<Stand>();
            int cant = 4;
            seccion.setCantStands(cant);
            seccion.setId(letra);
            for (int i = 1; i <= (cant+1); i++) {
                Stand st = new Stand();
                st.setCod(letra+i);
                stands.add(st);
            }
            seccion.setArrayStands(stands);
            seccionesFeria[j]=seccion;
            j+=1;
        }
        feria.setSecciones(seccionesFeria);
        
        return feria;
        
        }
    
    
       Feria feria1 = crearFeria();
       ArrayList<Feria> ferias = new ArrayList<Feria>();
       
     
 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ferias.add(feria1);
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

