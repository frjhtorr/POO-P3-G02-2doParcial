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
import javafx.scene.control.DatePicker;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;

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
    @FXML
    private ImageView im;
    
    //private DatosApp datosApp;
    
    public static ArrayList<Feria> ferias;
    public static ArrayList<Auspiciante> auspiciantesGenerales;
    public String rutaFerias = "archivos/ferias.ser";
    public String rutaAuspiciantesGenerales = "archivos/auspiciantes.ser";
    
    public static Feria fs;
    
    /**
     * Initializes the controller class.
     */
    //ArrayList<Feria> ferias = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ferias = new ArrayList<Feria>();
        
        /*
        datosApp = new DatosApp();
        datosApp.leerArchivoFerias();
        datosApp.crearFeria();
        ArrayList<Feria> ferias = datosApp.getFerias();
        // ArrayList<Auspiciante> auspiciantesGenerales = datosApp.getAuspiciantesGenerales();
        */
        Feria feria = crearFeria(ferias);
        crearEmprendedores(feria);
        ferias.add(feria);
        crearAuspiciantes();
        //*/
        im = new ImageView(new Image("imagenes/logo espol 2-01.png"));
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
              fs = new Feria();
              fs = f;
             try {
                  switchToVerInfoFeria();
              } catch (Exception ex) {
              }
          /*
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
          */
           });
        
        }
    }
    
    private void switchToVerInfoFeria() throws Exception{
        App.setRoot("VerInfoFeria");  
    }

    
    @FXML
    private void switchToAuspiciantes() throws Exception{
        App.setRoot("MenuVerAuspiciantes");   
    }
    
    @FXML
    private void switchToStands() throws Exception{
        App.setRoot("MenuStands");   
    }
    
    @FXML
    private void switchToNuevaFeria() throws Exception{
        App.setRoot("RegistrarNuevaFeria");   
    }
    
    public Feria crearFeria(ArrayList<Feria> ferias){
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
    
    public void actualizarArchivoFerias(){
            try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(rutaFerias))) {
                archivo.writeObject(ferias);
                archivo.flush(); //los datos se escribirán inmediatamente en el archivo 
            }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            } 
        }
        
        
        public void leerArchivoFerias(){
            try(ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(rutaFerias))){
                ferias = (ArrayList<Feria>) archivo.readObject();
                System.out.println("DS");
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }catch(IOException e){
                System.out.println(e.getMessage());
            }catch(ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        
    
       public void actualizarArchivoAuspiciantes(){
           try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(rutaAuspiciantesGenerales))) {
                archivo.writeObject(auspiciantesGenerales);
                
                archivo.flush(); //los datos se escribirán inmediatamente en el archivo 
            }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            } 
       }
       
       public void leerArchivoAuspiciantes(){
            try(ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(rutaAuspiciantesGenerales))){
                auspiciantesGenerales = (ArrayList<Auspiciante>) archivo.readObject();
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }catch(IOException e){
                System.out.println(e.getMessage());
            }catch(ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
       
       public static void crearEmprendedores(Feria f){
        //Emprendedor 1
        Emprendedor emp1 = new Emprendedor();
        emp1.setCedula("0908070605");
        emp1.setNombre("Arturo Carrera");
        emp1.setOwner("Emprendimiento 1");
        emp1.setEmail("arcagarz@gmail.com");
        emp1.setWeb("www.emprendimiento1.com.ec");
        emp1.setTelefono("0952864928");
        emp1.setDireccion("Casa de Arturo");
        emp1.setServicios("Opiniones especializadas de la industria automotriz");
        ArrayList<CuentaRedSocial> lstRedes1 = new ArrayList<>();
        CuentaRedSocial crs1 = new CuentaRedSocial(RedSocial.INSTAGRAM,"@arcagarz");
        lstRedes1.add(crs1);
        emp1.setLstRedes(lstRedes1);
        //Emprendedor 2
        Emprendedor emp2 = new Emprendedor();
        emp2.setCedula("0203040506");
        emp2.setNombre("Christopher Lema");
        emp2.setOwner("Emprendimiento 2");
        emp2.setEmail("chle@gmail.com");
        emp2.setWeb("www.emprendimiento2.com.ec");
        emp2.setTelefono("0960858518");
        emp2.setDireccion("Casa de Christopher");
        emp2.setServicios("Opiniones especializadas de la industria robótica");
        ArrayList<CuentaRedSocial> lstRedes2 = new ArrayList<>();
        CuentaRedSocial crs2 = new CuentaRedSocial(RedSocial.FACEBOOK,"Christopher Lema");
        lstRedes2.add(crs2);
        emp2.setLstRedes(lstRedes2);
        //Emprendedor 3
        Emprendedor emp3 = new Emprendedor();
        emp3.setCedula("1902589436");
        emp3.setNombre("Freddy Torres");
        emp3.setOwner("Emprendimiento 3");
        emp3.setEmail("frjhtorr@gmail.com");
        emp3.setWeb("www.emprendimiento3.com.ec");
        emp3.setTelefono("0979522649");
        emp3.setDireccion("Casa de Freddy");
        emp3.setServicios("Opiniones especializadas de la industria ");
        ArrayList<CuentaRedSocial> lstRedes3 = new ArrayList<>();
        CuentaRedSocial crs3 = new CuentaRedSocial(RedSocial.FACEBOOK,"Christopher Lema");
        lstRedes3.add(crs3);
        emp2.setLstRedes(lstRedes3);
        
        //Agregar a la lista de emprendedores
        ArrayList<Emprendedor> lstEmprendedores = new ArrayList<>();
        lstEmprendedores.add(emp1);
        lstEmprendedores.add(emp2);
        lstEmprendedores.add(emp3);
        
        f.setLstEmprendedores(lstEmprendedores);
    }
    
    public static void crearAuspiciantes(){
        //Auspiciante 1
        Auspiciante aus1 = new Auspiciante();
        aus1.setCedula("9517538642");
        aus1.setNombre("Nombre Auspiciante");
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
       auspiciantesGenerales.add(aus1);
    }
    

    
    
    
}

