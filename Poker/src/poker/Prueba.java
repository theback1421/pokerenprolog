/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Prueba.java
 *
 * Created on 23-nov-2009, 11:56:59
 */

package poker;
import javax.swing.ImageIcon;
import clases.*;
import clases.Rank;
import java.awt.Color;
import jpl.Atom;
import jpl.JPL;
import jpl.Query;
import jpl.Term;

/**
 *
 * @author USUARIO
 */
public class Prueba extends javax.swing.JFrame {
        Mesa mesa;
        Jugador j1;
        Jugador j2;
        String nameJ1;

    

        private void init()
        {
            JPL.init();

            Term consult_arg[] = {
                new Atom( "poker.pl" )
            };
            Query consult_query =
                new Query(
                        "consult",
                        consult_arg );

            boolean consulted = consult_query.query();

            if ( !consulted ){
                    System.err.println( "Consult failed" );
                    System.exit( 1 );
            }
        }

    /** Creates new form Prueba */
    public Prueba(String name) {
        super();
        nameJ1 = name;
        initComponents();
    }

       


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelJ1C1 = new javax.swing.JLabel();
        jLabelJ1C2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelJ2C1 = new javax.swing.JLabel();
        jLabelJ2C2 = new javax.swing.JLabel();
        jLabelMesa1 = new javax.swing.JLabel();
        jLabelMesa5 = new javax.swing.JLabel();
        jLabelMesa2 = new javax.swing.JLabel();
        jLabelMesa4 = new javax.swing.JLabel();
        jLabelMesa3 = new javax.swing.JLabel();
        NameJ1 = new javax.swing.JLabel();
        Dolar2 = new javax.swing.JLabel();
        SaldoJ2 = new javax.swing.JLabel();
        Dolar1 = new javax.swing.JLabel();
        SaldoJ1 = new javax.swing.JLabel();
        NameJ2 = new javax.swing.JLabel();
        EmpiezaPartida = new javax.swing.JToggleButton();
        pinguino = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cowboy = new javax.swing.JLabel();
        StringTotalBote = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DolarBote = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(poker.PokerApp.class).getContext().getResourceMap(Prueba.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setForeground(resourceMap.getColor("Form.foreground")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel3.setName("jPanel3"); // NOI18N

        jLabelJ1C1.setIcon(resourceMap.getIcon("jLabelJ1C1.icon")); // NOI18N
        jLabelJ1C1.setText(resourceMap.getString("jLabelJ1C1.text")); // NOI18N
        jLabelJ1C1.setName("jLabelJ1C1"); // NOI18N

        jLabelJ1C2.setIcon(resourceMap.getIcon("jLabelJ1C2.icon")); // NOI18N
        jLabelJ1C2.setText(resourceMap.getString("jLabelJ1C2.text")); // NOI18N
        jLabelJ1C2.setName("jLabelJ1C2"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelJ1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabelJ1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelJ1C1)
                    .addComponent(jLabelJ1C2))
                .addContainerGap())
        );

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jLabelJ2C1.setIcon(resourceMap.getIcon("jLabelJ2C1.icon")); // NOI18N
        jLabelJ2C1.setText(resourceMap.getString("jLabelJ2C1.text")); // NOI18N
        jLabelJ2C1.setName("jLabelJ2C1"); // NOI18N

        jLabelJ2C2.setIcon(resourceMap.getIcon("jLabelJ2C2.icon")); // NOI18N
        jLabelJ2C2.setText(resourceMap.getString("jLabelJ2C2.text")); // NOI18N
        jLabelJ2C2.setName("jLabelJ2C2"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelJ2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelJ2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelJ2C1)
                    .addComponent(jLabelJ2C2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelMesa1.setIcon(resourceMap.getIcon("jLabelMesa1.icon")); // NOI18N
        jLabelMesa1.setText(resourceMap.getString("jLabelMesa1.text")); // NOI18N
        jLabelMesa1.setName("jLabelMesa1"); // NOI18N

        jLabelMesa5.setIcon(resourceMap.getIcon("jLabelMesa5.icon")); // NOI18N
        jLabelMesa5.setText(resourceMap.getString("jLabelMesa5.text")); // NOI18N
        jLabelMesa5.setName("jLabelMesa5"); // NOI18N

        jLabelMesa2.setIcon(resourceMap.getIcon("jLabelMesa2.icon")); // NOI18N
        jLabelMesa2.setText(resourceMap.getString("jLabelMesa2.text")); // NOI18N
        jLabelMesa2.setName("jLabelMesa2"); // NOI18N

        jLabelMesa4.setIcon(resourceMap.getIcon("jLabelMesa4.icon")); // NOI18N
        jLabelMesa4.setText(resourceMap.getString("jLabelMesa4.text")); // NOI18N
        jLabelMesa4.setName("jLabelMesa4"); // NOI18N

        jLabelMesa3.setIcon(resourceMap.getIcon("jLabelMesa3.icon")); // NOI18N
        jLabelMesa3.setText(resourceMap.getString("jLabelMesa3.text")); // NOI18N
        jLabelMesa3.setName("jLabelMesa3"); // NOI18N

        NameJ1.setText(resourceMap.getString("NameJ1.text")); // NOI18N
        NameJ1.setName("NameJ1"); // NOI18N

        Dolar2.setFont(resourceMap.getFont("Dolar2.font")); // NOI18N
        Dolar2.setForeground(resourceMap.getColor("Dolar2.foreground")); // NOI18N
        Dolar2.setText(resourceMap.getString("Dolar2.text")); // NOI18N
        Dolar2.setName("Dolar2"); // NOI18N

        SaldoJ2.setFont(resourceMap.getFont("SaldoJ2.font")); // NOI18N
        SaldoJ2.setForeground(resourceMap.getColor("SaldoJ2.foreground")); // NOI18N
        SaldoJ2.setText(resourceMap.getString("SaldoJ2.text")); // NOI18N
        SaldoJ2.setName("SaldoJ2"); // NOI18N

        Dolar1.setFont(resourceMap.getFont("Dolar1.font")); // NOI18N
        Dolar1.setForeground(resourceMap.getColor("Dolar1.foreground")); // NOI18N
        Dolar1.setText(resourceMap.getString("Dolar1.text")); // NOI18N
        Dolar1.setName("Dolar1"); // NOI18N

        SaldoJ1.setFont(resourceMap.getFont("SaldoJ1.font")); // NOI18N
        SaldoJ1.setForeground(resourceMap.getColor("SaldoJ1.foreground")); // NOI18N
        SaldoJ1.setText(resourceMap.getString("SaldoJ1.text")); // NOI18N
        SaldoJ1.setName("SaldoJ1"); // NOI18N

        NameJ2.setText(resourceMap.getString("NameJ2.text")); // NOI18N
        NameJ2.setName("NameJ2"); // NOI18N

        EmpiezaPartida.setText(resourceMap.getString("EmpiezaPartida.text")); // NOI18N
        EmpiezaPartida.setName("EmpiezaPartida"); // NOI18N
        EmpiezaPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmpiezaPartidaMouseClicked(evt);
            }
        });

        pinguino.setIcon(resourceMap.getIcon("pinguino.icon")); // NOI18N
        pinguino.setText(resourceMap.getString("pinguino.text")); // NOI18N
        pinguino.setName("pinguino"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel1, org.jdesktop.beansbinding.ELProperty.create("${background}"), pinguino, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        Cowboy.setIcon(resourceMap.getIcon("Cowboy.icon")); // NOI18N
        Cowboy.setText(resourceMap.getString("Cowboy.text")); // NOI18N
        Cowboy.setToolTipText(resourceMap.getString("Cowboy.toolTipText")); // NOI18N
        Cowboy.setName("Cowboy"); // NOI18N

        StringTotalBote.setFont(resourceMap.getFont("StringTotalBote.font")); // NOI18N
        StringTotalBote.setForeground(resourceMap.getColor("StringTotalBote.foreground")); // NOI18N
        StringTotalBote.setText(resourceMap.getString("StringTotalBote.text")); // NOI18N
        StringTotalBote.setName("StringTotalBote"); // NOI18N

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setForeground(resourceMap.getColor("jLabel3.foreground")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        DolarBote.setFont(resourceMap.getFont("DolarBote.font")); // NOI18N
        DolarBote.setForeground(resourceMap.getColor("DolarBote.foreground")); // NOI18N
        DolarBote.setText(resourceMap.getString("DolarBote.text")); // NOI18N
        DolarBote.setName("DolarBote"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabelMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DolarBote)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(StringTotalBote))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(jLabel2)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Cowboy, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                                        .addComponent(EmpiezaPartida)
                                        .addGap(180, 180, 180))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(Dolar1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SaldoJ1)
                                        .addContainerGap())))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(NameJ1)
                                .addContainerGap())))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(pinguino, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Dolar2)
                        .addGap(6, 6, 6)
                        .addComponent(SaldoJ2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(496, 496, 496)
                        .addComponent(NameJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(376, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pinguino, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Dolar2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SaldoJ2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NameJ2)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMesa3)
                            .addComponent(jLabelMesa2)
                            .addComponent(jLabelMesa1)
                            .addComponent(jLabelMesa4)
                            .addComponent(jLabelMesa5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(StringTotalBote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DolarBote)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Dolar1)
                            .addComponent(SaldoJ1))
                        .addGap(43, 43, 43)
                        .addComponent(EmpiezaPartida))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cowboy, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameJ1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(54, 54, 54))
        );

        jLabelMesa5.getAccessibleContext().setAccessibleName(resourceMap.getString("jLabelMesa5.AccessibleContext.accessibleName")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmpiezaPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpiezaPartidaMouseClicked


        EmpiezaPartida.setVisible(false);
        NameJ1.setText(nameJ1);
        NameJ2.setText("pepito");

        init();

        mesa = new Mesa();
        mesa.iniciarTurno();
        Mano comuni = new Mano(mesa.getCartasComunitarias());
        comuni.print();
        j1 = new Jugador(mesa.getJugador1());
        Mano mano1 = j1.getMano();
        mano1.print();
        j2 = new Jugador(mesa.getJugador2());
        Mano mano2 = j2.getMano();
        mano2.print();



        jLabelJ1C1.setIcon(GestorImagenes.getCardImage(mano1.getListacartas().get(0)));
        jLabelJ1C2.setIcon(GestorImagenes.getCardImage(mano1.getListacartas().get(1)));

        jLabelJ2C1.setIcon(GestorImagenes.getCardImage(mano2.getListacartas().get(0)));
        jLabelJ2C2.setIcon(GestorImagenes.getCardImage(mano2.getListacartas().get(1)));


        jLabelMesa1.setIcon(GestorImagenes.getCardImage(comuni.getListacartas().get(0)));
        jLabelMesa2.setIcon(GestorImagenes.getCardImage(comuni.getListacartas().get(1)));
        jLabelMesa3.setIcon(GestorImagenes.getCardImage(comuni.getListacartas().get(2)));
        jLabelMesa4.setIcon(GestorImagenes.getCardImage(comuni.getListacartas().get(3)));
        jLabelMesa5.setIcon(GestorImagenes.getCardImage(comuni.getListacartas().get(4)));

        mesa.ganaJugador1();






        // TODO add your handling code here:
}//GEN-LAST:event_EmpiezaPartidaMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Prueba("juan").setVisible(true);
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cowboy;
    private javax.swing.JLabel Dolar1;
    private javax.swing.JLabel Dolar2;
    private javax.swing.JLabel DolarBote;
    private javax.swing.JToggleButton EmpiezaPartida;
    private javax.swing.JLabel NameJ1;
    private javax.swing.JLabel NameJ2;
    private javax.swing.JLabel SaldoJ1;
    private javax.swing.JLabel SaldoJ2;
    private javax.swing.JLabel StringTotalBote;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelJ1C1;
    private javax.swing.JLabel jLabelJ1C2;
    private javax.swing.JLabel jLabelJ2C1;
    private javax.swing.JLabel jLabelJ2C2;
    private javax.swing.JLabel jLabelMesa1;
    private javax.swing.JLabel jLabelMesa2;
    private javax.swing.JLabel jLabelMesa3;
    private javax.swing.JLabel jLabelMesa4;
    private javax.swing.JLabel jLabelMesa5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel pinguino;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
