package khnu.mizhfac.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static khnu.mizhfac.game.WarriorClasses.KNIGHT;
import static khnu.mizhfac.game.WarriorClasses.WARRIOR;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BattleTest {

    @Test
    @DisplayName("1. Battle: army of 1 warrior looses to army of 2 warriors")
    void battle01() {
          var army1 = new Army();
          var army2 = new Army();
          army1.addUnits(WARRIOR::make, 1);
          army2.addUnits(() -> WarriorClasses.factory(WARRIOR), 2);

          var res = Game.fight(army1,army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("1. Battle: 20 Warriors +5Knights < 30W")
    void battle02() {
        var army1 = new Army()
                .addUnits(WARRIOR, 20)
                .addUnits(KNIGHT, 5);
        var army2 = new Army()
                .addUnits(WARRIOR, 30);

        var res = Game.fight(army1,army2);

        assertFalse(res);
    }
}
