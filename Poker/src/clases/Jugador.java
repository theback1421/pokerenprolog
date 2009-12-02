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
     }


     public Jugador(String nombre)
    {
        this.nombre=nombre;
        this.mano=new Mano();
        this.opcion = Opcion.CHECK;
    }
    public Jugador(String nombre, Mano mano)
    {
        this.nombre=nombre;
        this.mano=mano;
        this.opcion = Opcion.CHECK;
    }

    public void jugar()
    {
        opcion = Opcion.CHECK;
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

    void print() {
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
     * @param dinero the dinero to set
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    /**
     * @param apuesta the apuesta to set
     */
    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }


}