
public class Game {
    public static void main(String[] args) {
        HoldEm pokey = new HoldEm(new Deck(), 3);
        //System.out.println(pokey.getHand(0));
        pokey.drawRiver();
        //System.out.println(pokey.getHand(0));
        pokey.drawRiver();
        //System.out.println(pokey.getHand(0));
        pokey.drawRiver();
        //System.out.println(pokey.getHand(0));

        System.out.println(pokey.getHand(1));
        pokey.getHand(1).sortHand("suit");
        System.out.println(pokey.getHand(1));
        pokey.getHand(1).sortHand("rank");
        System.out.println(pokey.getHand(1));


    }
}