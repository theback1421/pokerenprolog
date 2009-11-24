/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

import java.util.*;
import jpl.Atom;
import jpl.Query;
import jpl.Term;
import jpl.Variable;

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

    public void print()
    {
        ListIterator it = listacartas.listIterator();
        while(it.hasNext())
        {
            ((Card) it.next()).printCard();
        }
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

    private String arrayCartasProlog()
    {
        ListIterator<Card> it = listacartas.listIterator();
        String res = "[";
        Card c;
        boolean primeraCarta = true;
        while(it.hasNext())
        {
            if(!primeraCarta) res = res+",";
            c = it.next();
            res = res+"card("+c.getStringRank()+","+c.getStringSuit()+")";
            primeraCarta = false;
        }
        res = res+"]";

        return res;
    }

    public void listaCartasProlog(String listaProlog)
    {
        listaProlog = listaProlog.replace("[", "");
        listaProlog = listaProlog.replace("]", "");
        listacartas = new ArrayList<Card>();
        
        System.out.println(listaProlog);
        String[] cartas = listaProlog.split(",card");
        for(int i=0; i<cartas.length; i++)
        {
            cartas[i] = cartas[i].replace("card", "");
            System.out.println(cartas[i]);
            listacartas.add(new Card(cartas[i]));
        }
    }
    
    public int valorCartaMasAlta()
    {
        String res="-1";
        Query q = new Query("highestHand("+arrayCartasProlog()+",Result)");
        System.out.println("highestHand("+arrayCartasProlog()+",Result)   "+q.hasSolution());
        java.util.Hashtable solution =	q.oneSolution();
        if( null != solution ){
		res = ((Term)solution.get( "Result" )).toString();
	    }
        q.close();
        return Integer.parseInt(res);
    }
    public Rank Pareja()
    {
        String res = "";
        Query q = new Query("one_pair("+arrayCartasProlog()+", ListaProlog, Rank)");
        java.util.Hashtable solution =	q.oneSolution();
        if( null != solution ){
		res = ((Term)solution.get( "Rank" )).toString();
	    }
        //return
        q.close();
        return Rank.ACE;
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
