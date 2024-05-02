package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;

public class PotatoMine extends GraphicsGroup {
    
    private static final String SPRITE_PATH = "plants/POTATOMINE.png";
    private static final String BURIED_SPRITE_PATH = "plants/POTATOMINE_BURIED.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_POTATOMINE.png";
    public static final int SUN_COST = 25;
    private static final double RECHARGE_TIME_SECONDS = 20000;
    private static final double ARM_TIME = 900;
    public static final int POTATOMINE_DAMAGE = 1800;
    public static final int POTATOMINE_EXPLOSION_RADIUS = 16;
    
    Image potatoMineSprite;
    private Boolean isBuried;
    private Boolean hasExploded;

    /**
     * Constructs a potato mine
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
     * Determines whether a potato mine is buried or not
     */
    public void armUp() {
        isBuried = false;
        potatoMineSprite.setImagePath(SPRITE_PATH);
    }

    /**
     * Gets buried status
     * @return
     */
    public Boolean getBuriedStatus() {
        return isBuried;
    }

    /**
     * Sets a potato mine as exploded
     */
    public void setExploded(Boolean exploded) {
        hasExploded = exploded;
    }

    /**
     * Gets exploded status
     * @return
     */
    public Boolean getExplodeStatus() {
        return hasExploded;
    }

    /**
     * Gets sun cost
     * @return
     */
    public int getSunCost() {
        return SUN_COST;
    }

    /**
     * Gets recharge time
     * @return
     */
    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }

    /**
     * Removes potato mine from canvas
     */
    public void die() {
        removeAll();
    }

}
