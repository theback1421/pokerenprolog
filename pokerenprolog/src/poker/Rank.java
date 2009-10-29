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
public class Rank {
    private ArrayList<String> ranklist =  new ArrayList<String>();

    /**
     * @return the ranklist
     */
    public Rank()
    {
        this.ranklist = new ArrayList<String>();
    }
    public Rank(ArrayList<String> ranklist)
    {
        this.ranklist=ranklist;
    }

    public ArrayList<String> getRanklist() {
        return ranklist;
    }

    /**
     * @param ranklist the ranklist to set
     */
    public void setRanklist(ArrayList<String> ranklist) {
        this.ranklist = ranklist;
    }
    /*
     * Rellenar rangos
     * Leemos del prolog y rellenamos la lista con los ranks del poker.pl
     */
    public void setRank()
    {
        
        Query q1 = new Query("rank(R)");
        java.util.Hashtable[] ss4 = q1.allSolutions();
        System.out.println( "all solutions of " + "rank(R)");
        for ( int i=0 ; i<ss4.length ; i++ )
        {
            this.ranklist.add(ss4[i].toString());
        }
        System.out.println("Ranklist: " + this.ranklist.toString());
    }

}
