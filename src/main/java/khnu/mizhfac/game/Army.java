package khnu.mizhfac.game;

import java.util.function.Supplier;

public class Army {
    public Army addUnits(WarriorClasses warriorClasses, int i) {
        //some logic
        return this;
    }

    public Army addUnits(Supplier<Warrior> warriorFactory, int i) {
        //some logic
        Warrior warrior = warriorFactory.get();
        return this;
    }
}
