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
        if(rank == 1) {
            return 13;
        }
        return rank;
    }
    public int getIndex() {
        return index;
    }
    public String toString() {
        String temp = "";
        if(rank == 1) {
            temp += "A";
        } else if (rank == 13) {
            temp += "K";
        } else if (rank == 12) {
            temp += "Q";
        } else if (rank == 11) {
            temp += "J";
        } else {
            temp += rank;
        }
        return temp + " of " + suit;
    }
}