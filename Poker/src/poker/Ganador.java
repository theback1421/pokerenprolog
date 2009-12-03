/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Ganador.java
 *
 * Created on 02-dic-2009, 0:01:47
 */

package poker;

import clases.Jugador;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Ganador extends javax.swing.JDialog {

    Jugador jug1;
    Jugador jug2;
    Prueba prueb;
    /** Creates new form Ganador */
    public Ganador(String frase, Jugador J1, Jugador J2,Prueba p) {
        
         p.setVisible(true);
        initComponents();
        MensajeGanador.setText(frase);
        this.setVisible(true);
         jug1 = J1;
         jug2 = J2;
         prueb = p;
         //p.setVisible(false);
         
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Aceptar = new javax.swing.JButton();
        MensajeGanador = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(poker.PokerApp.class).getContext().getResourceMap(Ganador.class);
        Aceptar.setText(resourceMap.getString("Aceptar.text")); // NOI18N
        Aceptar.setName("Aceptar"); // NOI18N
        Aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AceptarMouseClicked(evt);
            }
        });

        MensajeGanador.setText(resourceMap.getString("MensajeGanador.text")); // NOI18N
        MensajeGanador.setName("MensajeGanador"); // NOI18N

        jLabel2.setIcon(resourceMap.getIcon("jLabel2.icon")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(MensajeGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(Aceptar)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(MensajeGanador)
                .addGap(18, 18, 18)
                .addComponent(Aceptar)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AceptarMouseClicked
        this.setVisible(false);
        prueb = new Prueba(jug1,jug2);
        prueb.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_AceptarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JLabel MensajeGanador;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
