/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;
import jpl.*;
import java.util.*;
import java.lang.*;

/**
 *
 * @author USUARIO
 */
public class Card {
    private String rank = new String();
    private String suit = new String();

    public Card()
    {
        this.rank=new String();
        this.suit=new String();
    }
    public Card(String rank, String suit)
    {
        this.rank=rank;
        this.suit=suit;
    }

    /**
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

        public void setCard(String rank, String suit)
    {  
            this.rank=rank;
            this.suit=suit;
    }


}
