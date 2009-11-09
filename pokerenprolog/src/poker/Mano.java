/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

import java.util.*;
import jpl.Query;

/**
 *
 * @author USUARIO
 */
public class Mano {
    private ArrayList<Card> listacartas = new ArrayList();

    public Mano()
    {
        this.listacartas=new ArrayList();
        
    }
    public Mano(ArrayList<Card> listacartas)
    {
        this.listacartas=listacartas;
    }
   

    /**
     * @return the listacartas
     */
    public ArrayList<Card> getListacartas() {
        return listacartas;
    }

    /**
     * @param listacartas the listacartas to set
     */
    public void setListacartas(ArrayList<Card> listacartas) {
        this.listacartas = listacartas;
    }

    
    public Card CogerCartaMasAlta(ArrayList<Card> listacartas)
    {
        Card carta = new Card();
        Conector c = new Conector();
        c.getConector();
        Query q = new Query("highest_card("+listacartas+")");
        q.hasSolution();
        return carta;
    }
    public boolean HayPareja(ArrayList<Card> listacartas)
    {
        boolean res = false;
        Conector c = new Conector();
        c.getConector();
        Query q = new Query("has_pair("+listacartas+")");
        res = q.hasSolution();
        return res;
    }

    public boolean HayTrio(ArrayList<Card> listacartas)
    {
        boolean res = false;
        Conector c = new Conector();
        c.getConector();
        Query q = new Query("has_three_of_a_kind("+listacartas+")");
        res = q.hasSolution();
        return res;
    }

}
