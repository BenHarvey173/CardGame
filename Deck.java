import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    public Deck() {
        String[] suits = {"spades", "clubs", "hearts", "diamonds"};
        int index = 0;
        for(String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(suit, i, index));
                index++;
            }
        }
    }
    public Deck(int count) {
        String[] suits = {"spades", "clubs", "hearts", "diamonds"};
        for(int c = 0; c < count; c++) {
            int index = 0;
            for(String suit : suits) {
                for (int i = 1; i <= 13; i++) {
                    cards.add(new Card(suit, i, index));
                    index++;
                }
            }
        }
    }
     public void shuffle() {
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
    public Card drawCard() {
        return cards.remove(cards.size() - 1);
    }
    public ArrayList<Card> drawCards(int count) {
        ArrayList<Card> drawnCards = new ArrayList<Card>();
        for(int i = 0; i < count; i++) {
            drawnCards.add(drawCard());
        }
        return drawnCards;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
}