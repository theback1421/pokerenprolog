/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

import java.util.ArrayList;


/**
 *
 * @author Ramon
 */
public class Mesa {
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Card> cartasComunitarias;
    private Ronda ronda;
    private int bote;

    public Mesa()
    {
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        cartasComunitarias = null;
        ronda = Ronda.PREFLOP;
    }

    public Mesa(Jugador j1, Jugador j2, ArrayList<Card> cartas)
    {
        jugador1 = j1;
        jugador2 = j2;
        cartasComunitarias = cartas;
        ronda = Ronda.PREFLOP;
    }

    public void preflop()
    {

    }

    public void flop()
    {

    }

    public void turn()
    {

    }

    public void river()
    {

    }


}
