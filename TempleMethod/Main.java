package templemethod;

public class Main {
    public static void main(String[] args) {

        System.out.println("Dice Game:");
        
        Game diceGame = new Dice();
        diceGame.play(2);
        
    }
}