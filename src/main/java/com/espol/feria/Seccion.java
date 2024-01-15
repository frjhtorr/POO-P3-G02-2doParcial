/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.feria;

import java.util.ArrayList;

/**
 *
 * @author joshf
 */
public class Seccion {
    //ATRIBUTOS -----------------------------------------------
    private int cantStands;
    private String id;
    private ArrayList<Stand> lstArrayStands;

    public String getId(){
        return id;
    }
    public void setId(String letra) {
        this.id= letra;
    }
    
    public int getCantStands(){
        return cantStands;
    }
    public void setCantStands(int cant){
        this.cantStands = cant;
    }
    
    public ArrayList<Stand> getArrayStands(){
        return lstArrayStands;
    }
    public void setArrayStands(ArrayList<Stand> ArrayStands){
        this.lstArrayStands = ArrayStands;
    }
    
}
