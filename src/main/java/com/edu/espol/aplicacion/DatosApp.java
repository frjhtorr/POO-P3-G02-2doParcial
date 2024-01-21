/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.espol.aplicacion;

import com.espol.feria.Feria;
import com.espol.feria.Seccion;
import com.espol.feria.Stand;
import com.espol.personas.Auspiciante;
import com.espol.personas.AuspicianteEnFeria;
import com.espol.personas.Emprendedor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Josh
 */
public class DatosApp {
    public ArrayList<Feria> ferias;
    public ArrayList<Auspiciante> auspiciantesGenerales;
    public String rutaFerias = "archivos/ferias.ser";
    public String rutaAuspiciantesGenerales = "archivos/auspiciantes.ser";
    
    public ArrayList<Feria> getFerias(){
        return ferias;
    }
    
    public ArrayList<Auspiciante> getAuspiciantesGenerales(){
        return auspiciantesGenerales;
    }
    
    public void crearFeria(){
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
        
        ferias.add(feria);
        
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
     
}
