import java.util.ArrayList;
public class Hand {
    private ArrayList<Card> cards;
    private String order;
    public Hand(ArrayList<Card> cards, String order) {
        this.cards = cards;
        this.order = order;
        sortHand(order);
    }
    public void addCard(Card card) {
        cards.add(card);
        sortHand(order);
    }
    public String toString() {
        return cards.toString();
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    private double scoreHigh() {
        double ret = 0.0;
        for (int i = 0; i < 5; i++) {
            ret+= cards.get(i).getRank() / (Math.pow(100, i + 1));
        }
        return ret;
    }
    public double scoreHand() {
        sortHand("rank");
        ArrayList<Integer> ranks = new ArrayList<Integer>();
        for (int i = 0; i < cards.size(); i++) {
            ranks.add(cards.get(i).getRank());
        }
        sortHand("suit");
        String handSuit = cards.get(0).getSuit();
        boolean flush = true;
        for (Card card : cards) { //check flush
            if (!card.getSuit().equals(handSuit)) {
                flush = false;
            }
        }
        sortHand("rank");
        boolean straight = true;
        for (int i = cards.size() - 2; i > 0; i--) {
            if (ranks.get(i) != ranks.get(i + 1)) {
                straight = false;
            }
        }
        if (straight) {
            if (flush) {
                if (ranks.get(1) == 12) {
                    return 10.0; // royal flush = 10
                }
                return 9 + scoreHigh(); // straight flush = 9 + tie
            }
            return 5.0 + scoreHigh(); // straight = 5 + tie
        }
        if (flush) {
            return 6 + scoreHigh(); // flush = 6 + tie
        }
        if (ranks.get(1) == ranks.get(2) && ranks.get(2) == ranks.get(3)) {
            if(ranks.get(0) == ranks.get(2) || ranks.get(4) == ranks.get(2)) {
                return 8.0; // 4 = 8
            }
        }
        if(ranks.get(2) == ranks.get(1) && ranks.get(0) == ranks.get(1)) {
            if (ranks.get(3) == ranks.get(4)) {
                return 7.0 + ranks.get(2) / 100.0; // house
            }
            return 4.0 + ranks.get(2) / 100.0 + ranks.get(0) / 10000.0 + ranks.get(1) / 1000000.0; // left 3
        }  
        if (ranks.get(2) == ranks.get(3) && ranks.get(2) == ranks.get(4)) {
            if (ranks.get(0) == ranks.get(1)) {
                return 7.0 + ranks.get(2) / 100.0;
            }
            return 4.0 + ranks.get(2) / 100.0 + ranks.get(0) / 10000.0 + ranks.get(1) / 1000000.0; // right 3
        }
        if (ranks.get(2) ==  ranks.get(1) && ranks.get(2) == ranks.get(3)) {
            return 4.0 + ranks.get(2) / 100.0 + ranks.get(0) / 10000.0 + ranks.get(4) / 1000000.0; // mid 3
        }
        for(int i = 0; i < 4; i++) {
            if (ranks.get(i) == ranks.get(i+1)) {
                if (i < 4) {
                    for (int j = i + 2; j < 4; j++) {
                        if (ranks.get(j) == ranks.get(j+1)) {
                            double ret = 3.0 + ranks.get(i) / 100.0 + ranks.get(j) / 10000.0; // 2pair
                            if (i > 0) { // ppppn
                                ret += ranks.get(0) / 1000000.0;
                            }
                            else if (i == 0 && j == 3) { // 
                                ret += ranks.get(2) / 1000000.0;
                            }
                            else {
                                ret += ranks.get(4) / 1000000.0;
                            }
                            return ret;
                        }
                    }
                }
                double ret = 2.0 + ranks.get(i) / 100.0; // 2kind = 2
                for(int j = 0; j < i; j++) {
                    ret += ranks.get(j) / Math.pow(100, i + 1);
                }
                for(int j = i + 2; j < 4; j++) {
                    ret += ranks.get(j) / Math.pow(100, i + 1);
                }
                return ret;
            }
        }
        return 1.0 + scoreHigh();
    }
    public void sortHand() {
        sortHand(order);
    }
    public void sortHand(String option) {
        String[] suits = {"spades", "clubs", "hearts", "diamonds"};
        if(option.equals("suit")) {
            order = "suit";
            int index = 0;
            for (int j = 0; j < 4; j++) {
                for (int i = index; i < cards.size(); i++) {
                    // System.out.println(cards + " " + suits[j] + " " + cards.get(i));
                    if(cards.get(i).getSuit().equals(suits[j])) {
                        Card temp = new Card(cards.get(index).getSuit(), cards.get(index).getRank(), cards.get(index).getIndex());
                        cards.set(index, new Card(cards.get(i).getSuit(), cards.get(i).getRank(), cards.get(i).getIndex()));
                        cards.set(i, temp);
                        int newIndex = index;
                        while (newIndex > 0) {
                            if(cards.get(newIndex).getRank() > cards.get(newIndex - 1).getRank() && cards.get(newIndex).getSuit().equals(cards.get(newIndex - 1).getSuit())) {
                                temp = new Card(cards.get(newIndex - 1).getSuit(), cards.get(newIndex - 1).getRank(), cards.get(newIndex - 1).getIndex());
                                cards.set(newIndex - 1, new Card(cards.get(newIndex).getSuit(), cards.get(newIndex).getRank(), cards.get(newIndex).getIndex()));
                                cards.set(newIndex, temp);
                            }
                            newIndex--;
                        }
                        index++;
                    }
                }
            }
        } else if (option.equals("rank")) {
            order = "rank";
            // System.out.println(cards);
            for (int i = 1; i < cards.size(); i++) {
                // System.out.println(cards + " " + cards.get(i));
                int newIndex = i;
                while (newIndex > 0) {
                    if (cards.get(newIndex).getRank() > cards.get(newIndex - 1).getRank()) {
                        Card temp = new Card(cards.get(newIndex - 1).getSuit(), cards.get(newIndex - 1).getRank(), cards.get(newIndex - 1).getIndex());
                        cards.set(newIndex - 1, new Card(cards.get(newIndex).getSuit(), cards.get(newIndex).getRank(), cards.get(newIndex).getIndex()));
                        cards.set(newIndex, temp);
                        newIndex--;
                    } else {
                        break;
                    }
                } // cards sorted by rank
            }
            // System.out.println(cards);
            for (int i = 1; i < cards.size(); i++) {
                // System.out.println(cards + " " + cards.get(i));
                int suit1 = 0;
                int suit2 = 0;
                int newIndex = i;
                while (newIndex > 0 && cards.get(newIndex).getRank() == cards.get(newIndex - 1).getRank()) {
                    for (int j = 0; j < 4; j++) {
                        if (cards.get(newIndex).getSuit().equals(suits[j])) {
                            suit1 = j;
                        }
                        if (cards.get(newIndex - 1).getSuit().equals(suits[j])) {
                            suit2 = j;
                        }
                    }
                    if (suit1 < suit2 && (cards.get(newIndex).getRank() == cards.get(newIndex - 1).getRank())) {
                        Card temp = new Card(cards.get(newIndex - 1).getSuit(), cards.get(newIndex - 1).getRank(), cards.get(newIndex - 1).getIndex());
                        cards.set(newIndex - 1, new Card(cards.get(newIndex).getSuit(), cards.get(newIndex).getRank(), cards.get(newIndex).getIndex()));
                        cards.set(newIndex, temp);
                        newIndex--;
                    } else {
                        break;
                    }
                }
            }
            // System.out.println(cards);
        } else if (option.equals("random")) {
            order = "random";
            // System.out.println(cards);
            ArrayList<Card> newCards = new ArrayList<Card>();
            for (int i = 0; i < cards.size(); i++) {
                newCards.add(null);
            }
            for(int i = 0; i < cards.size(); i++) {
                int index = (int) (Math.random() * cards.size());
                if(cards.get(index) != null) {
                    newCards.set(i, cards.get(index));
                    cards.set(index, null);
                } else {
                    i--;
                }
            }
            cards = newCards;
        }
    }
}