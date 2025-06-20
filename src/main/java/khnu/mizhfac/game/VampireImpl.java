package khnu.mizhfac.game;

public class VampireImpl extends AbstractWarrior {
    static final int ATTACK = 4;
    static final int INITIAL_HEALTH = 40;
    static final int VAMPIRISM = 50;

    public VampireImpl() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hit(Warrior second) {
        if(second instanceof AbstractWarrior awSecond){
            var healthBefore = awSecond.getHealth();
            super.hit(second);
            var healthAfter = awSecond.getHealth();
            var damageDealt = healthBefore - healthAfter;
            var healing = damageDealt * getVampirism() / 100;
            setHealth(getHealth() + healing);
        }
    }
}