/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author USUARIO
 */
public class Card {
    private Rank rank;
    private Suit suit;

    public Card()
    {
    }
    public Card(Rank r, Suit s)
    {
        rank = r;
        suit = s;
    }

     public Card(String card)
    {
        setCard(card);
    }
    /**
     * @return the rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(Rank r) {
        this.rank = r;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    public String getStringSuit()
    {
        switch(suit)
        {
            case SPADES: return "spades";
            case CLUBS: return "clubs";
            case DIAMONDS: return "diamonds";
            case HEARTS: return "hearts";
            default: return"";
        }
    }

    public String getStringRank()
    {
        switch(rank)
        {
            case R1: return "1";
            case R2: return "2";
            case R3: return "3";
            case R4: return "4";
            case R5: return "5";
            case R6: return "6";
            case R7: return "7";
            case R8: return "8";
            case R9: return "9";
            case R10: return "10";
            case JACK: return "jack";
            case QUEEN: return "queen";
            case KING: return "king";
            case ACE: return "ace";
            default: return"";
        }
    }

    /**
     * @param suit the suit to set
     */
   public void setSuit(Suit s) {
        this.suit = s;
    }

    public void setCard(Rank r, Suit s)
    {
            this.rank=r;
            this.suit=s;
    }

    public void setCard(String card)
    {
        Pattern p = Pattern.compile("(ace|king|queen|jack|[2-9]|10)");
        Matcher m = p.matcher(card);

        if(m.find())
            this.rank = PRank.stringToRank(m.group());

        p = Pattern.compile("(clubs|spades|diamonds|hearts)");
        m = p.matcher(card);

        if(m.find())
            this.suit = PSuit.stringToSuit(m.group());
    }
    public void printCard()
    {
        System.out.print("Carta: ");
        switch(rank)
        {
            case R1: System.out.print("1 de "); break;
            case R2: System.out.print("2 de "); break;
            case R3: System.out.print("3 de "); break;
            case R4: System.out.print("4 de "); break;
            case R5: System.out.print("5 de "); break;
            case R6: System.out.print("6 de "); break;
            case R7: System.out.print("7 de "); break;
            case R8: System.out.print("8 de "); break;
            case R9: System.out.print("9 de "); break;
            case R10: System.out.print("10 de "); break;
            case JACK: System.out.print("J de "); break;
            case QUEEN: System.out.print("Q de "); break;
            case KING: System.out.print("K de "); break;
            case ACE: System.out.print("As de "); break;
        }
        switch(suit)
        {
            case SPADES: System.out.print("picas\n"); break;
            case CLUBS: System.out.print("treboles\n"); break;
            case HEARTS: System.out.print("corazones\n"); break;
            case DIAMONDS: System.out.print("diamantes\n"); break;
        }
    }

    private static int enteroAleatorio(int min, int max)
    {
        return (int)(Math.random()*0.9999999*((double)(max+1-min)))+min;
    }

    public static ArrayList<Card> getCartasAleatorias(ArrayList<Card> cartasProhibidas)
    {
        ArrayList<Card> resultado = new ArrayList<Card>();

        ArrayList<Card> baraja = new ArrayList<Card>();
        {
            baraja.add(new Card(Rank.ACE,Suit.CLUBS));
            baraja.add(new Card(Rank.ACE,Suit.SPADES));
            baraja.add(new Card(Rank.ACE,Suit.HEARTS));
            baraja.add(new Card(Rank.ACE,Suit.DIAMONDS));
            baraja.add(new Card(Rank.KING,Suit.CLUBS));
            baraja.add(new Card(Rank.KING,Suit.SPADES));
            baraja.add(new Card(Rank.KING,Suit.HEARTS));
            baraja.add(new Card(Rank.KING,Suit.DIAMONDS));
            baraja.add(new Card(Rank.QUEEN,Suit.CLUBS));
            baraja.add(new Card(Rank.QUEEN,Suit.SPADES));
            baraja.add(new Card(Rank.QUEEN,Suit.HEARTS));
            baraja.add(new Card(Rank.QUEEN,Suit.DIAMONDS));
            baraja.add(new Card(Rank.JACK,Suit.CLUBS));
            baraja.add(new Card(Rank.JACK,Suit.SPADES));
            baraja.add(new Card(Rank.JACK,Suit.HEARTS));
            baraja.add(new Card(Rank.JACK,Suit.DIAMONDS));
            baraja.add(new Card(Rank.R10,Suit.CLUBS));
            baraja.add(new Card(Rank.R10,Suit.SPADES));
            baraja.add(new Card(Rank.R10,Suit.HEARTS));
            baraja.add(new Card(Rank.R10,Suit.DIAMONDS));
            baraja.add(new Card(Rank.R9,Suit.CLUBS));
            baraja.add(new Card(Rank.R9,Suit.SPADES));
            baraja.add(new Card(Rank.R9,Suit.HEARTS));
            baraja.add(new Card(Rank.R9,Suit.DIAMONDS));
            baraja.add(new Card(Rank.R8,Suit.CLUBS));
            baraja.add(new Card(Rank.R8,Suit.SPADES));
            baraja.add(new Card(Rank.R8,Suit.HEARTS));
            baraja.add(new Card(Rank.R8,Suit.DIAMONDS));
            baraja.add(new Card(Rank.R7,Suit.CLUBS));
            baraja.add(new Card(Rank.R7,Suit.SPADES));
            baraja.add(new Card(Rank.R7,Suit.HEARTS));
            baraja.add(new Card(Rank.R7,Suit.DIAMONDS));
            baraja.add(new Card(Rank.R6,Suit.CLUBS));
            baraja.add(new Card(Rank.R6,Suit.SPADES));
            baraja.add(new Card(Rank.R6,Suit.HEARTS));
            baraja.add(new Card(Rank.R6,Suit.DIAMONDS));
            baraja.add(new Card(Rank.R5,Suit.CLUBS));
            baraja.add(new Card(Rank.R5,Suit.SPADES));
            baraja.add(new Card(Rank.R5,Suit.HEARTS));
            baraja.add(new Card(Rank.R5,Suit.DIAMONDS));
            baraja.add(new Card(Rank.R4,Suit.CLUBS));
            baraja.add(new Card(Rank.R4,Suit.SPADES));
            baraja.add(new Card(Rank.R4,Suit.HEARTS));
            baraja.add(new Card(Rank.R4,Suit.DIAMONDS));
            baraja.add(new Card(Rank.R3,Suit.CLUBS));
            baraja.add(new Card(Rank.R3,Suit.SPADES));
            baraja.add(new Card(Rank.R3,Suit.HEARTS));
            baraja.add(new Card(Rank.R3,Suit.DIAMONDS));
            baraja.add(new Card(Rank.R2,Suit.CLUBS));
            baraja.add(new Card(Rank.R2,Suit.SPADES));
            baraja.add(new Card(Rank.R2,Suit.HEARTS));
            baraja.add(new Card(Rank.R2,Suit.DIAMONDS));
        }

        ListIterator it = cartasProhibidas.listIterator();
        while(it.hasNext())
        {
            Card c = (Card)it.next();
            baraja.remove(c);
        }
        
        int i;
        for(int j=0; j<2; j++)
        {
            i = enteroAleatorio(0,baraja.size()-1);
            resultado.add(baraja.get(i));
            baraja.remove(i);
        }

        return resultado;
    }

}
