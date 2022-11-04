/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas;

import java.util.Random;

/**
 *
 * @author Luis Martin R.P
 */
public class Gen {
    int numreinas;
    int x;
    int y;
    public Gen(int numreinas){
        this.numreinas=numreinas;
    }
    
    public void initgen(){
        Random random = new Random();
        this.x = random.nextInt(this.numreinas)+1;
        this.y = random.nextInt(this.numreinas)+1;
    }
}
