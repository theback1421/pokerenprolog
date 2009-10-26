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

/**
 *
 * @author USUARIO
 */
public class TestPoker {

    public TestPoker() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        java.lang.String t1 = "consult('poker.pl')";
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
    public static void prueba1( )
    {
        java.lang.String t1 = "consult('poker.pl')";
        Query q1 = new Query(t1);
        System.out.println( t1 + " " + (q1.hasSolution() ?
        "succeeded" : "failed") );
        java.lang.String t2 = "card(R,S)";
        Query q2 = new Query(t2);
        System.out.println( t2 + " " + (q2.hasSolution() ?
        "succeeded" : "failed") );

    }

    @Test
    public void carta_existe()
    {
        ArrayList r,s;
        java.lang.String t = "card(R,S)";
        Query q = new Query(t);
        Hashtable[] ht=q.allSolutions();
        System.out.println( "all solutions of " + t);
        for ( int i=0 ; i<ht.length ; i++ )
        {
            System.out.println( "R = " + ht[i].get("R"));
        }
    }

}