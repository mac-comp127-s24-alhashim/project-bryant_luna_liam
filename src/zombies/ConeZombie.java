package zombies;

import edu.macalester.graphics.*;


public class ConeZombie extends Zombie {
    private Image zombieObject;
    String type;
    int health = 24;

    public ConeZombie(double x, double y) {
        super(x, y);
        setPosition(x, y);
        createZombie();
    }

    private void createZombie() {
        zombieObject = new Image("zombies/ZOMBIE_PLACEHOLDER.png");
        add(zombieObject);
    }
}
