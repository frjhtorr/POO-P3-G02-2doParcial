/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.personas;

import com.espol.feria.Stand;
import com.espol.personas.*;
import com.espol.redes.CuentaRedSocial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joshf
 */
public class Auspiciante extends Persona implements Serializable{
    //VARIABLES DE INSTANCIA
    private SectorCubierto sector;
    private int cantStands;
    private String stand1;
    private String stand2;
    
 /*/ CONSTRUCTORES ---------------------------------------------------
  public Auspiciante(String cedula, String nombre, String telefono,
      String email, String direccion, String web, String owner,
      ArrayList<CuentaRedSocial> lstRedes, SectorCubierto sector) {

    super(cedula, nombre, telefono, email, direccion, web, owner, lstRedes);
    this.sector = sector;
  }
  
  public Auspiciante(){
    super(); 
  }

    public Auspiciante(String string, String arturo_Carrera, String string0, String artAUSP2outlookes, String perimetral_km_12, String salud_cc, String auspicio_2, CuentaRedSocial ac, SectorCubierto sectorCubierto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    public String getStand1(){
        return stand1;
    }
    public String getStand2(){
        return stand2;
    }
    public void setStand1(String stand){
        stand1 = stand;
    }
    public void setStand2(String stand){
        stand2 = stand;
    }
    
    public int getCantStand(){
        return cantStands;
    }
    public void setCantStand(int cant){
        cantStands = cant;
    }
    
    public SectorCubierto getSectorCubierto(){
        return sector;
    }
    public void setSectorCubierto(String sector){
        this.sector = SectorCubierto.valueOf(sector);
    }
    public static void opcionesIniciales(){
        Persona.opcionesIniciales();
        System.out.println("8. Sectores cubiertos");
    }
    /*
    public void editarAuspiciante(Scanner sc){
        System.out.println("Datos actuales del Auspiciante: ");
        System.out.println(this.toString());
        opcionesIniciales();
        int option = sc.nextInt();
        sc.nextLine();
    
        if (option > 0 && option < 8){
            this.editarPersona(sc,option);
            
        }
        switch (option) {
            case 8 -> {
                System.out.println("Ingrese NUEVO Sector Cubierto:");
                String servicios = sc.nextLine();
                this.setSectorCubierto(servicios);
            }
        }
    }
*/
}
