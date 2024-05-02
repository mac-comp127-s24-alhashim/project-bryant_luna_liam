package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import plantsvszombies.PvZ;

/**
 * A potato mine plant. It's an aggressive plant that when placed takes some
 * time to arm, then once armed, upon impact with a Zombie it creates an explosion.
 */
public class PotatoMine extends GraphicsGroup {
    
    private static final String SPRITE_PATH = "plants/POTATOMINE.png";
    private static final String BURIED_SPRITE_PATH = "plants/POTATOMINE_BURIED.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_POTATOMINE.png";
    public static final int SUN_COST = 25;
    private static final double RECHARGE_TIME_SECONDS = 20000;
    public static final int POTATOMINE_DAMAGE = 1800;
    public static final int POTATOMINE_EXPLOSION_RADIUS = 16;
    
    Image potatoMineSprite;
    private Boolean isBuried;
    private Boolean hasExploded;

    /**
     * Constructs a potato mine.
     */
    public PotatoMine() {
        isBuried = true;
        hasExploded = false;
        if (!isBuried) {
            potatoMineSprite = new Image(SPRITE_PATH);
        }
        else {
            potatoMineSprite = new Image(BURIED_SPRITE_PATH);
        }
        add(potatoMineSprite);
        PvZ.sunCount -= SUN_COST;
    }
    
    /**
     * Arm this potato mine.
     */
    public void arm() {
        isBuried = false;
        potatoMineSprite.setImagePath(SPRITE_PATH);
    }

    /**
     * Gets this potato mine's buried status.
     * @return
     */
    public Boolean getBuriedStatus() {
        return isBuried;
    }

    /**
     * Sets this potato mine's status to exploded.
     */
    public void setExploded(Boolean exploded) {
        hasExploded = exploded;
    }

    /**
     * Gets this potato mine's exploded status.
     * @return
     */
    public Boolean getExplodeStatus() {
        return hasExploded;
    }

    /**
     * Gets the sun cost for this potato mine.
     * @return
     */
    public int getSunCost() {
        return SUN_COST;
    }

    /**
     * Gets this potato mine's recharge time.
     * @return
     */
    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }

    /**
     * Removes this potato mine's sprite.
     */
    public void die() {
        removeAll();
    }
}
