import java.util.Scanner;
public class Game {
    private static Scanner scanboy;
    public static void main(String[] args) {
        scanboy = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nWelcome to HoldEmTown!\nHow Many players would you like?");
        Play g = new Play(scanboy.nextInt());
        Continue();
        g.playHoldEm();
        Continue();
        System.out.println("Play again?\n");
        while (true) {
            int again = scanboy.nextInt();
            if (again == 1) {
                g.playHoldEm();
                Continue();
            } else {
                System.out.println("Thanks for Playing!");
                scanboy.close();
                return;
            }
        }
    }
    public static void Continue()
 { 
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
            scanboy.nextLine();
        }  
        catch(Exception e)
        {}  
 }
}