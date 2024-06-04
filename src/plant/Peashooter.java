package plant;

// import java.util.List;
// import java.util.ArrayList;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import plantsvszombies.PvZ;

/**
 * A peashooter plant. It's an aggressive plant that shoots peas
 * periodically that deal damage to zombies.
 */
public class Peashooter extends GraphicsGroup {

    private static final String SPRITE_PATH = "plants/PEASHOOTER.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_PEASHOOTER.png";
    public final static String PEA_SPRITE_PATH = "plants/PEASHOOTER_PEA.png";
    public static final int SUN_COST = 100;
    final static int PEASHOOTER_DAMAGE = 20;
    
    public int health = 300;
    Image peashooterSprite;

    /**
     * Constructs a peashooter.
     */
    public Peashooter() {
        peashooterSprite = new Image(SPRITE_PATH);
        add(peashooterSprite);
        PvZ.sunCount -= SUN_COST;
    }

    /**
     * Substracts the Peashooter's health by one.
     */
    public void reduceHealth(int damage) {
        health -= damage;
        if (health <= 0) die();
    }

    /**
     * Removes this peashooter's sprite.
     */
    void die() {
        removeAll();
    }
    /**
     * Gets this peashooter's health.
     * @return 
     */
    public int getHealth() {
        return health;
    }
}
