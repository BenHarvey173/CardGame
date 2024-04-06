import java.util.ArrayList;
public class Hand {
    private ArrayList<Card> cards;
    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }
    public void addCard(Card card) {
        cards.add(card);
    }
    public String toString() {
        return cards.toString();
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public void sortHand(String option) {
        String[] suits = {"spades", "clubs", "hearts", "diamonds"};
        if(option.equals("suit")) {
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
                            if(cards.get(newIndex).getRank() < cards.get(newIndex - 1).getRank() && cards.get(newIndex).getSuit().equals(cards.get(newIndex - 1).getSuit())) {
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
            // System.out.println(cards);
            for (int i = 1; i < cards.size(); i++) {
                // System.out.println(cards + " " + cards.get(i));
                int newIndex = i;
                while (newIndex > 0) {
                    if (cards.get(newIndex).getRank() < cards.get(newIndex - 1).getRank()) {
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