/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Hashtable;
import jpl.*;
import jpl.Query;
import poker.*;

/**
 *
 * @author USUARIO
 */
public class TestPoker {

    public TestPoker() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
       
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        Conector c = new Conector();
        c.getConector();

    }

    @After
    public void tearDown() {
    }

    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /*
     Pruebas:
     * Carta que exista
     * Carta que no exista
     * Pareja valor igual
     * Pareja valor distinto
     * Trio de valor igual
     * Trio de valor distinto
     * Selecccionar trio de las 7 cartas
     * Carta mas alta
     * Probar que la baraja son 40 cartas
     * Reparto
     */

    

    
    

    @Test
    public void testRankExiste()
    {
        boolean res=false;
        Rank actual = new Rank();
        actual.setRank();
        String esperado = "{R=ace}";
        for(int i=0;i<actual.getRanklist().size();i++)
        {
            if(actual.getRanklist().get(i).compareTo(esperado)==0)
            {
                res=true;
            }
        }
        assertTrue("El Rank no existe",res);
    }

    @Test
    public void testRankNoExiste()
    {
        boolean res=false;
        Rank actual = new Rank();
        actual.setRank();
        String esperado = "{R=13}";
        for(int i=0;i<actual.getRanklist().size();i++)
        {
            if(actual.getRanklist().get(i).compareTo(esperado)==0)
            {
                res=true;

            }
            
        }
        assertFalse("El Rank existe",res);
    }

    @Test
    public void testSuitExiste()
    {
        
        boolean res=false;
        Suit actual = new Suit();
        actual.setSuit();
        String esperado = "{S=hearts}";
        for(int i=0;i<actual.getSuitlist().size();i++)
        {
            if(actual.getSuitlist().get(i).compareTo(esperado)==0)
            {
                res=true;
                break;
            }
            
        }
        assertTrue("El Suit no existe",res);
    
    }

    @Test
    public void testSuitNoExiste()
    {
        boolean res=false;
        Suit actual = new Suit();
        actual.setSuit();
        String esperado = "{S=bastos}";
        for(int i=0;i<actual.getSuitlist().size();i++)
        {
            if(actual.getSuitlist().get(i).compareTo(esperado)==0)
            {
                res=true;
            }
            
        }
        assertFalse("El Rank existe",res);
    }

    @Test
    public void testCartaExiste()
    {
        Baraja b = new Baraja();
        b.setBaraja();
        boolean res=false;
        Card esperado = new Card();
        esperado.setRank("{R=ace}");
        esperado.setSuit("{S=spades}");
        for(int i=0;i<b.getBarajalist().size();i++)
        {
            if(b.getBarajalist().get(i).getRank().compareTo(esperado.getRank())==0 && b.getBarajalist().get(i).getSuit().compareTo(esperado.getSuit())==0)
            {
                res=true;
            }
            
        }
        assertTrue("La carta no existe",res);

    }

    @Test
    public void testCartaNoExiste()
    {
        Baraja b = new Baraja();
        b.setBaraja();
        boolean res=false;
        Card esperado = new Card();
        esperado.setRank("{R=13}");
        esperado.setSuit("{S=bastos}");
        for(int i=0;i<b.getBarajalist().size();i++)
        {
            if(b.getBarajalist().get(i).getRank().compareTo(esperado.getRank())==0 && b.getBarajalist().get(i).getSuit().compareTo(esperado.getSuit())==0)
            {
                res=true;
            }

        }
        assertFalse("La carta existe",res);
        
    }

    @Test
    public void tesCartaMasAlta()
    {
        boolean res = false;
        Mano m1 = new Mano();
        ArrayList<Card> listacartas = new ArrayList();
        Card esperada1 = new Card();
        Card esperada2 = new Card();
        Card esperada3 = new Card();
        Card esperada4 = new Card();
        Card esperada5 = new Card();
        Card esperada6 = new Card();
        Card esperada7 = new Card();
        esperada1.setCard("{R=ace}", "{S=spades}");
        esperada2.setCard("{R=8}", "{S=clubs}");
        esperada3.setCard("{R=2}", "{S=spades}");
        esperada4.setCard("{R=3}", "{S=spades}");
        esperada5.setCard("{R=4}", "{S=spades}");
        esperada6.setCard("{R=5}", "{S=spades}");
        esperada7.setCard("{R=6}", "{S=spades}");

        listacartas.add(esperada1);
        listacartas.add(esperada2);
        listacartas.add(esperada3);
        listacartas.add(esperada4);
        listacartas.add(esperada5);
        listacartas.add(esperada6);
        listacartas.add(esperada7);

        m1.setListacartas(listacartas);
        Card actual = m1.CogerCartaMasAlta(listacartas);

        assertEquals("{ace}",actual.getRank());
    }

    
    @Test
    public void testParejaValida()
    {
        boolean res = false;
        Mano m1 = new Mano();
        ArrayList<Card> listacartas = new ArrayList();
        Card esperada1 = new Card();
        Card esperada2 = new Card();
        Card esperada3 = new Card();
        Card esperada4 = new Card();
        Card esperada5 = new Card();
        Card esperada6 = new Card();
        Card esperada7 = new Card();
        esperada1.setCard("{R=ace}", "{S=spades}");
        esperada2.setCard("{R=ace}", "{S=clubs}");
        esperada3.setCard("{R=2}", "{S=spades}");
        esperada4.setCard("{R=3}", "{S=spades}");
        esperada5.setCard("{R=4}", "{S=spades}");
        esperada6.setCard("{R=5}", "{S=spades}");
        esperada7.setCard("{R=6}", "{S=spades}");

        listacartas.add(esperada1);
        listacartas.add(esperada2);
        listacartas.add(esperada3);
        listacartas.add(esperada4);
        listacartas.add(esperada5);
        listacartas.add(esperada6);
        listacartas.add(esperada7);

        m1.setListacartas(listacartas);
        res = m1.HayPareja(listacartas);

        assertTrue("Pareja no valida",res);
    }

    @Test
    public void testParejaNoValida()
    {
        boolean res = true;
        Mano m1 = new Mano();
        ArrayList<Card> listacartas = new ArrayList();
        Card esperada1 = new Card();
        Card esperada2 = new Card();
        Card esperada3 = new Card();
        Card esperada4 = new Card();
        Card esperada5 = new Card();
        Card esperada6 = new Card();
        Card esperada7 = new Card();
        esperada1.setCard("{R=ace}", "{S=spades}");
        esperada2.setCard("{R=7}", "{S=clubs}");
        esperada3.setCard("{R=2}", "{S=spades}");
        esperada4.setCard("{R=3}", "{S=spades}");
        esperada5.setCard("{R=4}", "{S=spades}");
        esperada6.setCard("{R=5}", "{S=spades}");
        esperada7.setCard("{R=6}", "{S=spades}");

        listacartas.add(esperada1);
        listacartas.add(esperada2);
        listacartas.add(esperada3);
        listacartas.add(esperada4);
        listacartas.add(esperada5);
        listacartas.add(esperada6);
        listacartas.add(esperada7);

        m1.setListacartas(listacartas);
        res = m1.HayPareja(listacartas);

        assertTrue("Pareja valida",res);
    }

    @Test
    public void testTrioValido()
    {
        boolean res = true;
        Mano m1 = new Mano();
        ArrayList<Card> listacartas = new ArrayList();
        Card esperada1 = new Card();
        Card esperada2 = new Card();
        Card esperada3 = new Card();
        Card esperada4 = new Card();
        Card esperada5 = new Card();
        Card esperada6 = new Card();
        Card esperada7 = new Card();
        esperada1.setCard("{R=ace}", "{S=spades}");
        esperada2.setCard("{R=ace}", "{S=clubs}");
        esperada3.setCard("{R=ace}", "{S=hearts}");
        esperada4.setCard("{R=3}", "{S=spades}");
        esperada5.setCard("{R=4}", "{S=spades}");
        esperada6.setCard("{R=5}", "{S=spades}");
        esperada7.setCard("{R=6}", "{S=spades}");

        listacartas.add(esperada1);
        listacartas.add(esperada2);
        listacartas.add(esperada3);
        listacartas.add(esperada4);
        listacartas.add(esperada5);
        listacartas.add(esperada6);
        listacartas.add(esperada7);

        m1.setListacartas(listacartas);
        res = m1.HayTrio(listacartas);

        assertTrue("Trio no valido",res);

    }

    @Test
    public void testTrioNovalido()
    {
        boolean res = true;
        Mano m1 = new Mano();
        ArrayList<Card> listacartas = new ArrayList();
        Card esperada1 = new Card();
        Card esperada2 = new Card();
        Card esperada3 = new Card();
        Card esperada4 = new Card();
        Card esperada5 = new Card();
        Card esperada6 = new Card();
        Card esperada7 = new Card();
        esperada1.setCard("{R=ace}", "{S=spades}");
        esperada2.setCard("{R=ace}", "{S=clubs}");
        esperada3.setCard("{R=8}", "{S=hearts}");
        esperada4.setCard("{R=3}", "{S=spades}");
        esperada5.setCard("{R=4}", "{S=spades}");
        esperada6.setCard("{R=5}", "{S=spades}");
        esperada7.setCard("{R=6}", "{S=spades}");

        listacartas.add(esperada1);
        listacartas.add(esperada2);
        listacartas.add(esperada3);
        listacartas.add(esperada4);
        listacartas.add(esperada5);
        listacartas.add(esperada6);
        listacartas.add(esperada7);

        m1.setListacartas(listacartas);
        res = m1.HayTrio(listacartas);

        assertTrue("Trio valido",res);

    }

    @Test
    public void testRepartir()
    {
        /*que reparta cartas y que se quiten las repartidas de la baraja*/
        Baraja actual = new Baraja();
        actual.setBaraja();
        actual.repartirCartas();
        Baraja esperada = actual;
        assertNotSame(esperada, actual);
    }

    

}