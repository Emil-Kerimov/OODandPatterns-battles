package khnu.mizhfac.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static khnu.mizhfac.game.WarriorClasses.KNIGHT;
import static khnu.mizhfac.game.WarriorClasses.WARRIOR;
import static org.junit.jupiter.api.Assertions.*;
import static khnu.mizhfac.game.Game.fight;

class GameTest {
    @Test
    @DisplayName("when warrior fights against warrior the first should win")
    void test01() {
        // given
        Warrior chuck = WARRIOR.make();
        Warrior bruce = WARRIOR.make();

        // when
        boolean res = fight(chuck,bruce);

        // then
        assertTrue(res);
    }

    @Test
    @DisplayName("when warrior fights against knight the second should win")
    void test02() {
        // given
        Warrior chuck = WARRIOR.make();
        Warrior bruce = KNIGHT.make();

        // when
        boolean res = fight(chuck,bruce);

        // then
        assertFalse(res);
    }

    @Test
    @DisplayName("when warrior fights against warrior the first should stay alive")
    void test03() {
        // given
        Warrior bob = WARRIOR.make();
        Warrior mars = WARRIOR.make();

        // when
        fight(bob,mars);

        // then
        assertTrue(bob.isAlive());
    }
    @Test
    @DisplayName("when knight fights against warrior the first should win ")
    void test04() {
        // given
        Warrior bob = KNIGHT.make();
        Warrior mars = WARRIOR.make();

        // when
        boolean res = fight(bob,mars);

        // then
        assertTrue(res);
    }
    @Test
    @DisplayName("when knight fights against warrior the first should stay alive")
    void test05() {
        // given
        Warrior bob = KNIGHT.make();
        Warrior mars = WARRIOR.make();

        // when
        fight(bob,mars);

        // then
        assertTrue(bob.isAlive());
    }
    @Test
    @DisplayName("when warrior fights against warrior the second shouldn't stay alive")
    void test06() {
        // given
        Warrior bob = WARRIOR.make();
        Warrior mars = WARRIOR.make();

        // when
        fight(bob,mars);

        // then
        assertFalse(mars.isAlive());
    }

    @Test
    @DisplayName("when warrior fights against knight the second should stay alive")
    void test07() {
        // given
        Warrior bob = WARRIOR.make();
        Warrior mars = KNIGHT.make();

        // when
        fight(bob,mars);

        // then
        assertTrue(mars.isAlive());
    }

    @Test
    @DisplayName("when warrior fights against knight the second should stay alive and then unit 3 should win against knight")
    void test08() {
        // given
        Warrior bob = WARRIOR.make();
        Warrior mars = KNIGHT.make();
        Warrior unit3 = WARRIOR.make();

        // when
        fight(bob,mars);
        boolean res = fight(mars,unit3);

        // then
        assertFalse(res);
    }
}