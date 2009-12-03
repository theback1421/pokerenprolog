/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Ramon
 */
class Jugada {
    private Opcion op;
    private int apuesta;

    public Jugada()
    {
        
    }

    public Jugada(Opcion op1, int apuesta1)
    {
        op = op1;
        apuesta = apuesta1;
    }

    /**
     * @return the op
     */
    public Opcion getOp() {
        return op;
    }

    /**
     * @param op the op to set
     */
    public void setOp(Opcion op) {
        this.op = op;
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

}
