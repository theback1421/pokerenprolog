/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

import java.util.ArrayList;
import jpl.Query;

/**
 *
 * @author USUARIO
 */

public enum Suit{ NOSUIT, SPADES, CLUBS, HEARTS, DIAMONDS};

class PSuit
{
    public String suitToString(Suit s)
    {
        switch(s)
        {
            case SPADES: return "spades";
            case CLUBS: return "clubs";
            case HEARTS: return "hearts";
            case DIAMONDS: return "diamonds";
            default: return "";
        }
    }

    public Suit stringToSuit(String s)
    {
        if(s.compareTo("spades")==0) return Suit.SPADES;
        else if(s.compareTo("clubs")==0) return Suit.CLUBS;
        else if(s.compareTo("hearts")==0) return Suit.HEARTS;
        else if(s.compareTo("diamonds")==0) return Suit.DIAMONDS;
        else return Suit.NOSUIT;
    }
}