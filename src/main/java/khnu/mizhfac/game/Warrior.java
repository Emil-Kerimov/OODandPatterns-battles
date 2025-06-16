package khnu.mizhfac.game;

public class Warrior {
    static final int INITIAL_HEALTH = 50;
    public static final int ATTACK = 5;
    private int health;

    public Warrior() {
        this(INITIAL_HEALTH);
    }

    protected Warrior(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return ATTACK;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public void hit(Warrior second) {
        second.setHealth(second.getHealth() - getAttack());
    }
}
