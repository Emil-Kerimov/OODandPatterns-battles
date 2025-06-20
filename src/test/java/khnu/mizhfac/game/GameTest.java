package khnu.mizhfac.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static khnu.mizhfac.game.WarriorClasses.KNIGHT;
import static khnu.mizhfac.game.WarriorClasses.WARRIOR;
import static khnu.mizhfac.game.WarriorClasses.DEFENDER;
import static org.junit.jupiter.api.Assertions.*;
import static khnu.mizhfac.game.Game.fight;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
    @ParameterizedTest
    @MethodSource("warriorsPairs")
    @DisplayName("first warrior should win")
    void fightTestFirstWin(Warrior first, Warrior second) {
        assertTrue(fight(first,second));
    }

    static Stream<Arguments> warriorsPairs(){
        return Stream.of(
                arguments(WARRIOR.make(), WARRIOR.make()),
                arguments(KNIGHT.make(), WARRIOR.make()),
                arguments(KNIGHT.make(), KNIGHT.make())
        );
    }
    @ParameterizedTest
    @MethodSource("warriorsPairsSecondWin")
    @DisplayName("first warrior should win")
    void fightTestSecondWin(Warrior first, Warrior second) {
        assertFalse(fight(first,second));
    }

    static Stream<Arguments> warriorsPairsSecondWin(){
        return Stream.of(
                arguments(WARRIOR.make(), KNIGHT.make())
        );
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
    static class Rookie extends AbstractWarrior{
        public Rookie(){
            super(50);
        }
        @Override
        public int getAttack() {
            return 1;
        }
    }

    @Test
    void WarriorVsDefender() {
        var warrior = WARRIOR.make();
        var defender = DEFENDER.make();

        var res = fight(warrior,defender);

        assertAll(
                () -> assertFalse(res),
                () -> assertEquals(-1, ((AbstractWarrior) warrior).getHealth()),
                () -> assertEquals(9, ((AbstractWarrior) defender).getHealth())
        );
    }

    @Test
    void defenderSmokeTest() {
        var chuck = WARRIOR.make();
        var bruce = WARRIOR.make();
        var carl = KNIGHT.make();
        var dave = WARRIOR.make();
        var mark = WARRIOR.make();
        var bob = DEFENDER.make();
        var mike = KNIGHT.make();
        var rog = WARRIOR.make();
        var lancelot = DEFENDER.make();

        assertTrue(fight(chuck, bruce));
        assertFalse(fight(dave, carl));
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
        assertFalse(fight(carl, mark));
        assertFalse(carl.isAlive());
        assertFalse(fight(bob, mike));
        assertTrue(fight(lancelot, rog));

        var my_army = new Army().addUnits(DEFENDER, 1);

        var enemy_army = new Army()
                .addUnits(WARRIOR, 2);

        var army_3 = new Army()
                .addUnits(WARRIOR, 1)
                .addUnits(DEFENDER, 1);

        var army_4 = new Army().addUnits(WARRIOR, 2);

        assertFalse(fight(my_army, enemy_army));
        assertTrue(fight(army_3, army_4));

    }
}