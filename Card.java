public class Card {
    private String suit;
    private int rank;
    private int index;
    public Card(String suit, int rank, int index) {
        this.suit = suit;
        this.rank = rank;
        this.index = index;
    }
    public String getSuit() {
        return suit;
    }
    public int getRank() {
        return rank;
    }
    public int getIndex() {
        return index;
    }
    public String toString() {
        if(rank == 1) {
            return "Ace of " + suit;
        }
        return rank + " of " + suit;
    }
}