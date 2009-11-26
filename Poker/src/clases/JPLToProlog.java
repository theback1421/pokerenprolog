/*
 * This class makes use of the SWI JPL interface to prolog
 */

package clases;

import jpl.Query;
import jpl.*;

import java.util.Hashtable;
import java.io.*;




public class JPLToProlog{
    private Query query = null;
    private Hashtable argmap = null;

    public JPLToProlog(){

	try{

	    java.lang.String args[] = { "pl", "-G128M", "-L128M",
					"-T128M" };

	    JPL.setDefaultInitArgs( args );

	    if( null == argmap ){
		argmap = new Hashtable();
	    }
	    
	    query = new Query( "consult('poker.pl')." );

	    if( !query.hasSolution()){
		throw new Exception( "consult('poker.pl'): failed" );
	    }

	    query.close();
	}
	catch( java.lang.Exception e ){
	    System.err.println( "JTP:" );
	    e.printStackTrace();
	}
    }




    public void queryProlog(){
        String res = null;
	Atom value = null;

	try{ 
	    argmap.clear();
	    Variable resv = new Variable( "Value" );
	    //Variable numv = new Variable( "Rank" );
            Atom rank = new Atom("card(ace,spades)");

	    query = new Query( "highestHand", new Term[] {rank,resv} );
            query = new Query( "highestHand([card(2,spades),card(9,diamonds)],Value)");
            System.out.println(query.toString());
	    argmap = query.oneSolution();
	    if( null != argmap ){
		res = ((Term)argmap.get( "Value" )).toString();
		System.out.println( "Value: " + res );
	    }

	    query.close();

/*	    Variable numv = new Variable( "Num" );
	    value = new Atom( res );

	    query = new Query( "number", new Term[] {numv, value} );

	    System.out.print( "Numbers:" );
	    while( query.hasMoreSolutions()){
		argmap = query.nextSolution();
		System.out.print( " " + 
				  ((Term)argmap.get("Num")).toString());
	    }
	    System.out.print( "\n" );
	    query.close();*/
	}
	catch( java.lang.Exception e ){
	    System.err.println( "JTP:" );
	    e.printStackTrace();
	}
    }




    public static void  main( String args[] ){
	JPLToProlog jtp = new JPLToProlog();
	jtp.queryProlog();
    }
}

// eof
