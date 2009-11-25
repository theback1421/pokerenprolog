/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;
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
        /*Conector c = new Conector();
        c.getConector();
        String t = "card(R,S)";
        Query q = new Query(t);
        java.util.Hashtable[] ht = q.allSolutions();
        
        for ( int i=0 ; i<ht.length ; i++ )
        {
            System.out.println( "t = " + ht[i].toString());
        }

        String t1 = "cogerCartaAleatoria(C)";
        Query q2 = new Query(t1);
        System.out.println("t1 = " + q2.oneSolution().get("C"));
        /*Rank actual = new Rank();
        actual.setRank();
        actual.getRanklist().get(0);
        Baraja b = new Baraja();
        b.setBaraja();
        System.out.println("Baraja: \n");
        for(int i=0;i<b.getBarajalist().size();i++)
        System.out.println(b.getBarajalist().get(i).getRank()+b.getBarajalist().get(i).getSuit());*/
    }


}
