package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import plantsvszombies.PvZ;


public class Sunflower extends GraphicsGroup {

    private static final String SPRITE_PATH = "plants/SUNFLOWER.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_SUNFLOWER.png";
    public static final int SUN_COST = 50;
    
    public int health = 300;
    Image sunflowerSprite;

    /**
     * Constructs a sunflower
     */
    public Sunflower() {
        loadSprite();
        PvZ.sunCount -= SUN_COST;
    }

    /**
     * Loads sunflower sprite
     */
    public void loadSprite() {
        sunflowerSprite = new Image(SPRITE_PATH);
        add(sunflowerSprite);
    }

    /**
     * Reduces health and sets that if health is zero to die
     */
    public void reduceHealth(int damage) {
        health -= damage;
        if (health <= 0) die();
    }
    /**
     * Removes plant from canvas
     */
    void die() {
        removeAll();
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
}
