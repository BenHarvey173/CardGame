// import java.util.ArrayList;
public class HoldEm {
    private Deck deck;
    private Hand[] hands;
    public HoldEm(int players) {
        deck = new Deck();
        deck.shuffle();
        hands = new Hand[players];
        for (int i = 0; i < hands.length; i++) {
            
            hands[i] = new Hand(deck.drawCards(1), "rank");
        } 
        for(Hand hand : hands) {
            if (hand == null) {
                continue;
            }
            hand.addCard(deck.drawCard());
        }
    }
    public Card drawRiver() {
        Card drawn = deck.drawCard();
        for (Hand hand : hands) {
            if (hand == null) {
                continue;
            }
            hand.addCard(drawn);
        }
        return drawn;
    }
    public Hand getHand(int player) {
        return hands[player];
    }
    public void removeHand(int index) {
        hands[index] = null;
    }
    public int scoreHands() {
        double[] scores = new double[hands.length];
        double max = 0.0;
        int m = 0;
        Hand winner = null;
        for (int i = 0; i < hands.length; i++) {
            if (hands[i] == null) {
                continue;
            }
            Hand temp = hands[i].scoreBestHand();
            System.out.print(temp + ": ");
            System.out.print(temp.handType() + ", ");
            System.out.println(temp.scorePokerHand());
            scores[i] = temp.scorePokerHand();
            hands[i].sortHand();
            if(scores[i] > max) {
                max = scores[i];
                winner = temp;
                m = i;
            }
            System.out.println("///////////////////////////////////////");
        }
        System.out.print("Winner: " + winner);
        System.out.println(": " + winner.handType());
        return m;
    }
}