package zombies;

import java.util.List;
import java.util.Random;
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

    private static Image zombieSprite = new Image("zombies/NORMAL_ZOMBIE.png");
    private Image coneSprite = new Image("zombies/CONE.png");
    private Image bucketSprite = new Image("zombies/BUCKET.png");
    static final double ZOMBIE_WIDTH = zombieSprite.getWidth();
    static final double ZOMBIE_HEIGHT = zombieSprite.getHeight();
    Random random = new Random();
    int zombieHealth = 9;
    int coneHealth = 18;
    int bucketHealth = 45;
    int zombieType = 0; // 0 = NORMAL | 1 = CONE | 2 = BUCKET

    public NormalZombie(double x, double y) {

        setPosition(x, y);
        add(zombieSprite);

        int randomNumber = random.nextInt(10);
        System.out.println(randomNumber);

        if (randomNumber <= 8 && randomNumber >= 6) {
            add(coneSprite);
            zombieType = 1;
        }
        else if (randomNumber == 9) {
            add(bucketSprite);
            zombieType = 2;
        }
        else {
            zombieType = 0;
        }
        
        System.out.println(zombieType);

    }

    public void move() {
        moveBy(-2, 0);
    }

    public void reduceHealth() {
        switch (zombieType) {
            case 0:
                zombieHealth--;
                if (zombieHealth <= 0) die();
                break;
            case 1: 
                coneHealth--;
                if (coneHealth <= 0) coneDie();
            case 2:
                bucketHealth--;
                if (bucketHealth <= 0) bucketDie();
        }
        zombieHealth--;
        if (zombieHealth == 0) die();
    }

    public boolean checkCollisions(GraphicsObject object) {
        if (getElementAt(getPosition()) == object) return true;
        return false;
    }

    private void die() {
        remove(zombieSprite);
    }

    private void coneDie() {
        zombieType = 0;
        remove(coneSprite);
    }

    private void bucketDie() {
        zombieType = 0;
        remove(bucketSprite);
    }
}