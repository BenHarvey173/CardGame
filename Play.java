import java.util.Scanner;
public class Play {
    private int players;
    private int[] money;
    private int pot;
    private HoldEm game;
    private Scanner sc;
    private int[] pots;
    private int p;
    public Play(int players){
        pots = new int[players];
        p = 0;
        sc = new Scanner(System.in);
        this.players = players;
        game = new HoldEm(players);
        money = new int[players];
        pot = 0;
        for (int i = 0; i < money.length; i++) {
            money[i] = 4900;
            pot += 100;
        }
    }
    public void playHoldEm() {
        playRound();
        System.out.println(game.drawRiver());
        System.out.println(game.drawRiver());
        System.out.println(game.drawRiver() + "\n");
        playRound();
        System.out.println(game.drawRiver() + "\n");
        playRound();
        System.out.println(game.drawRiver() + "\n");
        playRound();
        game.scoreHands();
        

    }
    public void playRound() {
        boolean[] in = new boolean[players];
        int[] paid = new int[players];
        for (int i = 0; i < players; i++) {
            in[i] = true;
        }
        int bet = 100;
        int oldBet = 0;
        while (oldBet < bet) {
            oldBet = bet;
            for (int i = 0; i < players ; i++) {
                if(!in[i] || money[i] == 0) {
                    continue;
                }
                if(bet == paid[i]) {
                    break;
                }
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPlayer " + (i + 1) + "'s Turn:");
                System.out.println("Your Cards are:" + game.getHand(i));
                System.out.println("You have: $" + money[i] + ".");
                System.out.println("Bet is $" + bet + ".\n\t1. Call\n\t2. Raise\n\t3. Fold\n");
                int choice = sc.nextInt();
                if(choice == 1) {
                    if (money[i] < bet) {
                        System.out.println("Insufficient funds. Go all in?\n\t1. Yes\n\t2. No");
                        int allIn = sc.nextInt();
                        if(allIn == 1) {
                            pot += money[i];
                            pots[p] = paid[i];
                            p++;
                            paid[i] += money[i];
                            money[i] = 0;
                            System.out.println("You are all in.");
                            Continue();
                        } else {
                            in[i] = false;
                            Continue();
                        }
                        continue;
                    }
                    money[i] -= (bet - paid[i]);
                    pot += (bet - paid[i]);
                    paid[i] = bet;
                    System.out.println("You have $" + money[i] + " Remaining");
                    Continue();
                    continue;
                } else if (choice == 2) {
                    System.out.print("Input bet amount:\n\t$");
                    int temp = sc.nextInt();
                    if (temp > bet) {
                        if (money[i] < temp) {
                            System.out.println("Bet is more than Available Money.");
                            System.out.println("Restarting turn...\n");
                            Continue();
                            i--;
                            continue;
                        }
                        bet = temp;
                        money[i] -= (bet - paid[i]);
                        pot += (bet - paid[i]);
                        paid[i] = bet;
                        System.out.println("You have $" + money[i] + " Remaining\n");
                        Continue();
                        continue;
                    } else {
                        System.out.println("New Bet is Lower than Old Bet.");
                        System.out.println("Restarting turn...\n");
                        Continue();

                        i--;
                        continue;

                    }
                } else {
                    in[i] = false;
                    System.out.println("You have Folded");
                    Continue();

                    continue;
                }
            }

        }
    }
    public void Continue()
 { 
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
            sc.nextLine();
        }  
        catch(Exception e)
        {}  
 }
}
