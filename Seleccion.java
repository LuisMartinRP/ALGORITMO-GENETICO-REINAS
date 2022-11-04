/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas;

/**
 *
 * @author Luis Martin R.P
 */
public class Seleccion {
    int apt1;
    int apt2;
    public Seleccion(int apt1,int apt2){
        this.apt1=apt1;
        this.apt2=apt2;
    }
    
    public int selecciona(){
        if(apt1<apt2){
            return apt1;
        }
        return apt2;
    }
}
