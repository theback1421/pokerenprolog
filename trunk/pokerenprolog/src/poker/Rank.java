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
public class Rank {
    private ArrayList<String> ranklist =  new ArrayList();

    /**
     * @return the ranklist
     */
    public Rank()
    {
        this.ranklist = new ArrayList();
    }
    public Rank(ArrayList ranklist)
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

}
