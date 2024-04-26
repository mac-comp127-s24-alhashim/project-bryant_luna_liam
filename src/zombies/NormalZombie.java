package zombies;

import java.util.List;
import java.util.Random;
import edu.macalester.graphics.*;

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

        if (randomNumber <= 8 && randomNumber >= 6) {
            add(coneSprite);
            coneSprite.moveBy(0, -10);
            zombieType = 1;
        }
        else if (randomNumber == 9) {
            add(bucketSprite);
            bucketSprite.moveBy(0, -5);
            zombieType = 2;
        }
        else {
            zombieType = 0;
        }
    }

    public void move() {
        moveBy(-0.046875, 0);
    }

    public NormalZombie getZombie() {
        return this;
    }

    public void reduceHealth(int damage) {
        switch (zombieType) {
            case 0:
                zombieHealth -= damage;
                if (zombieHealth <= 0) die();
                break;
            case 1: 
                coneHealth -= damage;
                if (coneHealth <= 0) coneDie();
            case 2:
                bucketHealth -= damage;
                if (bucketHealth <= 0) bucketDie();
        }
        zombieHealth -= damage;
        if (zombieHealth == 0) die();
        System.out.println("Zombie health: " + zombieHealth);
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