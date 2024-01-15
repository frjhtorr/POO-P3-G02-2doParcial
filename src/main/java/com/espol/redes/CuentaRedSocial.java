/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.redes;

/**
 *
 * @author joshf
 */
public class CuentaRedSocial {
    private String cuenta;
    private RedSocial red;
    
    public CuentaRedSocial(RedSocial red, String cuenta){
        this.cuenta = cuenta;
        this.red = red;
    }
    
    public String getCuenta(){
        return cuenta;
    }
    public void setCuenta(String cuenta){
        this.cuenta=cuenta;
    }
    
    public RedSocial getRed(){
        return red;
    }
    public void setRedSocial(String red){
        this.red=RedSocial.valueOf(red);
    }
}
