package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import plantsvszombies.PvZ;

public class Wallnut extends GraphicsGroup {

    private static final String SPRITE_PATH = "plants/WALLNUT.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_WALLNUT.png";
    public static final int SUN_COST = 50;
    private static final double RECHARGE_TIME_SECONDS = 30000;
    
    public int health = 4000;
    Image wallnutSprite;

    /**
     * Constructs wallnut
     */
    public Wallnut() {
        wallnutSprite = new Image(SPRITE_PATH);
        add(wallnutSprite);
        PvZ.sunCount -= SUN_COST;
    }

    /**
     * Reduces health and sets that if health is zero to die
     */
    public void reduceHealth(int damage) {
        health -= damage;
        if (health <= 0) die();
    }
    /**
     * Gets health
     * @return
     */
    public int getHealth() {
        return health;
    }

     /**
     * Returns sun cost
     * @return
     */
    public int getSunCost() {
        return SUN_COST;
    }
     /**
     * Returns recharge time
     * @return
     */
    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }
    /**
     * Removes plant from canvas
     */
    public void die() {
        removeAll();
    }
}

