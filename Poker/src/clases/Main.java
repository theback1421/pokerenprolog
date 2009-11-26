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

        Card c1 = new Card(Rank.ACE,Suit.SPADES);
        Card c2 = new Card(Rank.ACE,Suit.CLUBS);
        Card c3 = new Card(Rank.R3,Suit.HEARTS);

        ArrayList<Card> listaCartas = new ArrayList<Card>();
        listaCartas.add(c1);
        listaCartas.add(c2);
        listaCartas.add(c3);

        Mano m = new Mano(listaCartas);


        System.out.println("Valor de la carta más alta = "+m.valorCartaMasAlta());

        Mano parejita = new Mano(m.Trio());
        parejita.print();


        Mesa mesa = new Mesa();
        mesa.iniciarTurno();
        Mano comuni = new Mano(mesa.getCartasComunitarias());
        comuni.print();
        Jugador j1 = new Jugador(mesa.getJugador1());
        j1.print();

    }


}
