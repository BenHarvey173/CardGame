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
}