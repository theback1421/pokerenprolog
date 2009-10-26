/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

/**
 *
 * @author USUARIO
 */
public class Card {
    private Rank rank = new Rank();
    private Suit suit = new Suit();

    public Card()
    {
        this.rank=new Rank();
        this.suit=new Suit();
    }
    public Card(Rank rank, Suit suit)
    {
        this.rank=rank;
        this.suit=suit;
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
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }


}
