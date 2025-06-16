package khnu.mizhfac.game;

public class Game {
    public static boolean fight(Warrior first, Warrior second){
        while (first.isAlive()){
            first.hit(second);
            if(!second.isAlive()){
                return true;
            }
            second.hit(first);
        }
        return false;
    }
}
