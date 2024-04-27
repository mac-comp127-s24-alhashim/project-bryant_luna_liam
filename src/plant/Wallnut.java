package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;

public class Wallnut extends GraphicsGroup {

    private static final String SPRITE_PATH = "plants/WALLNUT.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_WALLNUT.png";
    public static final int SUN_COST = 50;
    private static final double RECHARGE_TIME_SECONDS = 30000;
    
    public int health = 4000;
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup wallnut;
    private Image wallnutSprite;

    public Wallnut() {
        wallnutSprite = new Image(SPRITE_PATH);
        add(wallnutSprite);
        PvZ.sunCount -= SUN_COST;
    }

    public int getSunCost() {
        return SUN_COST;
    }

    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }
}

