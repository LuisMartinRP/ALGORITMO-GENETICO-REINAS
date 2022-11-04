/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Luis Martin R.P
 */
public class Tablero {
    JPanel p;
    int w,h;
    Individuo ind;
    boolean quens;
    public Tablero(JPanel p,Individuo ind,boolean quens){
        this.p=p;
        this.ind=ind;
        this.quens=quens;
    }
    public void paint(){
        Graphics2D g=(Graphics2D)p.getGraphics();
        this.w=p.getWidth();
        this.h=p.getHeight();
        //System.out.println(this.w);
        //System.out.println(this.h);
        int casilla=w/(ind.indi.size()+1);
        //System.out.println(casilla);
        g.clearRect(0,0,550,550);
        g.translate(25, 525);
        g.drawLine (0, 0, 500, 0);
        g.drawLine (0, 0, 0, -500);
        int cont=1;
        for(int i=0;i<=w;i+=casilla){
            g.setColor (Color.black);
            g.fillOval (i-3, -3, 6, 6);
            g.drawString(String.valueOf(cont-1),i-(casilla/2), 15);
            if(i!=0){
                g.setColor (Color.blue);
                g.drawLine (0, -1*i, 500, -1*i);
            }
            g.setColor (Color.black);
            g.fillOval (-3, (-1*i)-3, 6, 6);
            g.drawString(String.valueOf(cont),-10,(-1*(i+casilla/2))-3);
            if(i!=0){
                g.setColor (Color.blue);
                g.drawLine (i, 0, i, -500);
            }
            cont++;
        }
        if(quens){
            g.setColor (Color.black);
            for(int i=0;i<ind.indi.size();i++){
                g.fillOval((ind.indi.get(i).x-1)*casilla,(-1*ind.indi.get(i).y)*casilla,casilla,casilla);
            }
        }
    }
}
