import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose map type: city or wilderness");
        String input = scanner.nextLine().toLowerCase();

        Map map = createMap(input);
        if (map != null) {
            map.generateTiles(); 
            map.display();
        } else {
            System.out.println("Invalid selection.");
        }

        scanner.close();
    }

    public static Map createMap(String type) {
        if (type.equals("city")) {
            return new CityMap();
        } else if (type.equals("wilderness")) {
            return new WildernessMap();
        } else {
            return null;
        }
    }
}
