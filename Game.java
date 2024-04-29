
import java.util.Scanner;
public class Game {
    public static void playHoldEm(int players) {
        HoldEm holdEm = new HoldEm(players);
        int[] money = new int[players];
        for (int i = 0; i < money.length; i++) {
            money[i] = 5000;
        }
        playRound(players, money);
        System.out.println("");
        System.out.println(holdEm.drawRiver());
        System.out.println(holdEm.drawRiver());
        System.out.println(holdEm.drawRiver());
        System.out.println(holdEm.drawRiver());
        System.out.println(holdEm.drawRiver());
        holdEm.scoreHands();
        
   
    }
    public static void playRound(int players, int[] money, int pot) {
        boolean[] in = new boolean[players];
        int[] paid = new int[players];
        for (int i = 0; i < players; i++) {
            in[i] = true;
        }
        Scanner sc = new Scanner(System.in);
        int bet = 0;
        while (true) {
            for (int i = 0; i < players ; i++) {
                if(!in[i]) {
                    continue;
                }
                System.out.println("Player " + i + "'s Turn:");
                System.out.println("Bet is $" + bet + ".\n\t1. Call\n\t2. Raise\n\t3. Fold");
                int choice = sc.nextInt();
                System.out.println(choice);
                if(choice == 1) {
                    if (money[i] < bet) {
                        System.out.println("Insufficient funds. Go all in?\n\t1. Yes\n\t2. No");
                        int allIn = sc.nextInt();
                        if(allIn == 1) {
                            pot += money[i];
                            paid[i] += money[i];
                            money[i] = 0;
                        } else {
                            in[i] = false;
                        }
                        continue;
                    }
                    money[i] -= (bet - paid[i]);
                    pot += (bet - paid[i]);
                    paid[i] = bet;
                    continue;
                } else if (choice == 2) {
                    System.out.println("Input bet amount:\n\t$");
                    bet = sc.nextInt();
                    if (money[i] < bet) {
                        System.out.println("Insufficient funds. Go all in?\n\t1. Yes\n\t2. No");
                        int allIn = sc.nextInt();
                        if(allIn == 1) {
                            pot += money[i];
                            paid[i] += money[i];
                            money[i] = 0;
                        } else {
                            in[i] = false;
                        }
                        continue;
                    }
                    money[i] -= (bet - paid[i]);
                    pot += (bet - paid[i]);
                    paid[i] = bet;
                    continue;
                } else {
                    in[i] = false;
                    continue;
                }

            }
            
        }
        sc.close();
    }
    public static void playBlackJack() {
        
    }
    public static void main(String[] args) {
        playHoldEm(4);
        



    }
}