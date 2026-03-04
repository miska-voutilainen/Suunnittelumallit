import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CharacterImplement character = new CharacterImplement("Player", CharacterLevel.NOVICE, 0, 20);
        ActionFight actionFight = new ActionFight();
        ActionTrain actionTrain = new ActionTrain();
        ActionMeditate actionMeditate = new ActionMeditate();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== State Pattern RPG ===");

        while (character.getLevel() != CharacterLevel.MASTER) {
            System.out.println();
            System.out.println("[" + character.getName() + "] Level: " + character.getLevel()
                + " | XP: " + character.getExperience() + " | HP: " + character.getHealth());
            System.out.print("Choose action (fight / train / meditate / quit): ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "fight":
                    actionFight.fight(character);
                    break;
                case "meditate":
                    actionMeditate.meditate(character);
                    break;
                case "train":
                    actionTrain.train(character);
                    break;
                case "quit":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown action.");
            }

            if (character.getHealth() <= 0) {
                System.out.println(character.getName() + " has fallen! Game over.");
                break;
            }
        }

        if (character.getLevel() == CharacterLevel.MASTER) {
            System.out.println();
            System.out.println("*** " + character.getName() + " has reached MASTER level! Endgame reached! ***");
        }

        System.out.println();
        System.out.println("=== Final Stats ===");
        System.out.println("Name: " + character.getName());
        System.out.println("Level: " + character.getLevel());
        System.out.println("Experience: " + character.getExperience());
        System.out.println("Health: " + character.getHealth());

        scanner.close();
    }
}
