
public class Game {
    public static void main(String[] args) {
        Deck newDeck = new Deck();
        System.out.println(newDeck.getCards());
        newDeck.shuffle();
        System.out.println(newDeck.getCards());
        System.out.println(newDeck.drawCard(5));


    }
}