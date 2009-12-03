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

    public int jugar(Mesa mesa, int profundidad, int alfa, int beta, Jugada jugada)
    {
        Jugador rival = mesa.getJugador1();
        if(rival.getNombre().compareTo(nombre)==0) rival = mesa.getJugador2();

        int puntos = evaluarMano(mesa.getCartasComunitarias());
        
        if(profundidad == 0)
        {
            return puntos*jugada.getApuesta();
        }
        else
        {
            ArrayList<Opcion> opciones = opciones(rival.getApuesta(), rival.getOpcion());
            ListIterator<Opcion> it = opciones.listIterator();
            while(it.hasNext())
            {
                Opcion op = (Opcion) it.next();
                jugar(mesa,--profundidad, alfa, beta, new Jugada(op,rival.getApuesta()));
            }
        }
        return 0;
    }

    public int jugar(Mesa mesa, int profundidad)
    {
        Jugador rival = mesa.getJugador1();
        if(rival.getNombre().compareTo(nombre)==0) rival = mesa.getJugador2();

        ArrayList<Opcion> opciones = opciones(rival.getApuesta(), rival.getOpcion());
        ListIterator<Opcion> it = opciones.listIterator();
        while(it.hasNext())
        {
            Opcion op = (Opcion) it.next();
            if(op == Opcion.ALLIN)
            {
                opcion = Opcion.ALLIN;
                apuesta = dinero;
                return 1;
            }
            else if(op == Opcion.RAISE)
            {
                opcion = Opcion.CHECK;
                apuesta = rival.getApuesta();
                return 2;
            }
            else if(op == Opcion.CHECK)
            {
                opcion = Opcion.CHECK;
                apuesta = rival.getApuesta();
                return 4;
            }
            else
            {
                opcion = Opcion.CHECK;
                return 4;
            }
            
        }
            //if(!isCPU) return 0;
        //else return jugar(mesa,profundidad,999999999,-999999999,new Jugada());
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