/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

/**
 *
 * @author USUARIO
 */
public class Apuesta {
    private int apuesta;

    public Apuesta()
    {
        this.apuesta=0;
    }

    public Apuesta(int apuesta)
    {
        this.apuesta=apuesta;
    }


    /**
     * @return the apuesta
     */
    public int getApuesta() {
        return apuesta;
    }

    /**
     * @param apuesta the apuesta to set
     */
    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public boolean validarApuesta()
    {
        boolean res=false;
        if (this.getApuesta()>=0)
        {
            res=true;
        }
        return res;
    }

}
