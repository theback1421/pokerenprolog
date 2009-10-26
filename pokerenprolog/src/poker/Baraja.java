/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Baraja {
    private ArrayList<Card> barajalist = new ArrayList();

    public Baraja()
    {
        this.barajalist=new ArrayList();
    }

    public Baraja(ArrayList baraja)
    {
        this.barajalist=baraja;
    }
    /**
     * @return the barajalist
     */
    public ArrayList<Card> getBarajalist() {
        return barajalist;
    }

    /**
     * @param barajalist the barajalist to set
     */
    public void setBarajalist(ArrayList<Card> barajalist) {
        this.barajalist = barajalist;
    }

}
