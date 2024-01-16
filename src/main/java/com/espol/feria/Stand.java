/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.feria;

import com.espol.personas.*;

/**
 *
 * @author joshf
 */
public class Stand {
    private String cod;
    private int numAsig;
    private boolean reservado; 
    private Persona owner;
    private String fechaAsigna;

    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public Persona getOwner() {
        return owner;
    }

    public void setOwner(Persona owner) {
        this.owner = owner;
    }

    public String getFechaAsigna() {
        return fechaAsigna;
    }

    public void setFechaAsigna(String fechaAsigna) {
        this.fechaAsigna = fechaAsigna;
    }
    
    public int getNumAsig(){
        return numAsig;
    }
    public void setNumAsig(int numAsig){
        this.numAsig = numAsig;
    }
    
    public boolean estaReservado(){
        if(owner==null){
            this.reservado=false;
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Stand{" + "cod=" + cod + ", numAsig=" + numAsig ;
    }
    
  
}
