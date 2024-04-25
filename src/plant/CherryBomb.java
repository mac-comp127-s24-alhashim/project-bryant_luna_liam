package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;

public class CherryBomb extends GraphicsGroup {
    
    private static final String SPRITE_PATH = "plants/CHERRYBOMB.png";
    public static final String CHERRYBOMB_SEED_SPRITE_PATH = "game/SEEDPACKET_CHERRYBOMB.png";
    public static final int SUN_COST = 150;
    private static final double RECHARGE_TIME_SECONDS = 40000;
    private static final int CHERRYBOMB_DAMAGE = 100;
    private static final int CHERRYBOMB_EXPLOSION_RADIUS = 48;
    
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup cherryBomb;
    private Image cherryBombSprite;
    private Explosion explosion;

    public CherryBomb() {
        cherryBombSprite = new Image(SPRITE_PATH);
        add(cherryBombSprite);
        // explosion = new Explosion(canvas, CHERRYBOMB_EXPLOSION_RADIUS, location, CHERRYBOMB_DAMAGE);
        PvZ.sunCount -= SUN_COST;
    }

    public void action() {
        // explosion = new Explosion(canvas, CHERRYBOMB_EXPLOSION_RADIUS, location, CHERRYBOMB_DAMAGE);
    }

    public int getSunCost() {
        return SUN_COST;
    }

    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }

}
