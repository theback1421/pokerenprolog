/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;
import java.util.*;
import jpl.*;
/**
 *
 * @author USUARIO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       /* Rank conexion;
        Conector c = new Conector();
        conexion =c.getConector();

        Query q1 = new Query("rank(R)");

        java.util.Hashtable[] ss4 = q1.allSolutions();
        System.out.println( "all solutions of " + "rank(R)");
        for ( int i=0 ; i<ss4.length ; i++ )
        {
            System.out.println( "X = " + ss4[i].get("R"));
        }*/
        Conector c = new Conector();
        c.getConector();
        Baraja b = new Baraja();
        b.setBaraja();
    }


}
