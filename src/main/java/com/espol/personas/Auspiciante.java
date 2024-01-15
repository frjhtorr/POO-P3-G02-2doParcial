/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.personas;

import com.espol.personas.*;
import java.util.Scanner;

/**
 *
 * @author joshf
 */
public class Auspiciante extends Persona{
    //VARIABLES DE INSTANCIA
    private SectorCubierto sector;
    
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
