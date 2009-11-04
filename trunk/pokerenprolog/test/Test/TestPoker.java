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
    public void testParejaValida()
    {

    }

    @Test
    public void testParejaNoValida()
    {

    }

    @Test
    public void testTrioValido()
    {

    }

    @Test
    public void testTrioNovalido()
    {

    }

    @Test
    public void testRepartir()
    {
        /*que reparta cartas y que se quiten las repartidas de la baraja*/
    }


}