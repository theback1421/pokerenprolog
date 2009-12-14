/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import clases.*;
import java.util.ArrayList;
import java.util.Hashtable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import jpl.Query;

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
        Rank actual = null;
        String esperado;
        esperado = "ACE";
        if(esperado.compareTo(actual.ACE.toString())==0)
            res = true;
        assertTrue(res);
    }

    @Test
    public void testRankNoExiste()
    {
        boolean res=false;
        Rank actual = null;

        String esperado;
        esperado = "AS";
        if(esperado.compareTo(actual.ACE.toString())==0)
            res = true;
        assertFalse(res);
    }

    @Test
    public void testSuitExiste()
    {
        boolean res=false;
        Suit actual = null;

        String esperado;
        esperado = "CLUBS";
        if(esperado.compareTo(actual.CLUBS.toString())==0)
            res = true;
        assertTrue(res);
    }

    @Test
    public void testSuitNoExiste()
    {
        boolean res=false;
        Suit actual = null;

        String esperado;
        esperado = "BASTOS";
        if(esperado.compareTo(actual.CLUBS.toString())==0)
            res = true;
        assertFalse(res);
    }

    @Test
    public void testCartaExiste()
    {
        String rank = "ace";
        String suit = "spades";
        Query q = new Query("card("+rank+","+suit+")");
        assert(q.hasSolution());
    }


    @Test
    public void testCartaNoExiste()
    {
        String rank = "as";
        String suit = "bastos";
        Query q = new Query("card("+rank+","+suit+")");
        q.hasSolution();
    }
}
/*

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
        /*que reparta cartas y que se quiten las repartidas de la baraja
        boolean res = false;
        Baraja actual = new Baraja();
        Baraja aux = new Baraja();
        actual.setBaraja();
        aux=actual;
        actual.repartirCartas();
        Baraja esperada = actual;
        if(esperada.getBarajalist().size()!=aux.getBarajalist().size())
        {
            res = true;
        }
        assertTrue("No reparte bien",res);
    }

    @Test
    public void testJugador()
    {
        Jugador j = new Jugador();
        Mano m = new Mano();
        Card c1 = new Card();
        Card c2 = new Card();
        Card c3 = new Card();
        Card c4 = new Card();
        Card c5 = new Card();
        Card c6 = new Card();
        Card c7 = new Card();

        ArrayList<Card> listacartas = new ArrayList();
        listacartas.add(c1);
        listacartas.add(c2);
        listacartas.add(c3);
        listacartas.add(c4);
        listacartas.add(c5);
        listacartas.add(c6);
        listacartas.add(c7);
        m.setListacartas(listacartas);
        j.setMano(m);
        assertEquals("Cantidad de cartas insuficiente",7,j.getMano().getListacartas().size());
    }

    @Test
    public void testApuesta()
    {
        Apuesta a = new Apuesta();
        a.setApuesta(-1);
        boolean res=a.validarApuesta();
        assertFalse("Apuesta valida",res);
    }

    

}
*/