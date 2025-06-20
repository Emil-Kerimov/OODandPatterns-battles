package khnu.mizhfac.game;

public class DefenderImpl extends AbstractWarrior {
    static final int INITIAL_HEALTH = 60;
    static  final int ATTACK = 3;

    public DefenderImpl() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
}