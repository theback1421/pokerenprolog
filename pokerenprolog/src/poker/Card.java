/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;
import jpl.*;
import java.util.*;
import java.lang.*;

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
        card.replaceAll("[()]", "");
        String[] cartas = card.split(",");
        PRank r=null;
        PSuit s=null;
        this.rank = r.stringToRank(cartas[0]);
        this.suit = s.stringToSuit(cartas[1]);
    }
    public void printCard()
    {
        System.out.print("Carta: ");
        switch(rank)
        {
            case R1: System.out.print("1 de ");
            case R2: System.out.print("2 de ");
            case R3: System.out.print("3 de ");
            case R4: System.out.print("4 de ");
            case R5: System.out.print("5 de ");
            case R6: System.out.print("6 de ");
            case R7: System.out.print("7 de ");
            case R8: System.out.print("8 de ");
            case R9: System.out.print("9 de ");
            case R10: System.out.print("10 de ");
            case JACK: System.out.print("J de ");
            case QUEEN: System.out.print("Q de ");
            case KING: System.out.print("K de ");
            case ACE: System.out.print("As de ");
        }
        switch(suit)
        {
            case SPADES: System.out.print("picas\n");
            case CLUBS: System.out.print("treboles\n");
            case HEARTS: System.out.print("corazones\n");
            case DIAMONDS: System.out.print("diamantes\n");
        }
    }

}
