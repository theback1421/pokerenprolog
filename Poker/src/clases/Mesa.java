/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.util.ArrayList;
import jpl.Query;
import jpl.Term;
import jpl.Variable;


/**
 *
 * @author Ramon
 */
public class Mesa {
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Card> cartasComunitarias;
    private Ronda ronda;
    private int turno=1;
    private int ciegaPequena;
    private int ciegaGrande;
    private int bote;

    public Mesa()
    {
        turno = 1;
        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        cartasComunitarias = null;
        ronda = Ronda.PREFLOP;
    }

    public Mesa(Jugador j1, Jugador j2, ArrayList<Card> cartas)
    {
        turno = 1;
        jugador1 = j1;
        jugador1.setDealer();
        jugador2 = j2;
        jugador2.unsetDealer();

        cartasComunitarias = cartas;
        ronda = Ronda.PREFLOP;
    }

    public Jugador getJugador1()
    {
        return jugador1;
    }

    public Jugador getJugador2()
    {
        return jugador2;
    }

    private void baraja()
    {

    }
    public void iniciarTurno()
    {
        String listaProlog = null;
        java.util.Hashtable solution=null;
        Query q = /*new Query("seed("+( (int) Math.random())+")");
        q.hasSolution();
        q = */new Query("baraja");
        q.hasSolution();
        q = new Query("mesa");
        q.hasSolution();
        q = new Query("cartasMesa(ListaProlog)");
        if(q.hasSolution())
        {
            solution = q.oneSolution();
            if( null != solution ){
		listaProlog = ((Term)solution.get( "ListaProlog" )).toString();
            }
        }

        cartasComunitarias = Mano.listaCartasProlog(listaProlog);

        ArrayList<Card> manoj1 = new ArrayList<Card>();

        manoj1.add(cogerCartaAleatoria());
        manoj1.add(cogerCartaAleatoria());

        jugador1.setMano(new Mano(manoj1));

        ArrayList<Card> manoj2 = new ArrayList<Card>();

        manoj2.add(cogerCartaAleatoria());
        manoj2.add(cogerCartaAleatoria());

        jugador2.setMano(new Mano(manoj2));

        if( turno % 5 == 0 )
        {
            ciegaPequena *= 2;
            ciegaGrande *= 2;
        }
        q.close();
    }

    private Card cogerCartaAleatoria()
    {
        String cartaProlog = null;
        java.util.Hashtable solution=null;

        Variable Carta = new Variable("Carta");
        Query q = new Query("cogerCartaAleatoria",new Term[] {Carta});
        if(q.hasSolution())
        {
            solution = q.oneSolution();
            if( null != solution ){
		cartaProlog = ((Term)solution.get( "Carta" )).toString();
                return new Card(cartaProlog);
            }
        }
        return new Card(Rank.R1, Suit.NOSUIT);
    }

    public boolean gana()
    {
        return true;
    }

    public void preflop()
    {
        if(jugador1.getDealer() == true)
        {
            jugador1.jugar();
            jugador2.jugar();
        }
        else
        {
            jugador2.jugar();
            jugador1.jugar();
        }
    }

    public void flop()
    {
        if(jugador1.getDealer() == true)
        {
            jugador2.jugar();
            jugador1.jugar();
        }
        else
        {
            jugador1.jugar();
            jugador2.jugar();
        }
    }

    public void turn()
    {
        if(jugador1.getDealer() == true)
        {
            jugador2.jugar();
            jugador1.jugar();
        }
        else
        {
            jugador1.jugar();
            jugador2.jugar();
        }
    }

    public void river()
    {
        if(jugador1.getDealer() == true)
        {
            jugador2.jugar();
            jugador1.jugar();
        }
        else
        {
            jugador1.jugar();
            jugador2.jugar();
        }
    }

    public ArrayList<Card> getCartasComunitarias()
    {
        return cartasComunitarias;
    }


}
