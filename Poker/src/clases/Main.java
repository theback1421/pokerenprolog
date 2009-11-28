/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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


        String argus[] = JPL.getDefaultInitArgs();
        for(int i=0; i<argus.length; i++)
            System.out.println(argus[i]);
        
        Term consult_arg[] = {
                new Atom( "poker.pl" )
        };
        Query consult_query =
                new Query(
                        "consult",
                        consult_arg );

        boolean consulted = consult_query.hasSolution();

        if ( !consulted ){
                System.err.println( "Consult failed" );
                System.exit( 1 );
        }
        Query q = new Query("baraja");
        q.hasSolution();

        Mesa mesa = new Mesa();
        Mano m = new Mano(mesa.cogerCartasAleatorias(52));
        m.print();
/*        Mesa mesa = new Mesa();
        mesa.iniciarTurno();
        Mano comuni = new Mano(mesa.getCartasComunitarias());
        comuni.print();
        Jugador j1 = new Jugador(mesa.getJugador1());
        j1.print();
        Jugador j2 = new Jugador(mesa.getJugador2());
        j2.print();*/
    }


}
