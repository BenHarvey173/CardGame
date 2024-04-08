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
    public Hand scoreHands() {
        double[] scores = new double[hands.length];
        double max = hands[0].scoreHand();
        Hand winner = hands[0];
        for (int i = 0; i < hands.length; i++) {
            System.out.print(hands[i] + ": ");
            System.out.println(hands[i].scoreHand());
            scores[i] = hands[i].scoreHand();
            hands[i].sortHand();
            if(scores[i] > max) {
                max = scores[i];
                winner = hands[i];
            }
        }
        System.out.println("Winner: " + winner);
        return winner;
    }
}