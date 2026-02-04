import java.util.Random;

// Unique WildernessMap implementation for Factory Method pattern
// Now includes MountainTile and a more interesting randomization
public class WildernessMap extends Map {
    private Random rand = new Random();

    // Factory Method: creates a random Tile, now with 4 types
    public Tile createTile() {
        int r = rand.nextInt(100); // 0-99
        if (r < 25) {
            return new SwampTile(); // 25% chance
        } else if (r < 50) {
            return new WaterTile(); // 25% chance
        } else if (r < 80) {
            return new ForestTile(); // 30% chance
        } else {
            return new MountainTile(); // 20% chance
        }
    }
}
