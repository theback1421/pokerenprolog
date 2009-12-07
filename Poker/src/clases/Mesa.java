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
    private int turno=0;
    private int ciegaPequena = 25;
    private int ciegaGrande = 100;
    private int bote;
    private int numCartasAleatorias = 100;

    public Mesa()
    {
        turno = 1;
        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        cartasComunitarias = null;
        ronda = Ronda.PREFLOP;
    }

    public Mesa(Mesa m)
    {
        jugador1 = m.getJugador1();
        jugador2 = m.getJugador2();
        cartasComunitarias = m.getCartasComunitarias();
        ronda = m.getRonda();
        turno = m.getTurno();
        ciegaPequena = m.getCiegaPequena();
        ciegaGrande = m.getCiegaGrande();
        bote = m.getBote();
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

    public Mesa copiaMesa()
    {
        Jugador j1 = new Jugador(jugador1);
        j1.setMano(new Mano());
        Jugador j2 = new Jugador(jugador2);
        j2.setMano(new Mano());
        ArrayList<Card> cartasCom2 = new ArrayList<Card>();
        if(ronda == Ronda.FLOP)
        {
            cartasCom2.add(cartasComunitarias.get(0));
            cartasCom2.add(cartasComunitarias.get(1));
            cartasCom2.add(cartasComunitarias.get(2));
        }
        else if(ronda == Ronda.TURN)
        {
            cartasCom2.add(cartasComunitarias.get(0));
            cartasCom2.add(cartasComunitarias.get(1));
            cartasCom2.add(cartasComunitarias.get(2));
            cartasCom2.add(cartasComunitarias.get(3));
        }
        else if(ronda == Ronda.RIVER)
        {
            cartasCom2.add(cartasComunitarias.get(0));
            cartasCom2.add(cartasComunitarias.get(1));
            cartasCom2.add(cartasComunitarias.get(2));
            cartasCom2.add(cartasComunitarias.get(3));
            cartasCom2.add(cartasComunitarias.get(4));
        }

        return new Mesa(j1,j2,cartasCom2);
    }

    public Mesa(Jugador j1, Jugador j2){
        turno = 1;
        jugador1 = j1;
        jugador1.setDealer();
        jugador2 = j2;
        jugador2.unsetDealer();

        cartasComunitarias = null;
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

        turno++;

        if( turno % 5 == 0 )
        {
            setCiegaPequena(getCiegaPequena() * 2);
                  setCiegaGrande(getCiegaGrande() * 2);
        }
        q.close();

        ronda = Ronda.PREFLOP;
    }

    static public ArrayList<Card> cogerCartasAleatorias(int numCartas)
    {
        ArrayList<Card> res = new ArrayList<Card>();
        for(int i=0; i<numCartas; i++) res.add(cogerCartaAleatoria());

        return res;
    }

    static private Card cogerCartaAleatoria()
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

            Query q = new Query("evaluar_mano("+j.getNombre()+", "+Mano.arrayCartasProlog(j.getMano().getListacartas())+", "+Mano.arrayCartasProlog(cartasComunitarias)+")");
            System.out.println(q.toString());
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

    public boolean finApuestas()
    {
        if(jugador1.getOpcion() == Opcion.FOLD 
                || jugador2.getOpcion() == Opcion.FOLD
                || (jugador1.getOpcion() == Opcion.CHECK && jugador2.getOpcion() == Opcion.CHECK)
                || jugador1.getOpcion() == Opcion.ALLIN
                || jugador2.getOpcion() == Opcion.ALLIN) return true;
        else return false;
    }


    public void jugar()
    {
        jugador1.jugar(copiaMesa(), numCartasAleatorias);
        jugador2.jugar(copiaMesa(), numCartasAleatorias);
        //if(finApuestas()) siguienteRonda();
        siguienteRonda();
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
        return true;}

    private int getTurno() {
        return turno;
    }

    public int getCiegaPequena() {
        return ciegaPequena;
    }

    public int getCiegaGrande() {
        return ciegaGrande;
    }

    public int getBote() {
        return bote;
    }

    private void siguienteRonda() {
        if(ronda == Ronda.PREFLOP) ronda = Ronda.FLOP;
        else if(ronda == Ronda.FLOP) ronda = Ronda.TURN;
        else if(ronda == Ronda.TURN) ronda = Ronda.RIVER;
        else ronda = Ronda.PREFLOP;
    }

    /**
     * @param ciegaPequena the ciegaPequena to set
     */
    public void setCiegaPequena(int ciegaPequena) {
        this.ciegaPequena = ciegaPequena;
    }

    /**
     * @param ciegaGrande the ciegaGrande to set
     */
    public void setCiegaGrande(int ciegaGrande) {
        this.ciegaGrande = ciegaGrande;
    }

    /**
     * @param bote the bote to set
     */
    public void setBote(int bote) {
        this.bote = bote;
    }


}
