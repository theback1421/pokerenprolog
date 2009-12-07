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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import clases.*;
import clases.Rank;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import jpl.Atom;
import jpl.JPL;
import jpl.Query;
import jpl.Term;
import poker.resources.BgBorder;

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
         JPanel contenido = new JPanel();
        this.setContentPane(contenido);

        
        initComponents();
        init();
        String jugador = "pingu";
        j1= new Jugador(nameJ1);
        j2= new Jugador(jugador);
       

         File f = new File("./images/fondopantalla.jpg");
        try {
            BufferedImage imagen = ImageIO.read(f);
            BgBorder border = new BgBorder(imagen);
            contenido.setBorder(border);
            

        } catch (IOException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }





        mesa = new Mesa(j1,j2);
        mesa.iniciarTurno();
        Mano comuni = new Mano(mesa.getCartasComunitarias());
        //comuni.print();
        
        Mano mano1 = j1.getMano();
        //mano1.print();
        Mano mano2 = j2.getMano();
        mano2.print();
        //EmpiezaPartida.setVisible(false);
        NameJ1.setText(j1.getNombre());
        NameJ2.setText(j2.getNombre());


        System.out.println("LOS JUGADORESSSSSSSSSSSSSS");
        j1.print();
        j2.print();

        System.out.println("............................");


        



        jLabelJ1C1.setIcon(GestorImagenes.getCardImage(mano1.getListacartas().get(0)));
        jLabelJ1C2.setIcon(GestorImagenes.getCardImage(mano1.getListacartas().get(1)));
/*
        while(!mesa.ganador() && mesa.getRonda() != Ronda.FIN)
        {
           // try {
          //      System.in.read();
           // } catch (IOException ex) {
             //   Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
           // }
            if(mesa.getRonda() == Ronda.PREFLOP)
                mesa.preflop();
            else if(mesa.getRonda() == Ronda.FLOP)
            {
                mesa.flop();
                jLabelMesa1.setIcon(GestorImagenes.getCardImage(comuni.getListacartas().get(0)));
                jLabelMesa2.setIcon(GestorImagenes.getCardImage(comuni.getListacartas().get(1)));
                jLabelMesa3.setIcon(GestorImagenes.getCardImage(comuni.getListacartas().get(2)));
            }
            else if(mesa.getRonda() == Ronda.TURN)
            {
                mesa.turn();
                jLabelMesa4.setIcon(GestorImagenes.getCardImage(comuni.getListacartas().get(3)));
            }
            else if(mesa.getRonda() == Ronda.RIVER)
            {
                mesa.river();
                jLabelMesa5.setIcon(GestorImagenes.getCardImage(comuni.getListacartas().get(4)));
            }
        }
*/
        //jLabelJ2C1.setIcon(GestorImagenes.getCardImage(mano2.getListacartas().get(0)));
        //jLabelJ2C2.setIcon(GestorImagenes.getCardImage(mano2.getListacartas().get(1)));

    }

    public Prueba(Jugador J1, Jugador J2){
        initComponents();
        init();
        NameJ1.setText(J1.getNombre());
        NameJ2.setText(J2.getNombre());
        SaldoJ1.setText(Integer.toString(J1.getDinero()));
        SaldoJ2.setText(Integer.toString(J2.getDinero()));
        mesa = new Mesa(J1,J2);
        mesa.iniciarTurno();
        Mano comuni = new Mano(mesa.getCartasComunitarias());
        //comuni.print();
        j1 = new Jugador(mesa.getJugador1());
        Mano mano1 = j1.getMano();
        mano1.print();
        j2 = new Jugador(mesa.getJugador2());
        Mano mano2 = j2.getMano();
        mano2.print();
         jLabelJ1C1.setIcon(GestorImagenes.getCardImage(mano1.getListacartas().get(0)));
        jLabelJ1C2.setIcon(GestorImagenes.getCardImage(mano1.getListacartas().get(1)));

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
        pinguino = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cowboy = new javax.swing.JLabel();
        StringTotalBote = new javax.swing.JLabel();
        Bote = new javax.swing.JLabel();
        DolarBote = new javax.swing.JLabel();
        Apuesta = new javax.swing.JTextField();
        ConfirmarApuesta = new javax.swing.JToggleButton();
        ConfirmarPasar = new javax.swing.JToggleButton();
        Mensaje = new javax.swing.JLabel();
        Apostar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(poker.PokerApp.class).getContext().getResourceMap(Prueba.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setForeground(resourceMap.getColor("Form.foreground")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        Bote.setFont(resourceMap.getFont("Bote.font")); // NOI18N
        Bote.setForeground(resourceMap.getColor("Bote.foreground")); // NOI18N
        Bote.setText(resourceMap.getString("Bote.text")); // NOI18N
        Bote.setName("Bote"); // NOI18N

        DolarBote.setFont(resourceMap.getFont("DolarBote.font")); // NOI18N
        DolarBote.setForeground(resourceMap.getColor("DolarBote.foreground")); // NOI18N
        DolarBote.setText(resourceMap.getString("DolarBote.text")); // NOI18N
        DolarBote.setName("DolarBote"); // NOI18N

        Apuesta.setText(resourceMap.getString("Apuesta.text")); // NOI18N
        Apuesta.setName("Apuesta"); // NOI18N

        ConfirmarApuesta.setText(resourceMap.getString("ConfirmarApuesta.text")); // NOI18N
        ConfirmarApuesta.setName("ConfirmarApuesta"); // NOI18N
        ConfirmarApuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmarApuestaMouseClicked(evt);
            }
        });

        ConfirmarPasar.setText(resourceMap.getString("ConfirmarPasar.text")); // NOI18N
        ConfirmarPasar.setMaximumSize(new java.awt.Dimension(71, 23));
        ConfirmarPasar.setMinimumSize(new java.awt.Dimension(71, 23));
        ConfirmarPasar.setName("ConfirmarPasar"); // NOI18N
        ConfirmarPasar.setPreferredSize(new java.awt.Dimension(71, 23));
        ConfirmarPasar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmarPasarMouseClicked(evt);
            }
        });

        Mensaje.setText(resourceMap.getString("Mensaje.text")); // NOI18N
        Mensaje.setName("Mensaje"); // NOI18N

        Apostar.setText(resourceMap.getString("BotonAll.text")); // NOI18N
        Apostar.setMaximumSize(new java.awt.Dimension(71, 23));
        Apostar.setMinimumSize(new java.awt.Dimension(71, 23));
        Apostar.setName("BotonAll"); // NOI18N
        Apostar.setPreferredSize(new java.awt.Dimension(71, 23));
        Apostar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ApostarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addComponent(StringTotalBote)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DolarBote)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Bote))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel2))
                            .addComponent(Cowboy, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Dolar1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SaldoJ1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ConfirmarApuesta)
                                        .addGap(18, 18, 18)
                                        .addComponent(Apuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ConfirmarPasar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Apostar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(252, 252, 252))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(NameJ1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGap(217, 217, 217))
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
                .addContainerGap(581, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(914, Short.MAX_VALUE)
                .addComponent(Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                            .addComponent(Bote))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cowboy, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Dolar1)
                                .addComponent(SaldoJ1))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ConfirmarApuesta)
                                .addComponent(Apuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ConfirmarPasar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Apostar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(NameJ1))))
                .addGap(15, 15, 15)
                .addComponent(Mensaje)
                .addGap(25, 25, 25))
        );

        jLabelMesa5.getAccessibleContext().setAccessibleName(resourceMap.getString("jLabelMesa5.AccessibleContext.accessibleName")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 2103, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmarApuestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmarApuestaMouseClicked

        //Faltaria las comprobaciones para que lo que entra sea numeros y no letras.
        if(Integer.parseInt(Apuesta.getText()) > Integer.parseInt(SaldoJ1.getText())){
            Mensaje.setForeground(Color.red);
            Mensaje.setText("No hay suficiente saldo");
            Apuesta.setText("");
           // Mensaje.setForeground(Color.BLACK);
        }
        else{
            int valor =(int) Integer.parseInt(SaldoJ1.getText()) - Integer.parseInt(Apuesta.getText());
            SaldoJ1.setText(Integer.toString(valor));
            int boteActual = Integer.parseInt(Bote.getText());
            int boteNuevo = Integer.parseInt(Apuesta.getText())+ boteActual;
            Bote.setText(Integer.toString(boteNuevo));
            Apuesta.setText("");
            if(mesa.getRonda() == Ronda.PREFLOP)
            {
                mesa.jugar();
                jLabelMesa1.setIcon(GestorImagenes.getCardImage(mesa.getCartasComunitarias().get(0)));
                jLabelMesa2.setIcon(GestorImagenes.getCardImage(mesa.getCartasComunitarias().get(1)));
                jLabelMesa3.setIcon(GestorImagenes.getCardImage(mesa.getCartasComunitarias().get(2)));
            }
            else if(mesa.getRonda() == Ronda.FLOP)
            {
                mesa.jugar();
                jLabelMesa4.setIcon(GestorImagenes.getCardImage(mesa.getCartasComunitarias().get(3)));
            }
            else if(mesa.getRonda() == Ronda.TURN)
            {
                mesa.jugar();
                jLabelMesa5.setIcon(GestorImagenes.getCardImage(mesa.getCartasComunitarias().get(4)));
            }
            else{
                Mano fin = j2.getMano();
                 jLabelJ2C1.setIcon(GestorImagenes.getCardImage(fin.getListacartas().get(0)));
                 jLabelJ2C2.setIcon(GestorImagenes.getCardImage(fin.getListacartas().get(1)));
                 
                 
                 j1.setDinero(Integer.parseInt(SaldoJ1.getText()));
                 j2.setDinero(Integer.parseInt(SaldoJ2.getText()));
                 ArrayList<Puntuacion> puntu = new ArrayList<Puntuacion>();
                 puntu =mesa.puntuacionJugadores();
                 System.out.println("COMENZAMOSSSS");
                 for(int i =0;i< puntu.size();i++){
                  System.out.println(puntu.get(i).getNombreJugador());
                  System.out.println(j1.getNombre());
                  System.out.println(puntu.get(i).getPuntuacion());
              }
              int puntJ1 = puntu.get(0).getPuntuacion();
              int puntJ2 = puntu.get(1).getPuntuacion();
              int dineroJ1 = (int) Integer.parseInt(SaldoJ1.getText());
                 int dineroJ2 = (int) Integer.parseInt(SaldoJ2.getText());
              String ganador,figura;
              if(puntJ1 > puntJ2){
                    int bote = (int) Integer.parseInt(Bote.getText());
                    dineroJ1+=bote;
                    j1.setDinero(dineroJ1);
                    SaldoJ1.setText(Integer.toString(dineroJ1));
                    figura=this.calculaQueTengo(puntJ1);
                    ganador=j1.getNombre()+" gana la ronda "+figura;
                                }
              else{
                     int bote = (int) Integer.parseInt(Bote.getText());
                     dineroJ2+=bote;
                     j2.setDinero(dineroJ2);
                     SaldoJ2.setText(Integer.toString(dineroJ2));
                     figura=this.calculaQueTengo(puntJ2);
                     ganador=j2.getNombre()+" gana la ronda "+figura;
              }
                 
                if(dineroJ1 <= 0 || dineroJ2 <= 0){
                    String Ganador;
                    if (dineroJ1 < 1){
                        Ganador =j2.getNombre()+" gana la partida con "+j2.getDinero()+" $";
                    }
                    else{
                        Ganador =j1.getNombre()+" gana la partida con "+j1.getDinero()+" $";
                    }
                    ConfirmarApuesta.setVisible(false);
                    ConfirmarPasar.setVisible(false);
                    Apostar.setVisible(false);
                    Apuesta.setVisible(false);
                     FindePartida fp = new FindePartida(Ganador,j1,j2);
                     ///this.setVisible(false);
                     System.out.println("FIN");
                 }
                 else{
                  ConfirmarApuesta.setVisible(false);
                    ConfirmarPasar.setVisible(false);
                    Apostar.setVisible(false);
                    Apuesta.setVisible(false);
                 Ganador g = new Ganador(ganador,j1,j2,this);
                 System.out.println("GANADOR PARCIAL");
                 }
                 
            }
            

            
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmarApuestaMouseClicked

    private void ConfirmarPasarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmarPasarMouseClicked
        // TODO add your handling code here:
        Mensaje.setText("");
        j1.setOpcion(Opcion.FOLD);
        Mensaje.setText(nameJ1+" se planta");
        int acumulado = (int) Integer.parseInt(Bote.getText());
        int saldoJ2 = (int) Integer.parseInt(SaldoJ2.getText()) + acumulado;
        SaldoJ2.setText(Integer.toString(saldoJ2));
        Bote.setText("0");
        j1.setDinero(Integer.parseInt(SaldoJ1.getText()));
        j2.setDinero(saldoJ2);

        Ganador g = new Ganador(j2.getNombre()+" gana la ronda por retirada",j1,j2,this);
        

    }//GEN-LAST:event_ConfirmarPasarMouseClicked

    private void ApostarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ApostarMouseClicked
        int x = (int) Integer.parseInt(SaldoJ1.getText());
        int bote = (int) Integer.parseInt(Bote.getText()) + x;
        Bote.setText(Integer.toString(bote));
        SaldoJ1.setText("0");
        //Se evalua la jugada que dice quien es el ganador

        //si gana j1 se le suma el saldo
        // si le gana
        Mano fin = j2.getMano();
        jLabelJ2C1.setIcon(GestorImagenes.getCardImage(fin.getListacartas().get(0)));
        jLabelJ2C2.setIcon(GestorImagenes.getCardImage(fin.getListacartas().get(1)));
        FindePartida fp = new FindePartida("lalala",j1,j2);

    }//GEN-LAST:event_ApostarMouseClicked

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
    private javax.swing.JToggleButton Apostar;
    private javax.swing.JTextField Apuesta;
    private javax.swing.JLabel Bote;
    private javax.swing.JToggleButton ConfirmarApuesta;
    private javax.swing.JToggleButton ConfirmarPasar;
    private javax.swing.JLabel Cowboy;
    private javax.swing.JLabel Dolar1;
    private javax.swing.JLabel Dolar2;
    private javax.swing.JLabel DolarBote;
    private javax.swing.JLabel Mensaje;
    private javax.swing.JLabel NameJ1;
    private javax.swing.JLabel NameJ2;
    private javax.swing.JLabel SaldoJ1;
    private javax.swing.JLabel SaldoJ2;
    private javax.swing.JLabel StringTotalBote;
    private javax.swing.JLabel jLabel2;
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




public String calculaQueTengo(int puntuacion){
    String salida;
    switch(puntuacion){
        case 2:  salida=" con carta alta (2)"; break;
        case 3:   salida=" con carta alta (3)"; break;
        case 4:   salida=" con carta alta (4)"; break;
        case 5:   salida=" con carta alta (5)"; break;
        case 6:   salida=" con carta alta (6)"; break;
        case 7:   salida=" con carta alta (7)"; break;
        case 8:   salida=" con carta alta (8)"; break;
        case 9:   salida=" con carta alta (9)"; break;
        case 10:   salida=" con carta alta (10)"; break;
        case 11:   salida=" con carta alta (J)"; break;
        case 12:   salida=" con carta alta (Q)"; break;
        case 13:  salida=" con carta alta (K)"; break;
        case 14:   salida=" con carta alta (A)"; break;
        case 22:   salida=" con pareja de dos"; break;
        case 23:   salida=" con pareja de tres"; break;
        case 24:   salida=" con pareja de cuatro"; break;
        case 25:   salida=" con pareja de cinco"; break;
        case 26:   salida=" con pareja de seis"; break;
        case 27:   salida=" con pareja de siete"; break;
        case 28:   salida=" con pareja de ocho"; break;
        case 29:   salida=" con pareja de nueve"; break;
        case 30:   salida=" con pareja de diez"; break;
        case 31:   salida=" con pareja de J"; break;
        case 32:   salida= " con pareja de Q"; break;
        case 33:   salida= " con pareja de reyes"; break;
        case 34:   salida=" con pareja de ases"; break;
        case 50:   salida= " con trio"; break;
        case 1:   salida=" con carta alta (1)"; break;
        default:  salida= "error";break;

    }
return salida;
}
}
