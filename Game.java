
public class Game {
    public static void main(String[] args) {
        HoldEm pokey = new HoldEm(new Deck(), 3);
        //System.out.println(pokey.getHand(0));
        pokey.drawRiver();
        //System.out.println(pokey.getHand(0));
        pokey.drawRiver();
        //System.out.println(pokey.getHand(0));
        pokey.drawRiver();
        pokey.drawRiver();
        
        //System.out.println(pokey.getHand(0));
        pokey.scoreHands();


    }
}