package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import plantsvszombies.PvZ;

/**
 * A cherry bomb plant. It's an aggressive plant that explodes upon placement,
 * creating a large explosion around it that deals damage to zombies and plants.
 */
public class CherryBomb extends GraphicsGroup {
    
    private static final String SPRITE_PATH = "plants/CHERRYBOMB.png";
    public static final String CHERRYBOMB_SEED_SPRITE_PATH = "game/SEEDPACKET_CHERRYBOMB.png";
    public static final int SUN_COST = 150;
    private static final double RECHARGE_TIME = 40000;
    public static final int CHERRYBOMB_DAMAGE = 1800;
    public static final int CHERRYBOMB_EXPLOSION_RADIUS = 48;
    
    Image cherryBombSprite;
    Boolean hasExploded;

    /**
     * Constructs a cherry bomb.
     */
    public CherryBomb() {
        hasExploded = false;
        cherryBombSprite = new Image(SPRITE_PATH);
        add(cherryBombSprite);
        PvZ.sunCount -= SUN_COST;
    }

    /**
     * Gets this cherry bomb's sun cost.
     * @return
     */
    public int getSunCost() {
        return SUN_COST;
    }

    /**
     * Gets this cherry bomb's recharge time, in frames.
     * @return
     */
    public double getRechargeTime() {
        return RECHARGE_TIME;
    }

    /**
     * Set this cherry bomb's exploded value.
     * @param exploded
     */
    public void setExploded(Boolean exploded) {
        hasExploded = exploded;
    }

    /**
     * Gets this cherry bomb's exploded value.
     */
    public Boolean getExplodeStatus() {
        return hasExploded;
    }

    /**
     * Removes the cherry bomb sprite.
     */
    public void die() {
        removeAll();
    }
}
