/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas;

import java.util.ArrayList;

/**
 *
 * @author Luis Martin R.P
 */
public class Poblacion {
    int tampoblacion;
    int numreinas;
    ArrayList<Individuo> pob=new ArrayList<Individuo>();
    public Poblacion(int tampoblacion,int numreinas){
        this.tampoblacion=tampoblacion;
        this.numreinas=numreinas;
    }
    
    public void initpoblacion(){
        for(int i=0; i<this.tampoblacion;i++){
            Individuo ind=new Individuo(this.numreinas);
            ind.initindividuo();
            this.pob.add(ind);
        }
    }
}
