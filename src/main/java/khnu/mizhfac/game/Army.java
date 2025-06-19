package khnu.mizhfac.game;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.function.Supplier;

public class Army implements Iterable<Warrior> {
    private Queue<Warrior> troops = new ArrayDeque<>();
    public Army addUnits(WarriorClasses warriorClasses, int quantity) {
        return addUnits(warriorClasses::make, quantity);
    }

    public Army addUnits(Supplier<Warrior> warriorFactory, int quantity) {
        //some logic
        for (int j = 0; j < quantity; j++){
            troops.add(warriorFactory.get());
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
}
