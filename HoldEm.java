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
            hand.addCard(deck.drawCard());
        }
    }
    public Card drawRiver() {
        int len = hands[0].getCards().size() - 2;
        
        if(len < 5) {
            Card drawn = deck.drawCard();
            for (Hand hand : hands) {
                hand.addCard(drawn);
            }
            return drawn;
        }
        return null;
    }
    public Hand getHand(int player) {
        return hands[player];
    }
    public Hand scoreHands() {
        double[] scores = new double[hands.length];
        double max = 0.0;
        Hand winner = hands[0];
        for (int i = 0; i < hands.length; i++) {
            Hand temp = hands[i].scoreBestHand();
            System.out.print(temp + ": ");
            System.out.print(temp.handType() + ", ");
            System.out.println(temp.scorePokerHand());
            scores[i] = temp.scorePokerHand();
            hands[i].sortHand();
            if(scores[i] > max) {
                max = scores[i];
                winner = temp;
            }
            System.out.println("///////////////////////////////////////");
        }
        System.out.print("Winner: " + winner);
        System.out.println(": " + winner.handType());
        return winner;
    }
}