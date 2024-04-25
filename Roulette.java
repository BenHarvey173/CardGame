public class Roulette {
    public Roulette() {
    }
    private int Spin() {
        
        return -1;
    }
    public int bet(int amount) {
        Spin();
        return amount;
    }
    public int bet(int value, int amount) {
        return bet(amount);
    }
    public int bet(String color, int amount) {
        return bet(amount);
    }
    
}