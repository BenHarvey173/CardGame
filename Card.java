public class Card {
    private String suit;
    private int rank;
    private int index;
    public Card(String suit, int rank, int index) {
        this.suit = suit;
        this.rank = rank;
        if (rank == 14) {
            this.rank = 1;
        }
        this.index = index;
    }
    public String getSuit() {
        return suit;
    }
    public int getRank() {
        if(rank == 1) {
            return 14;
        }
        return rank;
    }
    public String getRankString() {
        if(rank == 1 || rank == 14) {
            return "A";
        } else if (rank == 13) {
            return "K";
        } else if (rank == 12) {
            return "Q";
        } else if (rank == 11) {
            return "J";
        } else if (rank == 10) {
            return "T";
        } else {
            return Integer.toString(rank);
        }
    }
    public String getSuitString() {
        if (suit.equals("spades")) {
            return "♠️";
        } else if(suit.equals("clubs")) {
            return "♣︎";
        } else if(suit.equals("hearts")) {
            return "♥︎";
        } else if(suit.equals("diamonds")) {
            return "♦︎";
        } else {
            return "l";
        }
    }
    public int getIndex() {
        return index;
    }
    
    public String toString() {
        String temp = "";
        if(rank == 1 || rank == 14) {
            temp += "A";
        } else if (rank == 13) {
            temp += "K";
        } else if (rank == 12) {
            temp += "Q";
        } else if (rank == 11) {
            temp += "J";
        } else if (rank == 10) {
            temp += "T";
        } else {
            temp += rank;
        }
        String shape = "";
        if (suit.equals("spades")) {
            shape = "♠️";
        } else if(suit.equals("clubs")) {
            shape = "♣︎";
        } else if(suit.equals("hearts")) {
            shape = "♥︎";
        } else if(suit.equals("diamonds")) {
            shape = "♦︎";
        }
        return temp + " of " + shape;
    }

}