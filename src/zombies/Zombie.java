package zombies;

import java.util.Random;
import edu.macalester.graphics.*;
import plantsvszombies.PvZ;

/**
 * A zombie that eats plants. Can have varying abilities and protection.
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

    Random random = new Random();
    Boolean eating = false;
    Boolean hitByExplosion = false;
    int zombieHealth = 362;
    int coneHealth = 740;
    int bucketHealth = 2200;
    int fastHealth = 670;
    int cyborgHealth = 7200;
    // 0 = NORMAL | 1 = CONE | 2 = BUCKET | 3 = FAST | 4 = BIG
    int zombieType = 0;

    /**
     * Constructs Zombie. A zombie can have special abilities with a 2% chance of big zombie, 4% chance of explosive
     * zombie, 60% chance of being a normal zombie, 30% chance of being a cone zombie, and a 10% chance
     * of being a bucket zombie.
     */
    public Zombie(double x, double y) {
        setPosition(x, y);

        int specialZombieChance = random.nextInt(10);

        // 60% chance of being a normal zombie, 30% of being a fast zombie, 10% of being a cyborg zombie.
        if (specialZombieChance == 9) {
            zombieType = 4;
            add(cyborgSprite);
        }
        else if (specialZombieChance <= 8 && specialZombieChance >= 6) {
            zombieType = 3;
            add(fastSprite);
        }        
        else {
            add(zombieSprite);
            int normalZombieChance = random.nextInt(10);
            // 60% chance of being a normal zombie, 30% of being a conehead zombie, 10% of being a buckethead zombie.
            if (normalZombieChance <= 8 && normalZombieChance >= 6) {
                add(coneSprite);
                coneSprite.moveBy(0, -10);
                zombieType = 1;
            } else if (normalZombieChance == 9) {
                add(bucketSprite);
                bucketSprite.moveBy(0, -5);
                zombieType = 2;
            } else {
                zombieType = 0;
            }
        }
    }

    /**
     * Moves this zombie.
     */
    public void move() {
        if (!eating) {
            if (zombieType == 3) {
                moveBy(-0.1875, 0);
            } else if (zombieType == 4) {
                moveBy(-0.0234375, 0);
            } else {
                moveBy(-0.046875, 0); 
            }
        }
    }

    /**
     * Reduces health per zombie criteria. Cones and Buckets grant zombies
     * additional protection against damage.
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
     * Removes this zombie.
     */
    public void die() {
        removeAll();
        PvZ.zombiesKilled++;
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
     * Gets this zombie's health.
     * 
     * @return
     */
    public int getHealth() {
        if (zombieType == 3) {
            return fastHealth;
        } else if (zombieType == 4) {
            return cyborgHealth;
        } else {
            return zombieHealth;
        }
    }

    /**
     * Gets this zombie's damage value.
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
     * Returns true if this zombie is eating a plant.
     * 
     * @return
     */
    public boolean getEatingStatus() {
        return eating;
    }

    /**
     * Sets this zombie's eating status.
     * @param eat
     */
    public void setEatingStatus(Boolean eat) {
        eating = eat;
    }

    /**
     * Gets this zombie's explosion status.
     * 
     * @return hitByExplosion;
     */
    public boolean getExplodedStatus() {
        return hitByExplosion;
    }

    /**
     * Sets this zombie's explosion status.
     */
    public void setExplodedStatus(Boolean exploded) {
        hitByExplosion = exploded;
    }

}