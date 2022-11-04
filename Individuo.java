/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Luis Martin R.P
 */
public class Individuo {
    int numreinas;
    ArrayList<Gen> indi = new ArrayList<Gen>();
    int x;
    int y;
    int aptitu;
    public Individuo(int numreinas){
        this.numreinas=numreinas;
    }
    
    public void initindividuo(){
        for(int i=0;i<this.numreinas;i++){
            Gen g=new Gen(this.numreinas);
            g.initgen();
            indi.add(g);
        }
    }

    public ArrayList<Individuo> cruza(Individuo mama){
        ArrayList<Individuo> hi= new ArrayList<Individuo>();

        int corte=this.numreinas/2;
        //System.out.println(this.numreinas/2);
        Individuo hijo1=new Individuo(mama.numreinas);
        Individuo hijo2=new Individuo(mama.numreinas);

        hijo1.indi.addAll(this.indi.subList(0, corte));
        hijo1.indi.addAll(mama.indi.subList(corte, this.numreinas));
        
        hijo2.indi.addAll(mama.indi.subList(0, corte));
        hijo2.indi.addAll(this.indi.subList(corte, this.numreinas));

        hi.add(hijo1);
        hi.add(hijo2);
        
        return hi;
    }

    public void muta(){
        Random random = new Random();
        int indice = random.nextInt(this.numreinas);
        this.indi.get(indice).x=random.nextInt(this.numreinas)+1;
        this.indi.get(indice).y=random.nextInt(this.numreinas)+1;
    }

    public void validar(){
        for(int i=0;i<this.indi.size();i++){
            for(int j=0;j<this.indi.size();j++){
                if(i!=j){
                    if(this.indi.get(i).x==this.indi.get(j).x && this.indi.get(i).y==this.indi.get(j).y){
                        this.indi.get(j).initgen();
                        this.validar();
                    }
                }
            }
        }
    }
}
