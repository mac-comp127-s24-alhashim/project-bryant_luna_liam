package zombies;
import java.util.List;

import edu.macalester.graphics.*;

// NORMAL ZOMBIE ~ CONEHEAD, BUCKETHEAD, FLAG, NORMAL
// FOOTBALL ZOMBIE
// JACK-IN-THE-BOX ZOMBIE
// DIGGER ZOMBIE
// NEWSPAPER ZOMBIE
// ALL 32 x 48 in size

public class Zombie extends GraphicsGroup {
    private final double X;
    private final double Y;
    private Image zombieObject;
    String type;
    int health;
    Point position;

    public Zombie(double x, double y) {
        this.X = x;
        this.Y = y;
        this.setPosition(x, y);
        createZombie();
    }

    private void createZombie() {
        zombieObject = new Image("zombies/NORMAL_ZOMBIE.png");
        add(zombieObject);
    }

    public void move() {
        moveBy(-2, 0); // my brain is frie didk 
    }
}