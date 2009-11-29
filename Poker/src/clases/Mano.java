/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public Mano(Mano mano) {
        listacartas = mano.getListacartas();
    }

    public void print()
    {
        if(listacartas != null)
        {
            ListIterator it = listacartas.listIterator();
            while(it.hasNext())
            {
                ((Card) it.next()).printCard();
            }
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

    static public String arrayCartasProlog(ArrayList<Card> lista)
    {
        ListIterator<Card> it = lista.listIterator();
        String res = "[";
        Card c;
        boolean primeraCarta = true;
        while(it.hasNext())
        {
            if(!primeraCarta) res = res+", ";
            c = it.next();
            res = res+"card("+c.getStringRank()+", "+c.getStringSuit()+")";
            primeraCarta = false;
        }
        res = res+"]";

        return res;
    }

    static public ArrayList<Card> listaCartasProlog(String listaProlog)
    {
        ArrayList<Card> res = new ArrayList<Card>();

        Pattern p = Pattern.compile("(ace|king|queen|jack|[2-9]|10), (clubs|spades|diamonds|hearts)");
        Matcher m = p.matcher(listaProlog);

        while(m.find())
            res.add(new Card(m.group()));

        return res;
    }

    public int valorCartaMasAlta()
    {
        String res="-1";
        Query q = new Query("highestHand("+arrayCartasProlog(listacartas)+",Result)");
        System.out.println("highestHand("+arrayCartasProlog(listacartas)+",Result)   "+q.hasSolution());

        java.util.Hashtable solution =	q.oneSolution();
        if( null != solution ){
		res = ((Term)solution.get( "Result" )).toString();
	    }
        q.close();
        System.out.println(q.toString()+"      "+res);
        return Integer.parseInt(res);
    }
    public ArrayList<Card> Pareja()
    {
        ArrayList<Card> pareja = new ArrayList<Card>();

        String listaProlog;

        Query q = new Query("one_pair("+arrayCartasProlog(listacartas)+", ListaProlog, Rank)");
        java.util.Hashtable solution =	q.oneSolution();
        q.close();
        if( null != solution ){
            listaProlog = ((Term)solution.get("ListaProlog")).toString();
            System.out.println(listaProlog);
            pareja = listaCartasProlog(listaProlog);
        }
        return pareja;
    }

    public ArrayList<Card> Trio()
    {
        ArrayList<Card> trio = new ArrayList<Card>();

        String listaProlog;

        Query q = new Query("three_of_a_kind("+arrayCartasProlog(listacartas)+", ListaProlog)");
        java.util.Hashtable solution =	q.oneSolution();
        q.close();
        if( null != solution ){
            listaProlog = ((Term)solution.get("ListaProlog")).toString();
            System.out.println(listaProlog);
            trio = listaCartasProlog(listaProlog);
        }
        return trio;
    }

}