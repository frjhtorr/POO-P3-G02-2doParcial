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
import java.io.IOException;
import com.espol.feria.*;
import com.espol.personas.*;
import com.espol.redes.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Set;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class MenuVerAuspiciantesController implements Initializable{

    @FXML
    private Button buttonNuevoAuspiciante;
    @FXML
    private VBox vbAuspiciantes;
    
    ArrayList <Auspiciante> auspigen = new ArrayList<>();
    Auspiciante au1 = crearAuspiciante();
    
    
    CuentaRedSocial ac = new CuentaRedSocial(RedSocial.FACEBOOK,"Arturro Carrera");
    //Auspiciante au2 = new Auspiciante("9278199370","Arturo Carrera","0960858517","ArtAUSP2@outlook.es","Perimetral km 1/2", "SALUD CC","Auspicio 2",ac,SectorCubierto.SALUD);
    @FXML
    private Button backButton;
    

     public Auspiciante crearAuspiciante(){
        //Auspiciante 1
        Auspiciante aus1 = new Auspiciante();
        aus1.setCedula("9517538642");
        aus1.setNombre("Christopher Lema");
        aus1.setOwner("Auspicio 1");
        
        aus1.setEmail("correo@gmail.com");
        aus1.setWeb("www.ausp1.com.ec");
        aus1.setTelefono("0952864928");
        aus1.setDireccion("Local 1");
        aus1.setSectorCubierto("ALIMENTACION");
        ArrayList<CuentaRedSocial> lstRedes1 = new ArrayList<>();
        CuentaRedSocial crs1 = new CuentaRedSocial(RedSocial.FACEBOOK,"Christopher Lema");
        lstRedes1.add(crs1);
        aus1.setLstRedes(lstRedes1);
        return aus1;

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        auspigen.add(au1);
        try(ObjectInputStream archivo = new ObjectInputStream(new FileInputStream("auspiciantes.ser"))){
                //ferias = (ArrayList<Feria>) archivo.readObject();
                while(true){
                    auspigen.add((Auspiciante) archivo.readObject());
                    System.out.println("Aupiciante leído");
                }
                
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }catch(IOException e){
                System.out.println(e.getMessage());
            }catch(ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        //auspigen.add(au2);
        vbAuspiciantes.setSpacing(30);
        vbAuspiciantes.getChildren().add(new HBox(new Text("Numero de cedula de cada auspiciante")));
        for(Auspiciante ausp: auspigen){ 
          Button b = new Button("Ver info");        
          //b.setPrefWidth(15);
          //b.prefHeight(15);
          HBox hb1 = new HBox(new Text(ausp.getCedula()), new Text(ausp.getOwner()),  b);
          hb1.setSpacing(10);
          vbAuspiciantes.getChildren().add(hb1);
          b.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{
              
      
        
        VBox redesVBox = new VBox();
        redesVBox.getChildren().add(new Label("Redes Sociales:"));
        for (CuentaRedSocial red : ausp.getLstRedes()) {
            redesVBox.getChildren().add(new Label(red.toString()));
        }
        
        /*
        VBox standsVBox = new VBox();
        standsVBox.getChildren().add(new Label("Stands:"));
        for (Stand stand : ausp.getLstStand()) {
            standsVBox.getChildren().add(new Label(stand.toString()));
        }
        */
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
        Stage auspStage = new Stage();
        Scene scene = new Scene(gp);
        auspStage.setScene(scene);
        auspStage.show();
          });
          
    } 
        // QUE TAL MUCHAHCOS, FELIZ ANIO
        backButton.setOnAction(e -> {
              try {
                  switchToFerias();
              } catch (Exception ex) {
              }
          });
        buttonNuevoAuspiciante.setOnAction(e -> {
              try {
                  switchToNuevoAuspiciante();
              } catch (Exception ex) {
              }
          });
}
    
    private void switchToFerias() throws Exception{
        App.setRoot("MenuFerias");   
    }
    
    private void switchToNuevoAuspiciante() throws Exception{
        App.setRoot("RegistrarNuevoAuspiciante");   
    }
    
}