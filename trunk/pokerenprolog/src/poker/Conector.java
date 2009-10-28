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
    
    private String consulta;
    public Conector(String t)
    {
        this.consulta=t;
    }
    public Conector()
    {
        this.consulta="";
    }

    /**
     * @return the consulta
     */
    public String getConsulta() {
        return consulta;
    }

    /**
     * @param consulta the consulta to set
     */
    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }
    
    String getConector(){
        String t1 = "consult('poker.pl')";
        Query q1 = new Query(t1);
        System.out.println( t1 + " " + (q1.hasSolution() ?
        "succeeded" : "failed") );
        return t1;
    }

}
