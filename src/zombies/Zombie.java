package zombies;

import java.util.List;
import java.util.Random;
import edu.macalester.graphics.*;

/**
 * A normal zombie. No special abilities.
 */
public class Zombie extends GraphicsGroup {
    
    private static Image zombieSprite = new Image("zombies/NORMAL_ZOMBIE.png");
    private Image coneSprite = new Image("zombies/CONE.png");
    private Image bucketSprite = new Image("zombies/BUCKET.png");
    private Image explosiveSprite = new Image("zombies/EXPLOSIVE_ZOMBIE.png");
    static final double ZOMBIE_WIDTH = zombieSprite.getWidth();
    static final double ZOMBIE_HEIGHT = zombieSprite.getHeight();
    Random random = new Random();
    int zombieHealth = 181;
    int coneHealth = 370;
    int bucketHealth = 1100;
    int explosiveHealth = 335;
    int zombieAttack = 100;
    int explosiveAttack = 4000;

    int zombieType = 0; // 0 = NORMAL | 1 = CONE | 2 = BUCKET | 3 = EXPLOSIVE

    public Zombie(double x, double y) {

        setPosition(x, y);

        if (random.nextInt(25) == 0) {
            zombieType = 3;
        }
        if (zombieType != 3) {
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
        else {
            add(explosiveSprite);
            System.out.println("EXPLOSIVE ZOMBIE");
        }
    }

    public void move() {
        if (zombieType == 3) {
            moveBy(-0.1875, 0);
        }
        else {
            moveBy(-0.046875, 0);
        }
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
                break;
            case 2:
                bucketHealth -= damage;
                if (bucketHealth <= 0) bucketDie();
                break;
            case 3:
                explosiveHealth -= damage;
                if (explosiveHealth <= 0) explosiveDie();
        }
    }

    // public boolean checkCollisions(GraphicsObject object) {
    //     if (getElementAt(getPosition()) == object) return true;
    //     return false;
    // }

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

    private void explosiveDie() {
        remove(explosiveSprite);
        // EXPLODES
    }
    
}