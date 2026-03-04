public class ActionFight {
    public boolean canFight(Character character) {
        return character.getHealth() > 0;
    }

    public void fight(CharacterImplement character) {
        if (canFight(character)) {
            System.out.println(character.getName() + " fights and gains 5 experience!");
            character.addExperience(5);
            character.setHealth(character.getHealth() - 2);
            System.out.println(character.getName() + " lost 2 health. Health: " + character.getHealth());
        } else {
            System.out.println(character.getName() + " is too weak to fight!");
        }
    }
}
