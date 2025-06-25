package khnu.mizhfac.game;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static khnu.mizhfac.game.Game.straightFight;
import static khnu.mizhfac.game.WarriorClasses.*;
import static org.junit.jupiter.api.Assertions.*;
import static khnu.mizhfac.game.Game.fight;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Slf4j
class GameTest {
    @Test
    @DisplayName("when warrior fights against warrior the first should win")
    void test01() {
        log.info("test 01 is running");
        // given
        Warrior chuck = WARRIOR.make();
        Warrior bruce = WARRIOR.make();
        log.debug("chuck = {}", chuck);
        log.debug("bruce = {}", bruce);

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
        log.info("Executing test WarriorVsDefender");
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
    void DefenderVsVampire() {
        log.info("Executing test DefenderVsVampire");
        var defender = DEFENDER.make();
        var vampire = VAMPIRE.make();

        var res = fight(defender,vampire);

        assertAll(
                () -> assertTrue(res),
                () -> assertEquals(22, ((AbstractWarrior) defender).getHealth()),
                () -> assertEquals(-1, ((AbstractWarrior) vampire).getHealth())
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
    @Test
    void lancerSmokeTest() {
        var chuck = WARRIOR.make();
        var bruce = WARRIOR.make();
        var carl = KNIGHT.make();
        var dave = WARRIOR.make();
        var mark = WARRIOR.make();
        var bob = DEFENDER.make();
        var mike = KNIGHT.make();
        var rog = WARRIOR.make();
        var lancelot = DEFENDER.make();
        var eric = VAMPIRE.make();
        var adam = VAMPIRE.make();
        var richard = DEFENDER.make();
        var ogre = WARRIOR.make();
        var freelancer = LANCER.make();
        var vampire = VAMPIRE.make();

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
        assertFalse(fight(eric, richard));
        assertTrue(fight(ogre, adam));
        assertTrue(fight(freelancer, vampire));
        assertTrue(freelancer.isAlive());

        var my_army = new Army()
                .addUnits(DEFENDER, 2)
                .addUnits(VAMPIRE, 2)
                .addUnits(LANCER, 4)
                .addUnits(WARRIOR, 1);

        var enemy_army = new Army()
                .addUnits(WARRIOR, 2)
                .addUnits(LANCER, 2)
                .addUnits(DEFENDER, 2)
                .addUnits(VAMPIRE, 3);

        var army_3 = new Army()
                .addUnits(WARRIOR, 1)
                .addUnits(LANCER, 1)
                .addUnits(DEFENDER, 2);

        var army_4 = new Army()
                .addUnits(VAMPIRE, 3)
                .addUnits(WARRIOR, 1)
                .addUnits(LANCER, 2);

        assertTrue(fight(my_army, enemy_army));
        assertFalse(fight(army_3, army_4));

    }

    @Test
    @DisplayName("fight 04")
    void fight04() {

        Army army1 = new Army()
                .addUnits(LANCER, 7)
                .addUnits(VAMPIRE, 3)
                .addUnits(HEALER, 1)
                .addUnits(WARRIOR, 4)
                .addUnits(HEALER, 1)
                .addUnits(DEFENDER, 2);//18

        Army army2 = new Army();
        army2.addUnits(WARRIOR, 4);
        army2.addUnits(DEFENDER, 4);
        army2.addUnits(HEALER, 1);
        army2.addUnits(VAMPIRE, 6);
        army2.addUnits(LANCER, 4);//19

        var res = straightFight(army1, army2);

        assertFalse(res);

    }

}