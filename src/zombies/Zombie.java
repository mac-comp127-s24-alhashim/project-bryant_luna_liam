package zombies;
import edu.macalester.graphics.*;

// NORMAL ZOMBIE ~ CONEHEAD, BUCKETHEAD, FLAG, NORMAL
// FOOTBALL ZOMBIE
// JACK-IN-THE-BOX ZOMBIE
// DIGGER ZOMBIE
// NEWSPAPER ZOMBIE
// ALL 32 x 48 in size

public interface Zombie {
    String type = "";
    int health = 0;
    Point position = new Point(0, 0);


    public void drawZombie();

    public void attack();

    public void removeZombie();

    // public void takeDamage();
}