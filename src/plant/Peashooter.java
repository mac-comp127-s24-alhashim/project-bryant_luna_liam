package plant;

// import java.util.List;
// import java.util.ArrayList;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import plantsvszombies.PvZ;

public class Peashooter extends GraphicsGroup {

    private static final String SPRITE_PATH = "plants/PEASHOOTER.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_PEASHOOTER.png";
    public final static String PEA_SPRITE_PATH = "plants/PEASHOOTER_PEA.png";
    public static final int SUN_COST = 100;
    private final int RECHARGE_TIME_SECONDS = 7500;
    private final int PEA_SHOOTING_RATE = 1500;
    final static int PEASHOOTER_DAMAGE = 20;
    
    public int health = 300;
    Image peashooterSprite;
    // private List<Projectile> peas;

    public Peashooter() {
        // peas = new ArrayList<Projectile>();
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
     * If Peashooter's health goes below zero, it is removed from canvas.
     */
    void die() {
        removeAll();
    }
    /**
     * Gets plant health
     * @return 
     */
    public int getHealth() {
        return health;
    }
}
