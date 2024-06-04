package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import plantsvszombies.PvZ;

/**
 * A wallnut plant. It's a defensive plant that acts as a shield
 * to stall zombies.
 */
public class Wallnut extends GraphicsGroup {

    private static final String SPRITE_PATH = "plants/WALLNUT.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_WALLNUT.png";
    public static final int SUN_COST = 50;
    private static final double RECHARGE_TIME_SECONDS = 30000;
    
    public int health = 4000;
    Image wallnutSprite;

    /**
     * Constructs a wallnut.
     */
    public Wallnut() {
        wallnutSprite = new Image(SPRITE_PATH);
        add(wallnutSprite);
        PvZ.sunCount -= SUN_COST;
    }

    /**
     * Reduces this wallnut's health. 
     */
    public void reduceHealth(int damage) {
        health -= damage;
        if (health <= 0) die();
    }

    /**
     * Gets this wallnut's health.
     * @return
     */
    public int getHealth() {
        return health;
    }

     /**
     * Returns the sun cost of this wallnut.
     * @return
     */
    public int getSunCost() {
        return SUN_COST;
    }

     /**
     * Returns the recharge time of this wallnut.
     * @return
     */
    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }

    /**
     * Removes this wallnut's sprite.
     */
    public void die() {
        removeAll();
    }
}

