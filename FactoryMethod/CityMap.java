import java.util.Random;

public class CityMap extends Map {
    private Random rand = new Random(); 

    public Tile createTile() {
        int r = rand.nextInt(3); // 0 = road, 1 = forest, 2 = building
        switch (r) {
            case 0: return new RoadTile();
            case 1: return new ForestTile();
            case 2: return new BuildingTile();
            default: return new ForestTile();
        }
    }
}
