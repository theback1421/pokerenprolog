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

    public void iniciarTurno()
    {
        Query q = new Query("baraja");
        q.hasSolution();
        
        cartasComunitarias = cogerCartasAleatorias(5);

        jugador1.setMano(new Mano(cogerCartasAleatorias(2)));

        jugador2.setMano(new Mano(cogerCartasAleatorias(2)));

        if( turno % 5 == 0 )
        {
            ciegaPequena *= 2;
            ciegaGrande *= 2;
        }
        q.close();

        ronda = Ronda.FLOP;
    }

    public ArrayList<Card> cogerCartasAleatorias(int numCartas)
    {
        ArrayList<Card> res = new ArrayList<Card>();
        for(int i=0; i<numCartas; i++) res.add(cogerCartaAleatoria());

        return res;
    }

    private Card cogerCartaAleatoria()
    {
        String cartaProlog = null;
        String slongitud = null;
        int longitud=0;
        java.util.Hashtable solution=null;

        Variable L = new Variable("L");
        Query q = new Query("longitud",new Term[] {L});
        solution = q.oneSolution();
        if( null != solution ){
            slongitud = ((Term)solution.get( "L" )).toString();
            longitud = Integer.parseInt(slongitud);
        }
        int numAleatorio = (int) (Math.random()*0.9999999*(double)(longitud));

        solution = q.oneSolution("cogerCartaAleatoria("+numAleatorio+",Carta)");
        if( null != solution ){
            cartaProlog = ((Term)solution.get( "Carta" )).toString();
            return new Card(cartaProlog);
        }
        return new Card(Rank.R1, Suit.NOSUIT);
    }

    public ArrayList<Puntuacion> puntuacionJugadores()
    {
        ArrayList<Puntuacion> puntuaciones = new ArrayList<Puntuacion>();

        Jugador j;
        java.util.Hashtable solution=null;
        int puntos=0;

        for(int i=0; i<2; i++)
        {
            if(i==0) j = jugador1;
            else j = jugador2;

            ArrayList<Card> lista;

            lista = new ArrayList<Card>();
            lista.addAll(cartasComunitarias);
            lista.addAll(j.getMano().getListacartas());
            Query q = new Query("evaluar_mano("+j.getNombre()+", "+Mano.arrayCartasProlog(lista)+")");
            q.hasSolution();
            q = new Query("puntosJugador("+j.getNombre()+", Puntos, Jugada)");
            solution = q.oneSolution();
            if( null != solution ){
                puntos = Integer.parseInt(((Term)solution.get( "Puntos" )).toString());
            }
            puntuaciones.add(new Puntuacion(j.getNombre(),puntos));
        }
        return puntuaciones;
    }


    public void preflop()
    {
        if(jugador1.getDealer() == true)
        {
            //jugador1.jugar();
            jugador2.jugar();
        }
        else
        {
            jugador2.jugar();
            //jugador1.jugar();
        }

        ronda = Ronda.FLOP;
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

        ronda = Ronda.TURN;
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

        ronda = Ronda.RIVER;
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

        ronda = Ronda.FIN;
    }

    public ArrayList<Card> getCartasComunitarias()
    {
        return cartasComunitarias;
    }

    /**
     * @return the ronda
     */
    public Ronda getRonda() {
        return ronda;
    }

    public boolean ganador() {
        if(jugador1.getOpcion() == Opcion.FOLD || jugador2.getOpcion() == Opcion.FOLD ) return true;
        else return false;
    }


}
