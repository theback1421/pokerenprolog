/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JMesa.java
 *
 * Created on 23-nov-2009, 13:15:47
 */

package poker;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author USUARIO
 */
public class JMesa extends javax.swing.JPanel {

    /** Creates new form JMesa */
   /** The serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The maximum number of community cards. */
    private static final int NO_OF_CARDS = 5;

    /** The control panel. */
//    private final Panel controlPanel=null;

    /** Label with the bet. */
    private final JLabel betLabel=null;

    /** Label with the pot. */
    private final JLabel potLabel=null;

    /** Labels with the community cards. */
    private final JLabel[] cardLabels=null;

    /** Label with a custom message. */
    private final JLabel messageLabel=null;

    /**
     * Constructor.
     *
     * @param mainFrame
     *            The main frame.
     */
    public JMesa() {
       // this.controlPanel = controlPanel;

      //  setBorder(UIConstants.PANEL_BORDER);
        setBackground(Color.red);
        
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        JLabel label = new JLabel("Bet");
        label.setForeground(Color.GREEN);
        /*
        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 1.0;
        gc.weighty = 0.0;
        gc.insets = new Insets(5, 5, 0, 5);
        add(label, gc);

        label = new JLabel("Pot");
        label.setForeground(Color.GREEN);
        gc.gridx = 3;
        gc.gridy = 0;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 1.0;
        gc.weighty = 0.0;
        gc.insets = new Insets(5, 5, 0, 5);
        add(label, gc);

        betLabel = new JLabel();
       // betLabel.setBorder(UIConstants.LABEL_BORDER);
        betLabel.setForeground(Color.GREEN);
        betLabel.setHorizontalAlignment(JLabel.CENTER);
        gc.gridx = 1;
        gc.gridy = 1;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1.0;
        gc.weighty = 0.0;
        gc.insets = new Insets(5, 5, 5, 5);
        add(betLabel, gc);

        potLabel = new JLabel();
        //potLabel.setBorder(UIConstants.LABEL_BORDER);
        potLabel.setForeground(Color.GREEN);
        potLabel.setHorizontalAlignment(JLabel.CENTER);
        gc.gridx = 3;
        gc.gridy = 1;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1.0;
        gc.weighty = 0.0;
        gc.insets = new Insets(5, 5, 5, 5);
        add(potLabel, gc);

        // The five card positions.
        cardLabels = new JLabel[NO_OF_CARDS];
        for (int i = 0; i < 5; i++) {

            gc.gridx = i;
            gc.gridy = 2;
            gc.gridwidth = 1;
            gc.gridheight = 1;
            gc.weightx = 0.0;
            gc.weighty = 0.0;
            gc.anchor = GridBagConstraints.CENTER;
            gc.fill = GridBagConstraints.NONE;
            gc.insets = new Insets(10, 5, 10, 5);
            add(cardLabels[i], gc);
        }

        // Message label.
        messageLabel = new JLabel();
        messageLabel.setForeground(Color.YELLOW);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        gc.gridx = 0;
        gc.gridy = 3;
        gc.gridwidth = 5;
        gc.gridheight = 1;
        gc.weightx = 1.0;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 0, 5, 0);
        add(messageLabel, gc);

        // Control panel.
        gc.gridx = 0;
        gc.gridy = 4;
        gc.gridwidth = 5;
        gc.gridheight = 1;
        gc.weightx = 1.0;
        gc.weighty = 1.0;
        gc.insets = new Insets(5, 0, 5, 0);
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.BOTH;
       // add(controlPanel, gc);

        update(null, 0, 0);
    */
         }



    /**
     * Updates the current hand status.
     *
     * @param bet
     *            The bet.
     * @param pot
     *            The pot.
     */
    public void update(List<String> cards, int bet, int pot) {
        if (bet == 0) {
            betLabel.setText(" ");
        } else {
            betLabel.setText("$ " + bet);
        }
        if (pot == 0) {
            potLabel.setText(" ");
        } else {
            potLabel.setText("$ " + pot);
        }
        int noOfCards = (cards == null) ? 0 : cards.size();
        //for (int i = 0; i < NO_OF_CARDS; i++) {
          //  if (i < noOfCards) {
            //    cardLabels[i].setIcon(ResourceManager.getCardImage(cards.get(i)));
            //} else {
                //cardLabels[i].setIcon(ResourceManager.getIcon("C:/Documents and Settings/USUARIO/Mis documentos/NetBeansProjects/Interfa/images/card_placeholder.png"));
            //}
        //}
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName("Form"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


  
}
