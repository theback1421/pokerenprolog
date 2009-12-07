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
        mesa.iniciarTurno();
        Mano comuni = new Mano(mesa.getCartasComunitarias());
        comuni.valorCartaMasAlta();
        comuni.print();
        Jugador j1 = new Jugador(mesa.getJugador1());
        j1.print();
        Jugador j2 = new Jugador(mesa.getJugador2());
        j2.print();

        ArrayList<Puntuacion> puntuaciones = mesa.puntuacionJugadores();
        ListIterator it = puntuaciones.listIterator();
        Puntuacion p;
        while(it.hasNext())
        {
            p = (Puntuacion) it.next();
            System.out.println("El jugador "+p.getNombreJugador()+" tiene "+p.getPuntuacion()+ " puntos");
        }
        System.out.println(j1.evaluar(mesa, 600));
    }


}
