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
public class Suit {
    private ArrayList<String> suitlist =  new ArrayList();

    /**
     * @return the suitlist
     */
    public ArrayList<String> getSuitlist() {
        return suitlist;
    }

    /**
     * @param suitlist the suitlist to set
     */
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

}
