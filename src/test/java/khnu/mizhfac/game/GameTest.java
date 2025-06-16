package khnu.mizhfac.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static khnu.mizhfac.game.Game.fight;

class GameTest {
    @Test
    @DisplayName("when warrior fights against warrior the first should win")
    void test01() {
        // given
        Warrior chuck = new Warrior();
        Warrior bruce = new Warrior();

        // when
        boolean res = fight(chuck,bruce);

        // then
        assertTrue(res);
    }

    @Test
    @DisplayName("when warrior fights against knight the second should win")
    void test02() {
        // given
        Warrior chuck = new Warrior();
        Warrior bruce = new Knight();

        // when
        boolean res = fight(chuck,bruce);

        // then
        assertFalse(res);
    }

    @Test
    @DisplayName("when warrior fights against warrior the first should stay alive")
    void test03() {
        // given
        Warrior bob = new Warrior();
        Warrior mars = new Warrior();

        // when
        fight(bob,mars);

        // then
        assertTrue(bob.isAlive());
    }
    @Test
    @DisplayName("when knight fights against warrior the first should win ")
    void test04() {
        // given
        Warrior bob = new Knight();
        Warrior mars = new Warrior();

        // when
        boolean res = fight(bob,mars);

        // then
        assertTrue(res);
    }
    @Test
    @DisplayName("when knight fights against warrior the first should stay alive")
    void test05() {
        // given
        Warrior bob = new Knight();
        Warrior mars = new Warrior();

        // when
        fight(bob,mars);

        // then
        assertTrue(bob.isAlive());
    }
    @Test
    @DisplayName("when warrior fights against warrior the second shouldn't stay alive")
    void test06() {
        // given
        Warrior bob = new Warrior();
        Warrior mars = new Warrior();

        // when
        fight(bob,mars);

        // then
        assertFalse(mars.isAlive());
    }

    @Test
    @DisplayName("when warrior fights against knight the second should stay alive")
    void test07() {
        // given
        Warrior bob = new Warrior();
        Warrior mars = new Knight();

        // when
        fight(bob,mars);

        // then
        assertTrue(mars.isAlive());
    }

    @Test
    @DisplayName("when warrior fights against knight the second should stay alive and then unit 3 should win against knight")
    void test08() {
        // given
        Warrior bob = new Warrior();
        Warrior mars = new Knight();
        Warrior unit3 = new Warrior();

        // when
        fight(bob,mars);
        boolean res = fight(mars,unit3);

        // then
        assertFalse(res);
    }
}