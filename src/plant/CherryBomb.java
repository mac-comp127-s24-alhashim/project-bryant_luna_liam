package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import plantsvszombies.PvZ;

public class CherryBomb extends GraphicsGroup {
    
    private static final String SPRITE_PATH = "plants/CHERRYBOMB.png";
    public static final String CHERRYBOMB_SEED_SPRITE_PATH = "game/SEEDPACKET_CHERRYBOMB.png";
    public static final int SUN_COST = 150;
    private static final double RECHARGE_TIME_SECONDS = 40000;
    public static final int CHERRYBOMB_DAMAGE = 1800;
    public static final int CHERRYBOMB_EXPLOSION_RADIUS = 48;
    
    Image cherryBombSprite;
    Boolean hasExploded;

    /**
     * Constructs a cherrybomb 
     */
    public CherryBomb() {
        hasExploded = false;
        cherryBombSprite = new Image(SPRITE_PATH);
        add(cherryBombSprite);
        PvZ.sunCount -= SUN_COST;
    }

    /**
     * Gets the sun cost
     * @return
     */
    public int getSunCost() {
        return SUN_COST;
    }
    /**
     * Gets the recharge time
     * @return
     */
    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }
    /**
     * Updates whether cherrybomb has exploded or not
     */
    public void setExploded(Boolean exploded) {
        hasExploded = exploded;
    }
    /**
     * Gets the exploded status
     */
    public Boolean getExplodeStatus() {
        return hasExploded;
    }

    /**
     * Removes cherrybomb
     */
    public void die() {
        removeAll();
    }

}
