public class ActionMeditate {
    public boolean canMeditate(Character character) {
        return character.getLevel() == CharacterLevel.INTERMEDIATE;
    }
}