package zombies;

import java.util.Random;
import edu.macalester.graphics.*;

/**
 * A normal zombie. No special abilities.
 */
public class Zombie extends GraphicsGroup {

    private static Image zombieSprite = new Image("zombies/NORMAL_ZOMBIE.png");
    private Image coneSprite = new Image("zombies/CONE.png");
    private Image bucketSprite = new Image("zombies/BUCKET.png");
    private Image fastSprite = new Image("zombies/FAST_ZOMBIE.png");
    private Image cyborgSprite = new Image("zombies/CYBORG_ZOMBIE.png");

    static final double ZOMBIE_WIDTH = zombieSprite.getWidth();
    static final double ZOMBIE_HEIGHT = zombieSprite.getHeight();
    static final int zombieAttack = 100;
    static final int cyborgAttack = 2000;
    static final double explosionRadius = 48;

    Random random = new Random();
    Boolean eating = false;
    Boolean hasExploded = false;
    int zombieHealth = 181;
    int coneHealth = 370;
    int bucketHealth = 1100;
    int fastHealth = 335;
    int cyborgHealth = 3600;
    // 0 = NORMAL | 1 = CONE | 2 = BUCKET | 3 = FAST | 4 = BIG
    int zombieType = 0;

    /**
     * Constructs Zombie and can have special abilities with a 2% chance of big zombie, 4% chance of explosive
     * zombie, 60% chance of being a normal zombie, 30% chance of being a cone zombie, and a 10% chance
     * of being a bucket zombie.
     */
    public Zombie(double x, double y) {
        setPosition(x, y);

        if (random.nextInt(30) == 0) {
            zombieType = 4;
        }
        if (random.nextInt(15) == 0) {
            zombieType = 3;
        }

        if (zombieType == 3) {
            add(fastSprite);
        }
        else if (zombieType == 4) {
            add(cyborgSprite);
        }
        else {
            add(zombieSprite);
            int randomNumber = random.nextInt(10);
            if (randomNumber <= 8 && randomNumber >= 6) {
                add(coneSprite);
                coneSprite.moveBy(0, -10);
                zombieType = 1;
            } else if (randomNumber == 9) {
                add(bucketSprite);
                bucketSprite.moveBy(0, -5);
                zombieType = 2;
            } else {
                zombieType = 0;
            }
        }
    }

    /**
     * Moves zombie
     */
    public void move() {
        if (!eating) {
            if (zombieType == 3) {
                moveBy(-0.1875, 0);
            } else if (zombieType == 4) {
                moveBy(-0.0234375, 0);
            } else {
                moveBy(-0.1876, 0); // -0.046875
            }
        }
    }

    /**
     * Reduces health per zombie criteria
     */
    public void reduceHealth(int damage) {
        switch (zombieType) {
            case 0:
                zombieHealth -= damage;
                if (zombieHealth <= 0)
                    die();
                break;
            case 1:
                coneHealth -= damage;
                if (coneHealth <= 0)
                    coneDie();
                break;
            case 2:
                bucketHealth -= damage;
                if (bucketHealth <= 0)
                    bucketDie();
                break;
            case 3:
                fastHealth -= damage;
                if (fastHealth <= 0)
                    die();
            case 4:
                cyborgHealth -= damage;
                if (cyborgHealth <= 0)
                    die();
        }
    }

    /**
     * Removes zombie from the canvas.
     */
    public void die() {
        removeAll();
    }

    /**
     * Removes the cone the zombie is wearing.
     */
    private void coneDie() {
        zombieType = 0;
        remove(coneSprite);
    }

    /**
     * Removes the bucket the zombie is wearing.
     */
    private void bucketDie() {
        zombieType = 0;
        remove(bucketSprite);
    }

    /**
     * Gets health
     * 
     * @return
     */
    public int getHealth() {
        if (zombieType == 3) {
            return fastHealth;
        } else if (zombieType == 3) {
            return cyborgHealth;
        } else {
            return zombieHealth;
        }
    }

    /**
     * Gets damage 
     * @return
     */
    public int getDamage() {
        if (zombieType != 4) {
            return zombieAttack;
        }
        else {
            return cyborgAttack;
        }
    }

    /**
     * Gets zombie eating plant status
     * 
     * @return
     */
    public boolean getEatingStatus() {
        return eating;
    }

    /**
     * Sets zombie eating plant status
     */
    public void setEatingStatus(Boolean eat) {
        eating = eat;
    }

    /**
     * Gets exploded status
     * 
     * @return
     */
    public boolean getExplodeStatus() {
        return hasExploded;
    }

    /**
     * Sets zombie exploded status
     */
    public void setExplodeStatus(Boolean explode) {
        hasExploded = explode;
    }

}