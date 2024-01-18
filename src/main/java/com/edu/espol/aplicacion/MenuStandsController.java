/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.edu.espol.aplicacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import com.espol.feria.*;
import com.espol.personas.*;
import com.espol.redes.*;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Josh
 */
public class MenuStandsController implements Initializable {



    /**
     * Initializes the controller class.
     */
    
         
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
            ArrayList<Stand> stands = new ArrayList<>();
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
    
    @FXML
    private BorderPane bp;
    
    
    public void initialize(URL url, ResourceBundle rb) {   
       Feria f= crearFeria();
       //ArrayList<Feria> ferias = new ArrayList<Feria>(); 
       //ferias.add(feria1);
       // for(Feria f: ferias){
           VBox VBoxfe = new VBox();
           Label ferianom = new Label("     Feria");
           Label nom = new Label("Distribucion de: "+f.getNombre());
           VBoxfe.getChildren().addAll(ferianom, nom);
           GridPane gp = new GridPane();
           bp.setCenter(VBoxfe);
           VBoxfe.getChildren().add(gp);
           int fila = 0;
           Seccion[] lstsec = f.getSecciones();
           for(Seccion secc: lstsec){
                HBox HBsec = new HBox();
                HBsec.setSpacing(20);
                ArrayList<Stand> lstStands = secc.getArrayStands();
                for(Stand stand : lstStands){
                
        Label label = new Label(stand.getCod());
        // Verificar la condición y establecer el estilo correspondiente
        if (stand.isReservado()) {
            label.setStyle("-fx-text-fill: green;");
        } else {
            label.setStyle("-fx-text-fill: red;");
        }
        StackPane root = new StackPane();
        root.getChildren().add(label);
                    
        //HBsec.getChildren().add(bt);
        Button bt = new Button();
        bt.setGraphic(root);
        HBsec.getChildren().add(bt);
                 bt.setOnAction(e->descripcionStand(stand));
                }
                gp.add(HBsec,0, fila);
                fila++;
            } 
             /*
          regresar.setOnAction(e -> {
              try {
                  switchToStands();
              } catch (Exception ex) {
              }
          });*/
        
          
        }
    
    private void descripcionStand(Stand stand) {
    // Agrega aquí la lógica que deseas realizar al hacer clic en el botón
        Stage st = new Stage();
        BorderPane bp = new BorderPane();
        VBox standDescripcion = new VBox();
        Label lblCod = new Label("Código: "+stand.getCod());
        standDescripcion.getChildren().addAll(lblCod);
        st.setScene(new Scene(bp));
        st.show();
    }

    }
 




