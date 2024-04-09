import java.util.ArrayList;
public class BlackJack {
    private Deck deck;
    private Hand hand;
    public BlackJack() {
        deck = new Deck(6);
        deck.shuffle();
        ArrayList<Card> tempCards = new ArrayList<Card>();
        tempCards.add(deck.drawCards(1).get(1));
        tempCards.add(deck.drawCards(1).get(1)); // now 2 cards
        hand = new Hand(tempCards, "rank");

    }
}