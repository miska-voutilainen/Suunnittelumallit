public class ActionMeditate {
    public boolean canMeditate(Character character) {
        return character.getLevel() == CharacterLevel.INTERMEDIATE
            || character.getLevel() == CharacterLevel.EXPERT
            || character.getLevel() == CharacterLevel.MASTER;
    }

    public void meditate(CharacterImplement character) {
        if (canMeditate(character)) {
            System.out.println(character.getName() + " meditates and recovers 5 health + gains 3 experience!");
            character.setHealth(character.getHealth() + 5);
            character.addExperience(3);
        } else {
            System.out.println(character.getName() + " cannot meditate at " + character.getLevel() + " level.");
        }
    }
}