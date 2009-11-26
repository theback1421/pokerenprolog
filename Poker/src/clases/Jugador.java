/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

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

}