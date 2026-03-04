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

    public void setLevel(CharacterLevel level) { this.level = level; }
    public void setExperience(int experience) { this.experience = experience; }
    public void setHealth(int health) { this.health = health; }

    public void addExperience(int amount) {
        this.experience += amount;
        checkLevelUp();
    }

    private void checkLevelUp() {
        if (level == CharacterLevel.NOVICE && experience >= 10) {
            level = CharacterLevel.INTERMEDIATE;
            System.out.println(name + " leveled up to INTERMEDIATE!");
        } else if (level == CharacterLevel.INTERMEDIATE && experience >= 25) {
            level = CharacterLevel.EXPERT;
            System.out.println(name + " leveled up to EXPERT!");
        } else if (level == CharacterLevel.EXPERT && experience >= 50) {
            level = CharacterLevel.MASTER;
            System.out.println(name + " leveled up to MASTER!");
        }
    }
}