package khnu.mizhfac.game;

public class DefenderImpl extends AbstractWarrior implements HasDefence {
    static final int INITIAL_HEALTH = 60;
    static  final int ATTACK = 3;
    static  final int DEFENCE = 2;

    public DefenderImpl() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
    public int getDefence() {
        return DEFENCE;
    }
    @Override
    public void acceptDamage(int damage) {
        int reducedDamage = Math.max(0,damage - getDefence());
        super.acceptDamage(reducedDamage);
    }
}