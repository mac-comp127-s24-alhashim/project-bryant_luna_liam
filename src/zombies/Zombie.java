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
        System.out.println("got thru constructor");
        createZombie();
    }

    private void createZombie() {
        System.out.println("creating zombie");
        zombieObject = new Image("zombies/ZOMBIE_PLACEHOLDER.png");
        System.out.println("loaded zombie");
        add(zombieObject);
        System.out.println("added zombie");
    }



    // public void drawZombie(String type, int health, Point position);
}