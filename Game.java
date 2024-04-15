
public class Game {
    public static void playHoldEm(int players) {
        HoldEm holdEm = new HoldEm(players);
        for(int i = 0; i < players; i++) {
            System.out.print(holdEm.getHand(i));
        }
        System.out.println("");
        System.out.println(holdEm.drawRiver());
        System.out.println(holdEm.drawRiver());
        System.out.println(holdEm.drawRiver());
        System.out.println(holdEm.drawRiver());
        System.out.println(holdEm.drawRiver());
        holdEm.scoreHands();
        
   
    }
    public static void playBlackJack() {
        
    }
    public static void main(String[] args) {
        playHoldEm(4);
        



    }
}