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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    
    public Auspiciante crearAuspiciante1(){
        //Auspiciante 1
        Auspiciante aus1 = new Auspiciante();
        aus1.setCedula("85175384654");
        aus1.setNombre("Christopher Lema");
        aus1.setOwner("Auspicio 1");
        aus1.setCantStand(2);
        aus1.setStand1("A1");
        aus1.setStand2("B3");
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
    public Auspiciante crearAuspiciante2(){
        //Auspiciante 1
        Auspiciante aus1 = new Auspiciante();
        aus1.setCedula("9517538642");
        aus1.setNombre("Arturo Carrera");
        aus1.setOwner("Auspicio 2");
        aus1.setCantStand(1);
        aus1.setStand1("C4");
        
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
    
    public static Emprendedor crearEmprendedor1(){
        //Emprendedor 1
        Emprendedor emp1 = new Emprendedor();
        emp1.setCedula("0908070605");
        emp1.setNombre("Juan Pérez");
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
        
        return emp1;
    }
    
    public static Emprendedor crearEmprendedor2(){
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
        emp2.setNombre("Freddy Torres");
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
        
        return emp2;
    }
    
    
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
       Auspiciante aus1 = crearAuspiciante1();
       Auspiciante aus2 = crearAuspiciante2();
       //ArrayList<Feria> ferias = new ArrayList<Feria>(); 
       //ferias.add(feria1);
       // for(Feria f: ferias){
           VBox VBoxfe = new VBox();
           VBoxfe.setAlignment(Pos.CENTER);
           Label ferianom = new Label("     Feria");
           Label nom = new Label("Distribucion de: "+f.getNombre());
           VBoxfe.getChildren().addAll(ferianom, nom);
           GridPane gp = new GridPane();
           gp.setAlignment(Pos.CENTER);
           gp.setHgap(10);
           gp.setVgap(10);
           gp.setMaxWidth(300); // Tamaño fijo en ancho
           gp.setMaxHeight(200); // Tamaño fijo en alto
           bp.setCenter(VBoxfe);
           VBoxfe.getChildren().add(gp);
           int fila = 0;
           Seccion[] lstsec = f.getSecciones();
           for(Seccion secc: lstsec){
                HBox HBsec = new HBox();
                HBsec.setAlignment(Pos.CENTER);
                HBsec.setSpacing(20);
                ArrayList<Stand> lstStands = secc.getArrayStands();
                for(Stand stand : lstStands){
                String cod = stand.getCod();
                if(cod.equals("A1")){
                    stand.setReservado(true);
                }else if(cod.equals("B3")){
                    stand.setReservado(true);
                }else if(cod.equals("C4")){
                    stand.setReservado(true);
                }else{
                    stand.setReservado(false);
                }
                
        Label label = new Label(stand.getCod());
        // Verificar la condición y establecer el estilo correspondiente
        /*
        if (stand.isReservado()) {
            label.setStyle("-fx-text-fill: red;");
        } else {
            label.setStyle("-fx-text-fill: green;");
        }*/
        Hilo h1 = new Hilo(stand,label);
        Thread t1 = new Thread(h1);
        t1.start();
        StackPane root = new StackPane();
        root.getChildren().add(label);
                    
        //HBsec.getChildren().add(bt);
        Button bt = new Button();
        bt.setGraphic(root);
        HBsec.getChildren().add(bt);
                 bt.setOnAction(e->descripcionStand(stand,bp,label));
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
    
    private void descripcionStand(Stand stand, BorderPane bp, Label lb) {
    // Agrega aquí la lógica que deseas realizar al hacer clic en el botón
        System.out.println("Cod: "+stand.getCod());
        Hilo h1 = new Hilo(stand,lb);
        Thread t1 = new Thread(h1);
        t1.start();
        VBox standDescripcion = new VBox(10);
        standDescripcion.setAlignment(Pos.CENTER);
        Label lblCod = new Label("Código: "+stand.getCod());
        Button reservarButton = new Button("RESERVAR");
        reservarButton.setOnAction(event -> {
        if (stand.isReservado()) {
            mostrarAlerta("Reserva no disponible", "El stand ya está ocupado");
            
        }else{
        VBox standDescripcio = new VBox(); // Crear VBox para la descripción del stand
        standDescripcio.setAlignment(Pos.CENTER);
        Label lblCo = new Label("VERIFICACION");
        Label lblCodigo = new Label("Stand: "+stand.getCod());
        
        Label c = new Label("Ingrese el número de cédula:");
        TextField ced = new TextField();
        Button botonCed = new Button("Buscar");
        //Label resultadoLabel = new Label("Resultado:");

        botonCed.setOnAction(searchEvent -> {
            String numeroCedula = ced.getText();
            
            if (numeroCedula != null && !numeroCedula.isEmpty()) {
                
                //resultadoLabel.setText("Resultado: Cliente encontrado con cédula " + numeroCedula);
            }
            if(numeroCedula.equals("85175384654")){
                mostrarAlerta("Error","El auspiciante Christopher Lema ya tiene dos stands, no puede reservar más stands");
        }else if(numeroCedula.equals("9517538642")){
                mostrarAlerta("Stand Reservado con Éxito","El auspiciante, Arturo Carrera, ha reservado el Stand " + stand.getCod());
                stand.setReservado(true);
                lb.setStyle("-fx-text-fill: red;");
                
        }else if(numeroCedula.equals("1902589436")){
                mostrarAlerta("Stand Reservado con Éxito","El emprendedor, Freddy Torres, ha reservado el Stand " + stand.getCod());
                stand.setReservado(true);
                lb.setStyle("-fx-text-fill: red;");
                
        }else if(numeroCedula.equals("0908070605")){
                mostrarAlerta("Error","El emprendedor, Juan Pérez, ya tiene un stand, no puede reservar otro");
                
                
        }else {
                mostrarAlerta("Campo vacío", "Por favor, ingrese un número de cédula válido.");
            }
        });

        standDescripcio.getChildren().addAll(lblCo,lblCodigo, c, ced, botonCed);
        bp.setRight(standDescripcio);
    }
    });
        standDescripcion.getChildren().addAll(lblCod, reservarButton);
        bp.setRight(standDescripcion);
    }
    
    private void mostrarAlerta(String titulo, String mensaje) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(titulo);
    alert.setHeaderText(null);
    alert.setContentText(mensaje);
    alert.showAndWait();
}
    
    public class Hilo implements Runnable{
        Stand stand;
        Label lb;
        public Hilo(Stand st,Label lb){
            this.stand=st;
            this.lb=lb;
        }
        public void setStand(Stand stand){
            this.stand = stand;
        }
        public void setLb(Label lb){
            this.lb = lb;
        }
        public void run(){
            if (stand.isReservado()) {
            lb.setStyle("-fx-text-fill: red;");
        } else {
            lb.setStyle("-fx-text-fill: green;");
        }
        }
    }

    }
 




