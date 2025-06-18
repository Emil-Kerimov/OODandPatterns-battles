package khnu.mizhfac.game;

public abstract class AbstractWarrior implements Warrior{
    private int health;

    public AbstractWarrior(int health) {
        this.health = health;
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    @Override
    public void hit(Warrior second) {
        if(second instanceof  AbstractWarrior awSecond){
            awSecond.setHealth(awSecond.getHealth() - getAttack());
        } else {
            throw new IllegalArgumentException("unsupported type");
        }
    }

    public int getHealth() {
        return health;
    }
    public abstract int getAttack();
    protected void setHealth(int health) {
        this.health = health;
    }

}
