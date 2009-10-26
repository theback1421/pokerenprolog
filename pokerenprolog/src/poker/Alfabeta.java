package poker;

/*import java.awt.*; 
import java.applet.Applet; 

public class alfabeta extends Applet
{
 // Inicializa variables

int[] TIRADA = new TIRADA[2]  // TIRADA[1]  es el tablero TIRADA[2] es el valor del tablero
int[] POSIBLE = new POSIBLE[2] ; int[] MinTirada = new MinTirada[2] ;
int[] MaxTirada = new MaxTirada[2] ;
int Jugada, numtir, procrece ; // variables que defiene el numero de tablero y la profundidad deseada
 
//  Procedimiento maximizacion y minimizacion recursivamente 

public void init() 
  {  numtir =  profundidad ;   
     Juego = "en Proceso"; Jugada = 0; tiro= 0;    
     while (Juego <> "en Proceso")   
         {   procrece = 1;   
             TIRADA =  Maximiza(Jugada, alfa, beta, procrece); 
             Grafica(TIRADA[1]);  Jugada = TIRADA[1] ;     
             Juego = EvaluaTerminacion(TIRADA);  } ;   
       };  

// Procedimiento para la Maximizacion   
     int  Maximiza(Jugada,alfa,beta,procrece)      
        {  alfa = -infinito;

           for ( j= 1;  j <= Njugadas ;  j=j+1 )   
             {   MaxTirada[1] = SiguienteTab(j,Jugada); POSIBLE = Minimiza(MaxTirada[1],alfa,beta,procrece); 
                 if ( beta > alfa ) alfa = beta; 
                 if alfa >= POSIBLE[2]  then TIRADA = POSIBLE   };          
         return TIRADA ;   }  


// Procedimiento para la Minimizacion 
     int  Minimiza(Jugada,alfa,beta,procrece)      
        {  procrece = procrece +1;  Poda = "enproceso" ; beta = + infinito ;
           for ( j = 1;  j <= Njugadas AND poda = "enproceso" ;  j=j+1 )   
             {  MinTirada[1] = SiguienteTab(j, Jugada);
                if ( procrece = numtir ) POSIBLEMIN[2] = Evalua(MinTirada[1])   
                     else POSIBLEMIN =  Maximiza(MinTirada[1], alfa, beta, procrece); }
                if ( MinTirada[2] <= beta  )
                         { TIRADA = POSIBLEMIN ;  beta = MinTirada[2] ;
                if (beta <= alfa)   Poda = "hecha" ; }
              }
            Return TIRADA
}

/*

// Procedimiento para la Evaluacion
     int  Evalua(Jugada)     

// Procedimiento para la Graficacion 
     int Grafica(Jugada)   

// Procedimiento para la determinacion de la siguiente jugada
     int  SiguienteTab(j, Jugada)       

} // end class Alfabeta
 */
