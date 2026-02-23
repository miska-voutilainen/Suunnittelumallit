public class ActionTrain  {
    public boolean canTrain(Character character) {
        return character.getLevel() == CharacterLevel.NOVICE || character.getLevel() == CharacterLevel.INTERMEDIATE || character.getLevel() == CharacterLevel.EXPERT;
    }

    public ActionTrain(Character character) {
        if (canTrain(character)) {
            System.out.println(character.getName() + " is training...");
        } else {
        }
    }
}
