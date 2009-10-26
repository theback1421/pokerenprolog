/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

/**
 *
 * @author USUARIO
 */
public class Mano {
    private Card carta1 = new Card();
    private Card carta2 = new Card();

    public Mano()
    {
        this.carta1=new Card();
        this.carta2 = new Card();
    }
    public Mano(Card carta1,Card carta2)
    {
        this.carta1=carta1;
        this.carta2=carta2;
    }
    /**
     * @return the carta1
     */
    public Card getCarta1() {
        return carta1;
    }

    /**
     * @param carta1 the carta1 to set
     */
    public void setCarta1(Card carta1) {
        this.carta1 = carta1;
    }

    /**
     * @return the carta2
     */
    public Card getCarta2() {
        return carta2;
    }

    /**
     * @param carta2 the carta2 to set
     */
    public void setCarta2(Card carta2) {
        this.carta2 = carta2;
    }

}
