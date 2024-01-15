/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.personas;

/**
 *
 * @author joshf
 */
public class AuspicianteEnFeria extends Auspiciante{
    private String auspicio;
    private boolean tieneStand;

    public String getAuspicio() {
        return auspicio;
    }
    public void setAuspicio(String auspicio) {
        this.auspicio = auspicio;
    }
    
    public boolean isTieneStand() {
        return tieneStand;
    }
    public void setTieneStand(boolean tieneStand) {
        this.tieneStand = tieneStand;
    }
    
}
