public abstract class Map {
    protected Tile[][] tiles;
    protected int width = 5;
    protected int height = 5;

    public Map() {
        tiles = new Tile[height][width];
        
    }

    public void generateTiles() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = createTile(); 
            }
        }
    }

    public abstract Tile createTile();

    public void display() {
        // Display the map visually
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
        // Show tile type counts for uniqueness
        java.util.Map<String, Integer> typeCounts = new java.util.HashMap<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String type = tiles[i][j].getType();
                typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
            }
        }
        System.out.println("Tile type counts:");
        for (String type : typeCounts.keySet()) {
            System.out.println(type + ": " + typeCounts.get(type));
        }
    }
}
