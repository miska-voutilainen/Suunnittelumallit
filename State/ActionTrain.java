public class ActionTrain {
    public boolean canTrain(Character character) {
        return character.getLevel() == CharacterLevel.NOVICE
            || character.getLevel() == CharacterLevel.INTERMEDIATE
            || character.getLevel() == CharacterLevel.EXPERT;
    }

    public void train(CharacterImplement character) {
        if (canTrain(character)) {
            System.out.println(character.getName() + " trains hard and gains 4 experience!");
            character.addExperience(4);
        } else {
            System.out.println(character.getName() + " is a MASTER and has nothing left to train.");
        }
    }
}
