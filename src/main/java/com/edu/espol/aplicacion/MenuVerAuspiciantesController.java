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
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;



public class MenuVerAuspiciantesController implements Initializable{

    @FXML
    private Button buttonNuevoAuspiciante;
    @FXML
    private VBox vbAuspiciantes;
    
    ArrayList <Auspiciante> auspigen = new ArrayList<>();
    Auspiciante au1 = crearAuspiciante();
    

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
        vbAuspiciantes.setSpacing(30);
        vbAuspiciantes.getChildren().add(new Text("Numero de cedula"));
        for(Auspiciante ausp: auspigen){ 
          Button b = new Button("Ver info");        
          HBox hb1 = new HBox(new Text("Nombre: "+ausp.getNombre()), new Text(ausp.getCedula()), b);
          hb1.setSpacing(10);
          vbAuspiciantes.getChildren().add(hb1);
    } 
}
    
}