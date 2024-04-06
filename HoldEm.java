// import java.util.ArrayList;
public class HoldEm {
    private Deck deck;
    private Hand[] hands;
    public HoldEm(Deck givenDeck, int players) {
        deck = givenDeck;
        deck.shuffle();
        hands = new Hand[players];
        for (int i = 0; i < hands.length; i++) {
            hands[i] = new Hand(deck.drawCard(2), "rank");
        }
    }
    public void drawRiver() {
        int len = hands[0].getCards().size() - 2;
        if(len < 3) {
            for (Hand hand : hands) {
                hand.addCard(deck.drawCard());
            }
        }
    }
    public Hand getHand(int player) {
        return hands[player];
    }
    public void scoreHands() {
        for (Hand hand : hands) {
            System.out.print(hand + ": ");
            System.out.println(hand.scoreHand());
            hand.sortHand();
        }
    }
}