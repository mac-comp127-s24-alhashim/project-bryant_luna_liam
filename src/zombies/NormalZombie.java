package zombies;
import java.util.List;

import edu.macalester.graphics.*;

// NORMAL ZOMBIE ~ CONEHEAD, BUCKETHEAD, FLAG, NORMAL
// FOOTBALL ZOMBIE
// JACK-IN-THE-BOX ZOMBIE
// DIGGER ZOMBIE
// NEWSPAPER ZOMBIE
// ALL 32 x 48 in size

/**
 * A normal zombie. No special abilities.
 */
public class NormalZombie extends GraphicsGroup {
    private static Image zombieObject = new Image("zombies/NORMAL_ZOMBIE.png");;
    static final double ZOMBIE_WIDTH = zombieObject.getWidth();
    static final double ZOMBIE_HEIGHT = zombieObject.getHeight();
    String type;
    int health = 9;

    public NormalZombie(double x, double y) {
        setPosition(x, y);
        add(zombieObject);
    }

    public void move() {
        moveBy(-2, 0);
    }

    public void reduceHealth() {
        health--;
        if (health == 0) die();
    }

    public boolean checkCollisions(GraphicsObject object) {
        if (getElementAt(getPosition()) == object) return true;
        return false;
    }

    private void die() {
        remove(zombieObject);
    }
}