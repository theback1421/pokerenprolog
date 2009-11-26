/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.util.ArrayList;
import jpl.Query;

/**
 *
 * @author USUARIO
 */

public enum Suit{NOSUIT, SPADES, CLUBS, HEARTS, DIAMONDS};



class PSuit
{
    static public String suitToString(Suit r)
    {
        switch(r)
        {
            case SPADES: return "spades";
            case CLUBS: return "clubs";
            case HEARTS: return "hearts";
            case DIAMONDS: return "diamonds";
            default: return "";
        }
    }

    static public String suitToStringNumber(Suit r)
    {
        switch(r)
        {
            case SPADES: return "1";
            case CLUBS: return "2";
            case HEARTS: return "4";
            case DIAMONDS: return "3";
            default: return "";
        }
    }






    static public Suit stringToSuit(String s)
    {
        if(s.compareTo("spades")==0) return Suit.SPADES;
        else if(s.compareTo("clubs")==0) return Suit.CLUBS;
        else if(s.compareTo("hearts")==0) return Suit.HEARTS;
        else if(s.compareTo("diamonds")==0) return Suit.DIAMONDS;
        else return Suit.NOSUIT;
    }
}











/*
public class Suit {
    private ArrayList<String> suitlist =  new ArrayList();

    /**
     * @return the suitlist
     *//*
    public ArrayList<String> getSuitlist() {
        return suitlist;
    }

    /**
     * @param suitlist the suitlist to set
     *//*
    public void setSuitlist(ArrayList<String> suitlist) {
        this.suitlist = suitlist;
    }

    public void setSuit()
    {

        Query q1 = new Query("suit(S)");
        java.util.Hashtable[] ss4 = q1.allSolutions();
        System.out.println( "all solutions of " + "suit(S)");
        for ( int i=0 ; i<ss4.length ; i++ )
        {
            this.suitlist.add(ss4[i].toString());
        }
        System.out.println("Suitlist: " + this.suitlist.toString());
    }

     /*
     * Rellenar suit
     * Leemos del prolog y rellenamos la lista con los ranks del poker.pl
     */
/*
}
*/