public class CharacterImplement implements Character {
    private String name;
    private CharacterLevel level;
    private int experience;
    private int health;

    public CharacterImplement(String name, CharacterLevel level, int experience, int health) {
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.health = health;
    }

    @Override
    public String getName() { return name; }
    @Override
    public CharacterLevel getLevel() { return level; }
    @Override
    public int getExperience() { return experience; }
    @Override
    public int getHealth() { return health; }
}