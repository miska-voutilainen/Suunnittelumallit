import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character character = new CharacterImplement("Player", CharacterLevel.NOVICE, 0, 20);
        ActionTrain actionTrain = new ActionTrain(character);
        ActionMeditate actionMeditate = new ActionMeditate();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose action: fight, meditate, train");
        String input = scanner.nextLine().toLowerCase();

        switch (input) {
            case "fight":
                System.out.println(character.getName() + " fights!");
                break;
            case "meditate":
                if (actionMeditate.canMeditate(character)) {
                    System.out.println(character.getName() + " meditates!");
                } else {
                    System.out.println(character.getName() + " cannot meditate.");
                }
                break;
            case "train":
                if (actionTrain.canTrain(character)) {
                    System.out.println(character.getName() + " trains!");
                } else {
                    System.out.println(character.getName() + " cannot train.");
                }
                break;
            default:
                System.out.println("Unknown action.");
        }

        scanner.close();

        if (CharacterLevel.MASTER.equals(character.getLevel())) {
            System.out.println("Endgame reached!");
        } else {
        }
        
        System.out.println("Name: " + character.getName());
        System.out.println("Level: " + character.getLevel());
        System.out.println("Experience: " + character.getExperience());
        System.out.println("Health: " + character.getHealth());
    }
}
