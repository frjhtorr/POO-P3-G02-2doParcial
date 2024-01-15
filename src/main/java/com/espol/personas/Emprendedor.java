/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.personas;

import com.espol.redes.CuentaRedSocial;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joshf
 */
public class Emprendedor extends Persona {
    //VARIABLES DE INSTANCIA
    private String servicios;
    
    public Emprendedor(){
        super();
    }
    
    public Emprendedor(String cedula, String nombre, String telefono, String email, String direccion, String web, String owner, ArrayList<CuentaRedSocial> lstRedes, String servicios){
        super(cedula, nombre, telefono, email, direccion, web, owner, lstRedes);
        this.servicios = servicios;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }
    
    public static void opcionesIniciales(){
        Persona.opcionesIniciales();
        System.out.println("8. Servicios");
    }
    /*
    public void editarEmprendedor(Scanner sc){
        System.out.println("Datos actuales del emprendedor: ");
        System.out.println(this.toString());
        opcionesIniciales();
        System.out.println("¿Qué campo desea cambiar?");
        int option = sc.nextInt();
        sc.nextLine();
    
        if (option > 0 && option < 8){
            this.editarPersona(sc,option);
        }
        switch (option) {
            case 8 -> {
                System.out.println("Ingrese los nuevos servicios:");
                String serviciosEmp = sc.nextLine();
                this.setServicios(serviciosEmp);
            }
            }
    }
    */
    
}
