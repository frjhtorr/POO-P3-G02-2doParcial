/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.personas;

import com.espol.feria.*;
import com.espol.redes.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joshf
 */
public class Persona {
   //VARIABLES DE INSTANCIA
    protected String cedula;
    protected String nombre;
    protected String telefono;
    protected String email;
    protected String direccion;
    protected String web;
    protected String owner;
    protected ArrayList<CuentaRedSocial> lstRedes;
    protected ArrayList<Stand> lstStands; 
    
    //Constructor default
    public Persona(){  
    }
    //Cosntructor 1
    public Persona(String cedula, String nombre, String telefono,
               String email, String direccion, String web, String owner,
               ArrayList<CuentaRedSocial> lstRedes) {
    this.cedula = cedula;
    this.nombre = nombre;
    this.telefono = telefono;
    this.email = email;
    this.direccion = direccion;
    this.web = web;
    this.owner = owner;
    this.lstRedes = lstRedes;
    }
    //Constructor 2
    public Persona(String cedula, String nombre, String telefono, String email, String direccion, String web, String owner){
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.web = web;
        this.owner = owner;  
    }
    
    public String getCedula(){
        return cedula;
    }
    public void setCedula(String cedula){
        this.cedula = cedula;
    }
    
    public String getNombre(){
        return cedula;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public String getWeb(){
        return web;
    }
    public void setWeb(String web){
        this.web = web;
    }
    
    public String getOwner(){
        return owner;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }
    
    public ArrayList<CuentaRedSocial> getLstRedes(){
        return lstRedes;
    }
    public void setLstRedes(ArrayList<CuentaRedSocial> lstRedes){
        this.lstRedes = lstRedes;
    }
    
    public ArrayList<Stand> getLstStand(){
        return lstStands;
    }
    public void setLstStands(ArrayList<Stand> lstStands){
        this.lstStands = lstStands;
    }
    
    public String toString(){
        return "-----------------------------------------" + "\n" +
               "Nombre: " + nombre + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Email: " + email + "\n" +
               "Direccion: " + direccion + "\n" +
               "Sitio web: " + web + "\n" +
               "Persona responsable: " + owner + "\n" +
               "Redes sociales: " + lstRedes + "\n";
    }
    
    public void setLstRedes(int cR,Scanner sc){
        ArrayList<CuentaRedSocial> lstRedes = new ArrayList<>();
        for(int i = 0; i<cR; i++){
            System.out.println("Elija la red social");
            System.out.println("- TWITTER");
            System.out.println("- FACEBOOK");
            System.out.println("- INSTAGRAM");
            System.out.println("- LINKEDIN");
            System.out.println("- PINTEREST");
            System.out.println("- YOUTUBE");
            
            String redString = sc.nextLine();
            try{
                RedSocial red = RedSocial.valueOf(redString.toUpperCase());
                System.out.println("Ingrese su usuario en "+red+":");
                String usuario = sc.nextLine();
                CuentaRedSocial nuevaRed = new CuentaRedSocial(red, usuario);
                lstRedes.add(nuevaRed);
            }catch(IllegalArgumentException e){
                System.out.println("Red social no válida. Intente de nuevo.");
                i--;
            }
        }
        this.lstRedes = lstRedes;
    }
    
    public static boolean validarCedula(String cedula, ArrayList<? extends Persona> listaPersonas){
        for(Persona p : listaPersonas){
            if(p.getCedula().equals(cedula)){
                System.out.println("La cédula ya está registrada");
                return false;
            }
        }
        return true;
    }
    
    public static Persona crearPersona(Scanner sc){
        System.out.println("Ingrese la cedula: ");
        String c = sc.nextLine();
        System.out.println("Ingrese el nombre:");
        String n = sc.nextLine();
        System.out.println("Ingrese el teléfono:");
        String t = sc.nextLine();
        System.out.println("Ingrese el email:");
        String e = sc.nextLine();
        System.out.println("Ingrese la dirección (puede dejar en blanco):");
        String d = sc.nextLine();
        System.out.println("Ingrese el sitio web (puede dejar en blanco):");
        String w = sc.nextLine();
        System.out.println("Ingrese el nombre de la persona responsable:");
        String o = sc.nextLine();
        Persona p = new Persona(c,n,t,e,d,w,o);
        return p;
  }
    
    public static void opcionesIniciales(){
        System.out.println("--------------------------------");
        System.out.println("¿Qué campo desea editar?");
        System.out.println("1. Nombre");
        System.out.println("2. Teléfono");
        System.out.println("3. Email");
        System.out.println("4. Dirección");
        System.out.println("5. Sitio web");
        System.out.println("6. Persona responsable");
        System.out.println("7. Redes sociales");
    }
    
    /*
    public void editarPersona(Scanner sc,int opcion){
        switch (opcion) {
        case 1 -> {
            System.out.println("Ingrese el nuevo nombre:");
            String nombreN = sc.nextLine();
            nombre = nombreN;
            }
        case 2 -> {
            System.out.println("Ingrese el nuevo teléfono:");
            String telefonoN = sc.nextLine();
            telefono = telefonoN;
            }
        case 3 -> {
            System.out.println("Ingrese el nuevo email:");
            email = sc.nextLine();
            }
        case 4 -> {
            System.out.println("Ingrese la nueva dirección:");
            direccion = sc.nextLine();
            }
        case 5 -> {
            System.out.println("Ingrese el nuevo sitio web:");
            web = sc.nextLine();
            }
        case 6 -> {
            System.out.println("Ingrese la nueva persona responsable:");
            owner = sc.nextLine();
            }
        case 7 -> {
            System.out.println("Ingrese las nuevas redes sociales:");
          int valor = sc.nextInt();
            this.setLstRedes(valor,sc);
            }       
    }

    }
    */
}
