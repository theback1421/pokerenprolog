/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Jugador {
    private String nombre;
    private Mano mano;
    private int dinero;
    private int apuesta;
    private Opcion opcion;
     private boolean isDealer;

     public Jugador(Jugador j)
     {
         nombre = j.getNombre();
         mano = new Mano(j.getMano());
         dinero = j.getDinero();
         apuesta = j.getApuesta();
         opcion = j.getOpcion();
         isDealer = j.getIsDealer();
     }


     public Jugador(String nombre)
    {
        this.nombre=nombre;
        this.mano=new Mano();
    }
    public Jugador(String nombre, Mano mano)
    {
        this.nombre=nombre;
        this.mano=mano;
    }

    public void jugar()
    {

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

    private int getDinero() {
        return dinero;
    }

    private int getApuesta() {
        return apuesta;
    }

    private Opcion getOpcion() {
        return opcion;
    }

    private boolean getIsDealer() {
        return isDealer;
    }

    void print() {
        System.out.println("Nombre: "+nombre);
        mano.print();
        System.out.print("Dinero = "+dinero+"\nApuesta = "+apuesta+"\n¿Es Dealer? := "+isDealer+"\n");
    }


}