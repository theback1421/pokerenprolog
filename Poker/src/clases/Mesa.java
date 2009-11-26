/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.util.ArrayList;
import jpl.Query;


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
        jugador1 = new Jugador("");
        jugador2 = new Jugador("");
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

    private void baraja()
    {

    }
    public void iniciarTurno()
    {
        String listaProlog = null;
        Query q = new Query("mesa");
        q = new Query("cartasMesa(ListaProlog)");
        java.util.Hashtable solution = q.oneSolution();
        /*if( null != solution ){
		listaProlog = ((Term)solution.get( "ListaProlog" )).toString();
	}
        q.close();

        cartasComunitarias = Mano.listaCartasProlog(listaProlog);
*/
        if( turno % 5 == 0 )
        {
            ciegaPequena *= 2;
            ciegaGrande *= 2;
        }
        jugador1.setMano(new Mano());
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
