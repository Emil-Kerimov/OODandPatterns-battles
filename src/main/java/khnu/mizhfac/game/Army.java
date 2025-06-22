package khnu.mizhfac.game;

import java.util.*;
import java.util.function.Supplier;

public class Army implements Iterable<Warrior> {
    private static  int idCounter = 0;
    private int id = ++idCounter;
    private Deque<WarriorInArmy> troops = new ArrayDeque<>();
    private class WarriorInArmyImpl implements WarriorInArmy{
        Warrior warrior;

        public WarriorInArmyImpl(Warrior warrior) {
            this.warrior = warrior;
        }
        // TODO
    }
    public Army addUnits(WarriorClasses warriorClasses, int quantity) {
        return addUnits(warriorClasses::make, quantity);
    }

    public Army addUnits(Supplier<Warrior> warriorFactory, int quantity) {
        //some logic
        for (int j = 0; j < quantity; j++){
            Warrior warrior = warriorFactory.get();
            WarriorInArmy warriorInArmy = new WarriorInArmyImpl(warrior);
            //TODO; binding
            troops.peekLast();
            troops.add(warriorInArmy);
        }
        return this;
    }

    @Override
    public Iterator<Warrior> iterator() {
        return new FirstAliveIterator();
    }
    private class FirstAliveIterator implements  Iterator<Warrior>{
        @Override
        public boolean hasNext() {
            while (!troops.isEmpty() && !troops.peek().isAlive()){
                troops.poll();
            }
            return !troops.isEmpty();
        }

        @Override
        public Warrior next() {
            if(!hasNext()) throw  new NoSuchElementException();
            return troops.peek();
        }
    }

    @Override
    public String toString() {
        return "Army#" + id +
                "{" + troops +
                '}';
    }
}
