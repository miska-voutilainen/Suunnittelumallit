package templatemethod;

public class Dice extends Game{

    private int maxRounds;
    private int currentRound;
    private int numberOfPlayers;
    private int[] scores;
    
    @Override
    /**
     * Initialize the game state for the given number of players.
     */
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.maxRounds = 5;
        this.currentRound = 0;
        this.scores = new int[numberOfPlayers];
        System.out.println("Initializing Dice game for " + numberOfPlayers + " players.");
    }

    @Override
    /**
     * Check if the game has ended.
     */
    public boolean endOfGame() {
        System.out.println("Checking if the game is over: current round " + currentRound + " of " + maxRounds);
        return this.currentRound >= this.maxRounds;
    }

    /**
     * Play a single turn for the given player.
     */
    @Override
    public void playSingleTurn(int player) {
        int roll = (int)(Math.random() * 6) + 1;
        scores[player] += roll;
        System.out.println("Player " + player + " rolled a " + roll + ". Total score: " + scores[player]);
        if (player == numberOfPlayers - 1) {
            currentRound++;
            System.out.println("End of round " + currentRound);
        }
    }

    /**
     * Display the winner of the game.
     */
    @Override
    public void displayWinner() {
        int winner = 0;
        for (int i = 1; i < numberOfPlayers; i++) {
            if (scores[i] > scores[winner]) {
                winner = i;
            }
        }
        System.out.println("Player " + winner + " wins with a score of " + scores[winner] + "!");
    }
}
