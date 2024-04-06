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
                    System.out.println(cards + " " + suits[j] + " " + cards.get(i));
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
                                newIndex--;
                            }
                        }
                        index++;
                    }
                }
            }
        } else if (option.equals("rank")) {
            int index = 0;
            for (int rank = 1; rank <= 13; rank++) {
                for (int i = index; i < cards.size(); i++) {
                    System.out.println(cards + " " + rank + " " + cards.get(index));
                    if(cards.get(index).getRank() == (rank)) {
                        Card temp = new Card(cards.get(index).getSuit(), cards.get(index).getRank(), cards.get(index).getIndex());
                        cards.set(index, new Card(cards.get(i).getSuit(), cards.get(i).getRank(), cards.get(i).getIndex()));
                        cards.set(i, temp); 
                        int newIndex = index;
                        while (newIndex > 0) {
                            int suit1 = 0;
                            int suit2 = 0;
                            for(int suit = 0; suit < 4; suit++) {
                                if(cards.get(newIndex).getSuit().equals(suits[suit])) {
                                    suit1 = suit;
                                }
                                if(cards.get(newIndex - 1).getSuit().equals(suits[suit])) {
                                    suit2 = suit;
                                }
                            }
                            if (suit1 < suit2 && cards.get(newIndex).getRank() == cards.get(newIndex - 1).getRank()) {
                                temp = new Card(cards.get(newIndex - 1).getSuit(), cards.get(newIndex - 1).getRank(), cards.get(newIndex - 1).getIndex());
                                cards.set(newIndex - 1, new Card(cards.get(newIndex).getSuit(), cards.get(newIndex).getRank(), cards.get(newIndex).getIndex()));
                                cards.set(newIndex, temp);
                                newIndex--;
                            }
                        }
                    }
                    
                }
            }           
        }
    }
}