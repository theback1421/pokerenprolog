/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.util.ArrayList;
import java.util.ListIterator;
import jpl.Query;
import jpl.Term;

/**
 *
 * @author USUARIO
 */
public class Jugador {
    private String nombre;
    private Mano mano;
    private int dinero = 2000;
    private int apuesta;
    private int numApuesta=0;
    private Opcion opcion;
    private boolean isDealer;
    private boolean isCPU;

     public Jugador(String name, int money){
          nombre = name;
         mano = null;
         dinero = money;
         apuesta = 0;
         opcion = null;
         isDealer = false;

     }

     public Jugador(Jugador j)
     {
         nombre = j.getNombre();
         mano = new Mano(j.getMano());
         dinero = j.getDinero();
         apuesta = j.getApuesta();
         opcion = j.getOpcion();
         isDealer = j.getIsDealer();
         isCPU = j.getIsCPU();
     }



     public Jugador(String name)
    {
        this.nombre=name;
        this.mano=new Mano();
        this.opcion = Opcion.CHECK;
        this.apuesta=0;
        this.isDealer=false;
    }
    public Jugador(String nombre, Mano mano)
    {
        this.nombre=nombre;
        this.mano=mano;
        this.opcion = Opcion.CHECK;
    }

    public Jugador() {
        
    }

    public void jugar()
    {
        opcion = Opcion.CHECK;
    }

    private ArrayList<Opcion> opciones(int apuestaRival, Opcion opcionRival)
    {
        ArrayList<Opcion> result = new ArrayList<Opcion>();

        if(opcionRival == Opcion.ALLIN)
        {
            result.add(Opcion.ALLIN);
            if(apuestaRival < dinero) result.add(Opcion.CHECK);
            result.add(Opcion.FOLD);
        }
        else if(opcionRival == Opcion.CHECK)
        {
            result.add(Opcion.ALLIN);
            result.add(Opcion.CHECK);
            result.add(Opcion.FOLD);
            result.add(Opcion.RAISE);
        }
        else if(opcionRival == Opcion.FOLD)
        {
            result.add(Opcion.CHECK);
        }
        else if(opcionRival == Opcion.RAISE)
        {
            if(apuestaRival > dinero) result.add(Opcion.ALLIN);
            else
            {
                result.add(Opcion.CHECK);
                result.add(Opcion.FOLD);
                result.add(Opcion.RAISE);
            }
        }
        return result;
    }

    private int evaluarMano(ArrayList<Card> cartasComunitarias)
    {
        int puntos=0;
        ArrayList<Card> lista = new ArrayList<Card>();
        lista.addAll(cartasComunitarias);
        lista.addAll(mano.getListacartas());

        Query q = new Query("evaluar_mano("+getNombre()+", "+Mano.arrayCartasProlog(lista)+")");
        q.hasSolution();
        q = new Query("puntosJugador("+getNombre()+", Puntos, Jugada)");
        java.util.Hashtable solution = q.oneSolution();
        if( null != solution ){
            puntos = Integer.parseInt(((Term)solution.get( "Puntos" )).toString());
        }
        return puntos;
    }


    public double evaluar(Mesa mesa, int numManosAleatorias)
    {
        ArrayList<Card> cartasProhibidas = new ArrayList<Card>();
        cartasProhibidas.addAll(mesa.getCartasComunitarias());
        cartasProhibidas.addAll(mano.getListacartas());

        ArrayList<Card> cartasRivalFicticio = null;

        int resultado = 0;
        for(int i=0; i<numManosAleatorias; i++)
        {
            cartasRivalFicticio = Card.getCartasAleatorias(cartasProhibidas);
            resultado += mano.gana(new Mano(cartasRivalFicticio), new Mano(mesa.getCartasComunitarias()));
        }
        return (double)resultado/(double)numManosAleatorias;
    }

    public int jugar(Mesa mesa, int numCartasAleatorias)
    {
        if(getIsCPU() == false) return -1;
        
        Jugador rival = mesa.getJugador1();
        if(rival.getNombre().compareTo(nombre)==0) rival = mesa.getJugador2();

        numApuesta++;
        if(numApuesta == 3)
        {
                opcion = Opcion.CHECK;
                apuesta = rival.getApuesta();
                return -1;
        }

        ArrayList<Opcion> opciones = opciones(rival.getApuesta(), rival.getOpcion());
        ListIterator<Opcion> it = opciones.listIterator();
        while(it.hasNext())
        {
            Opcion op = (Opcion) it.next();
            if(rival.getOpcion() == Opcion.ALLIN)
            {
                if(evaluar(mesa,numCartasAleatorias) > 0.0)
                {
                    opcion = Opcion.ALLIN;
                    apuesta = dinero;
                }
                else
                {
                    opcion = Opcion.FOLD;
                    apuesta = 0;
                }
                return 1;
            }
            else if(rival.getOpcion() == Opcion.FOLD)
            {
                opcion = Opcion.CHECK;
                apuesta = 0;
                return 4;
            }
            else
            {
                double res = evaluar(mesa,numCartasAleatorias);
                if(res > 0.3)
                {
                    opcion = Opcion.RAISE;
                    apuesta = rival.getApuesta()+mesa.getCiegaGrande();
                }
                else if(res > 0.0)
                {
                    opcion = Opcion.CHECK;
                    apuesta = rival.getApuesta();
                }
                else
                {
                    opcion = Opcion.FOLD;
                    apuesta = 0;
                }
                return 4;
            }
           
            
        }
        return 0;
    }

    public void setDealer()
    {
        isDealer = true;
    }

    public void unsetDealer()
    {
        isDealer = false;
    }

    public boolean getDealer()
    {
        return isDealer;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the mano
     */
    public Mano getMano() {
        return mano;
    }

    /**
     * @param mano the mano to set
     */
    public void setMano(Mano mano) {
        this.mano = mano;
    }

    public int getDinero() {
        return dinero;
    }

    public int getApuesta() {
        return apuesta;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public boolean getIsDealer() {
        return isDealer;
    }

    public void print() {
        System.out.println("Nombre: "+nombre);
        mano.print();
        System.out.print("Dinero = "+dinero+"\nApuesta = "+apuesta+"\n¿Es Dealer? := "+isDealer+"\n");
    }

    /**
     * @param opcion the opcion to set
     */
    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    /**
     * @return the isCPU
     */
    public boolean getIsCPU() {
        return isCPU;
    }
    /**
     * @param dinero the dinero to set
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    /**
     * @param isCPU the isCPU to set
     */
    public void setIsCPU(boolean isCPU) {
        this.isCPU = isCPU;
    }


    /**
     * @param apuesta the apuesta to set
     */
    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }


}