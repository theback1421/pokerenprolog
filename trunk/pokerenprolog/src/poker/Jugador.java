/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

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


    public Jugador()
    {
        this.nombre="";
        this.mano=new Mano();
    }
    public Jugador(String nombre, Mano mano)
    {
        this.nombre=nombre;
        this.mano=mano;
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
