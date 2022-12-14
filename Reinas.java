/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Luis Martin R.P
 */
public class Reinas extends javax.swing.JFrame {

    /**
     * Creates new form reinas
     */
    public Reinas() {
        initComponents();
        /*boolean quens=true;
        Tablero tab=new Tablero(jpt,pobla.pob.get(i),quens);
        tab.paint();*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpt = new javax.swing.JPanel();
        jpm = new javax.swing.JPanel();
        jtfr = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jptLayout = new javax.swing.GroupLayout(jpt);
        jpt.setLayout(jptLayout);
        jptLayout.setHorizontalGroup(
            jptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jptLayout.setVerticalGroup(
            jptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Numero de reinas:");

        jButton1.setText("Calcular.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Tama??o poblacion:");

        javax.swing.GroupLayout jpmLayout = new javax.swing.GroupLayout(jpm);
        jpm.setLayout(jpmLayout);
        jpmLayout.setHorizontalGroup(
            jpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpmLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtfr, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1)
                    .addGroup(jpmLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jtfp)))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jpmLayout.setVerticalGroup(
            jpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpmLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(jButton1)
                .addContainerGap(388, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //ArrayList<Individuo> pob = new ArrayList<Individuo>();
        int numreinas=Integer.valueOf(jtfr.getText());
        if(numreinas<4){
            JOptionPane.showMessageDialog(null, "Numero de minimo 4 reinas.");
        }else{
            int tampoblacion=Integer.valueOf(jtfp.getText());
            if (tampoblacion%2==1)
                tampoblacion-=1;
            if(tampoblacion<1){
                JOptionPane.showMessageDialog(null, "Minimo de poblacion 2.");
            }else{
                Poblacion pobla=new Poblacion(tampoblacion,numreinas);
                pobla.initpoblacion();
                boolean detener=true;
                int gener=0;
                ArrayList<Individuo> descendencia = new ArrayList<Individuo>();
                ArrayList<Individuo> hijos = new ArrayList<Individuo>();
                ArrayList<Integer> apti = new ArrayList<Integer>();
                while(detener){
                    descendencia = new ArrayList<Individuo>();
                    hijos = new ArrayList<Individuo>();
                    apti = new ArrayList<Integer>();
                    
                    for(int i=0;i<pobla.pob.size();i++){
                        pobla.pob.get(i).validar();
                    }


                    for(int i=0;i<pobla.pob.size();i++){
                        FitnessFunction ff=new FitnessFunction(pobla.pob.get(i));
                        apti.add(ff.calculaaptitud());
                        //apti.add(pobla.pob.get(i).aptitu);
                    }
                    int menor=Collections.min(apti);
                    //System.out.print(menor);
                    if(menor==0||gener%300==0){
                        for(int i=0;i<pobla.pob.size();i++){
                            if(menor==apti.get(i)){
                                boolean quens=true;
                                Tablero tab=new Tablero(jpt,pobla.pob.get(i),quens);
                                tab.paint();
                                break;
                            }
                        }
                    }
                    /*try{ 
                        Thread.sleep(100); 
                    }catch(InterruptedException e ){}*/

                    Individuo papa=new Individuo(numreinas);
                    Individuo mama=new Individuo(numreinas);
                    for(int i=0;i<pobla.pob.size()/2;i++){
                        
                        for(int j=0;j<2;j++){
                            
                            //Random random1 = new Random();
                            int indice1 = i;//random1.nextInt(pobla.pob.size());
                            Random random2 = new Random();
                            int indice2 = random2.nextInt(pobla.pob.size()/2)+pobla.pob.size()/2;
                            Seleccion sel=new Seleccion(apti.get(indice1),apti.get(indice2));
                            int apt;
                            if(j==0){
                                apt=sel.selecciona();
                                if(apt==apti.get(indice1))
                                    papa=pobla.pob.get(indice1);
                                else
                                    papa=pobla.pob.get(indice2);
                            }else{
                                apt=sel.selecciona();
                                if(apt==apti.get(indice1))
                                    mama=pobla.pob.get(indice1);
                                else
                                    mama=pobla.pob.get(indice2);
                            }
                        }

                        hijos= papa.cruza(mama);

                        descendencia.add(hijos.get(0));
                        descendencia.add(hijos.get(1));
                    }

                    int pormuta= (int) (pobla.pob.size()*.05);
                    if(pormuta<1){
                        pormuta=1;
                    }

                    for(int i=0;i<pormuta;i++){
                        Random random = new Random();
                        int indicem = random.nextInt(tampoblacion);
                        pobla.pob.get(indicem).muta();                        
                    }
                    
                    if(menor==0){
                        detener=false;
                        System.out.println(gener);
                    }
                    gener++;
                    
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reinas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jpm;
    private javax.swing.JPanel jpt;
    private javax.swing.JTextField jtfp;
    private javax.swing.JTextField jtfr;
    // End of variables declaration//GEN-END:variables
}
