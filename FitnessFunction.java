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
public class FitnessFunction {
    Individuo ind;
    int aptitud=0;
    public FitnessFunction(Individuo ind){
        this.ind=ind;
    }
    
    public int calculaaptitud(){
        for(int i=0;i<ind.indi.size();i++){
            for(int j=0;j<ind.indi.size();j++){
                if(i!=j){
                    if(ind.indi.get(i).x==ind.indi.get(j).x && ind.indi.get(i).y==ind.indi.get(j).y){
                        this.aptitud+=10;
                    }
                    if(ind.indi.get(i).x==ind.indi.get(j).x)
                        this.aptitud++;
                    if(ind.indi.get(i).y==ind.indi.get(j).y)
                        this.aptitud++;
                    
                    for(int k=1;k<=ind.indi.size();k++){
                        if(ind.indi.get(i).x+k==ind.indi.get(j).x && ind.indi.get(i).y+k==ind.indi.get(j).y){
                            this.aptitud++;
                        }
                        if(ind.indi.get(i).x-k==ind.indi.get(j).x && ind.indi.get(i).y-k==ind.indi.get(j).y){
                            this.aptitud++;
                        }
                        
                        if(ind.indi.get(i).x-k==ind.indi.get(j).x && ind.indi.get(i).y+k==ind.indi.get(j).y){
                            this.aptitud++;
                        }
                        
                        if(ind.indi.get(i).x+k==ind.indi.get(j).x && ind.indi.get(i).y-k==ind.indi.get(j).y){
                            this.aptitud++;
                        }
                    }
                    
                }
            }
        }
        ind.aptitu=this.aptitud;
        return this.aptitud;
    }
}
