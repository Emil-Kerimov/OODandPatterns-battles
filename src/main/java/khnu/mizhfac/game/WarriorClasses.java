package khnu.mizhfac.game;

public enum WarriorClasses {
    WARRIOR, KNIGHT;
    public static Warrior factory(WarriorClasses warriorClasses){
        return switch (warriorClasses){
            case WARRIOR ->  new WarriorImpl();
            case KNIGHT ->  new KnightImpl();
        };
    }
    public Warrior make(){
        return  factory(this);
    }
    public static void main(String[] args){
        WarriorClasses w = WARRIOR;
        Warrior warrior1 = w.make();
        Warrior warrior2 = WarriorClasses.factory(w);
    }
}
