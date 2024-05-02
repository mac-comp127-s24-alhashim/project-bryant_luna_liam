package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import plantsvszombies.PvZ;

/**
 * A sunflower plant. It generates suns for the player.
 */
public class Sunflower extends GraphicsGroup {

    private static final String SPRITE_PATH = "plants/SUNFLOWER.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_SUNFLOWER.png";
    public static final int SUN_COST = 50;
    
    public int health = 300;
    Image sunflowerSprite;

    /**
     * Constructs a sunflower.
     */
    public Sunflower() {
        loadSprite();
        PvZ.sunCount -= SUN_COST;
    }

    /**
     * Loads this sunflower's sprite.
     */
    public void loadSprite() {
        sunflowerSprite = new Image(SPRITE_PATH);
        add(sunflowerSprite);
    }

    /**
     * Reduces this sunflower's health.
     */
    public void reduceHealth(int damage) {
        health -= damage;
        if (health <= 0) die();
    }
    /**
     * Removes this sunflower's sprite.
     */
    void die() {
        removeAll();
    }

    /**
     * Gets this sunflower's health.
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns this sunflower's sun cost.
     * @return
     */
    public int getSunCost() {
        return SUN_COST;
    }
}
