/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

import java.util.*;
import jpl.*;

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


    
    public void setBaraja()
    {
        Rank r;
        Suit s;
        /*
        for(int i = 0;i<r.getRanklist().size();i++)
        {
            for(int j=0;j<s.getSuitlist().size();j++)
            {
                Card c = new Card();

                c.setCard(r.getRanklist().get(i), s.getSuitlist().get(j));
                this.barajalist.add(c);
                //System.out.println(c.getRank() + c.getSuit());
                
            }
        }

         */

    }
    public void repartirCartas()
    {
        
    }

}
