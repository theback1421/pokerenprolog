/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import clases.*;
import java.util.ArrayList;
import java.util.Hashtable;
import jpl.Atom;
import jpl.JPL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import jpl.Query;
import jpl.Term;

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
        Rank r;
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
        boolean res=false;
        String rank = "ace";
        String suit = "spades";
        Query q = new Query("card("+rank+","+suit+")");
        System.out.println(q.toString());

        assertTrue(q.hasSolution());
    }


    @Test
    public void testCartaNoExiste()
    {
        String rank = "as";
        String suit = "bastos";
        Query q = new Query("card("+rank+","+suit+")");
        assertFalse(q.hasSolution());
    }



    @Test
    public void tesCartaMasAlta()
    {
        String actual = "{C=6}";
        Query q = new Query("highestHand([card(2,clubs),card(3,diamonds),card(4,spades),card(5,hearts),card(6,hearts)],C)");
        java.util.Hashtable solucion = q.oneSolution();
        System.out.println(solucion.toString());
        assertTrue(q.hasSolution());
    }


    @Test
    public void testParejaValida()
    {
        Query q = new Query("one_pair(OP,[card(2,clubs),card(2,hearts)],R)");
        assertTrue(q.hasSolution());
        //assertEquals("{OP='.'(card(2, clubs), '.'(card(2, hearts), _4)), R=2}",q.oneSolution().toString());
    }



    @Test
    public void testParejaNoValida()
    {
        Query q = new Query("one_pair(OP,[card(4,clubs),card(2,hearts)],R)");
        assertFalse(q.hasSolution());
    }

    @Test
    public void testTrioValido()
    {
        Query q = new Query("three_of_a_kind(TOAK,[card(ace,spades),card(ace,clubs),card(ace,hearts)])");
        assertTrue(q.hasSolution());
    }

    @Test
    public void testTrioNovalido()
    {
        Query q = new Query("three_of_a_kind(TOAK,[card(3,spades),card(ace,clubs),card(ace,hearts)])");
        assertFalse(q.hasSolution());
    }


    @Test
    public void testRepartir()
    {
        Query q = new Query("jugadorCarta(Jugador,[card(6,spades),card(king,hearts)])");
        assertTrue(q.hasSolution());
    }

    @Test
    public void testRepartirMal()
    {
        Query q = new Query("jugadorCarta(Jugador,[card(6,spades),card(king,hearts),card(8,clubs),card(10,diamonds)])");
        assertFalse(q.hasSolution());
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
    public void testApuestaValida()
    {
        Apuesta a = new Apuesta();
        a.setApuesta(100);
        boolean res=a.validarApuesta();
        assertTrue("Apuesta valida",res);
    }

    @Test
    public void testApuestaNoValida()
    {
        Apuesta a = new Apuesta();
        a.setApuesta(-100);
        boolean res=a.validarApuesta();
        assertFalse("Apuesta valida",res);
    }


}