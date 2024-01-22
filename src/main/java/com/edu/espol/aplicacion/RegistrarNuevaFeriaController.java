/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.edu.espol.aplicacion;

import com.espol.feria.Feria;
import com.espol.feria.Seccion;
import com.espol.feria.Stand;
import com.espol.personas.AuspicianteEnFeria;
import com.espol.personas.Emprendedor;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Josh
 */
public class RegistrarNuevaFeriaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        guardarFeria(MenuFeriasController.ferias);
    }    
    
        public static void actualizarCodigoFeria(Feria feria, ArrayList<Feria> ferias) {
    int i = ferias.size() + 1;
    feria.setCodFeria("FE"+String.format("%03d", i));
    }
    
    public void guardarFeria(ArrayList lstFerias){
     // Creo una feria para iniciar
    Feria feria = new Feria();
    // Crea un stage
    Stage stage = new Stage();

    // Crea un VBox para contener los controles del formulario
    VBox root = new VBox();

    // Crea los controles del formulario
    TextField nombre = new TextField();
    TextArea descripcion = new TextArea();
    TextField lugar = new TextField();
    DatePicker fechaInicio = new DatePicker();
    DatePicker fechaFin = new DatePicker();
    TextField cantStandsSeccion1 = new TextField();
    TextField cantStandsSeccion2 = new TextField();
    TextField cantStandsSeccion3 = new TextField();
    TextField cantStandsSeccion4 = new TextField();

// Parte de la Hora
    ChoiceBox<Integer> hora = new ChoiceBox<>();
    for (int i = 0; i <= 12; i++) {
        hora.getItems().add(i);
    }

    ChoiceBox<Integer> minutos = new ChoiceBox<>();
    for (int i = 0; i <= 60; i++) {
        minutos.getItems().add(i);
    }

    // Agrega los controles al VBox
    root.getChildren().addAll(
        new Label("Nombre"), nombre,
        new Label("Descripción"), descripcion,
        new Label("Lugar"), lugar,
        new Label("Fecha de inicio"), fechaInicio,
        new Label("Fecha de fin"), fechaFin,
	new Label("Hora"), hora,
        new Label("Minutos"), minutos,
        new Label("Cant stands sección 1"), cantStandsSeccion1,
        new Label("Cant stands sección 2"), cantStandsSeccion2,
        new Label("Cant stands sección 3"), cantStandsSeccion3,
        new Label("Cant stands sección 4"), cantStandsSeccion4
    );

    // Crea un botón de guardar
    Button guardar = new Button("Guardar");
    guardar.setOnAction(event -> {
        // Obtener la información del formulario
        feria.setNombre(nombre.getText());
        feria.setDescripcion(descripcion.getText());
        feria.setLugar(lugar.getText());
        feria.setFechaIni(String.valueOf(fechaInicio));
        feria.setFechaFin(String.valueOf(fechaFin));
        feria.setHorario(String.valueOf(hora));
	ArrayList<AuspicianteEnFeria> lstAuspiciantes= new ArrayList<>();
        ArrayList<Emprendedor> lstEmprendedores= new ArrayList<>();
        feria.setLstAuspiciantes(lstAuspiciantes);
        feria.setLstEmprendedores(lstEmprendedores);


// Parte de los stands
	ArrayList<Integer> cdtstand = new ArrayList<>();
	cdtstand.add(Integer.parseInt(cantStandsSeccion1.getText()));
	cdtstand.add(Integer.parseInt(cantStandsSeccion2.getText()));
        cdtstand.add(Integer.parseInt(cantStandsSeccion3.getText()));
        cdtstand.add(Integer.parseInt(cantStandsSeccion4.getText()));
	Seccion[] seccionesFeria = new Seccion[4];
        String[] letras = {"A","B","C","D"};
        int j = 0;
	int x = 0;
        for(String letra : letras){
            Seccion seccion = new Seccion();
            ArrayList<Stand> stands = new ArrayList<Stand>();
            int cant = cdtstand.get(x);
            seccion.setCantStands(cant);
            seccion.setId(letra);
            for (int i = 1; i <= (cant+1); i++) {
                Stand st = new Stand();
                st.setCod(letra+i);
                stands.add(st);
            }
	    x +=1;
            seccion.setArrayStands(stands);
            seccionesFeria[j]=seccion;
            j+=1;
        }
        feria.setSecciones(seccionesFeria);


// Parte del horario
 	int h = hora.getValue();
        int m = minutos.getValue();

        // Construye la cadena de hora y minutos
        String horaMinutos = String.format("%02d:%02d", h, m);

        // Asigna la hora y los minutos a la feria
        feria.setHorario(horaMinutos);


	// desearilzar lista para volverla a escribirla, añadirle la feria y darle código 
	lstFerias.add(feria);
	actualizarCodigoFeria(feria, lstFerias);

        // Cierra el stage
        stage.close();
    });

    // Crea un botón de cancelar
    Button cancelar = new Button("Cancelar");
    cancelar.setOnAction(event -> {
        // Cierra el stage
        stage.close();
    });

    // Agrega los botones al VBox
    root.getChildren().addAll(guardar, cancelar);

    // Establece el contenido del stage
    stage.setScene(new Scene(root));

    // Muestra el stage
    stage.show();
}
}
