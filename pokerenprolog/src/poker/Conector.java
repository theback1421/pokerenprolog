/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;
import jpl.*;


/**
 *
 * @author USUARIO
 */
public class Conector {
    
    private String predicado;
    private Query consulta;

    public Conector(String t, Query q)
    {
        this.predicado=t;
        this.consulta=q;
    }
    public Conector()
    {
        this.predicado="";
        this.consulta=null;
    }
    
 

    /**
     * @return the predicado
     */
    public String getPredicado() {
        return predicado;
    }

    /**
     * @param predicado the predicado to set
     */
    public void setPredicado(String predicado) {
        this.predicado = predicado;
    }

    /**
     * @return the consulta
     */
    public Query getConsulta() {
        return consulta;
    }

    /**
     * @param consulta the consulta to set
     */
    public void setConsulta(Query consulta) {
        this.consulta = consulta;
    }
    
    Conector getConector(){
        Conector c = new Conector();
        String t1 = "consult('poker.pl')";
        Query q1 = new Query(t1);
        c.setPredicado(t1);
        c.setConsulta(q1);
        System.out.println( t1 + " " + (q1.hasSolution() ?
        "succeeded" : "failed") );
        return c;
    }

}
