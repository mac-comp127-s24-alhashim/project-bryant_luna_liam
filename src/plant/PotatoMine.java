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
    private static final int POTATOMINE_DAMAGE = 1800;
    private static final int POTATOMINE_EXPLOSION_RADIUS = 16;
    
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup potatoMine;
    private Image potatoMineSprite;
    private Boolean isBuried;
    private Explosion explosion;

    public PotatoMine() {
        isBuried = true;
        if (!isBuried) {
            potatoMineSprite = new Image(SPRITE_PATH);
        }
        else {
            potatoMineSprite = new Image(BURIED_SPRITE_PATH);
        }
        add(potatoMineSprite);
        PvZ.sunCount -= SUN_COST;
    }

    public void armUp() {
        isBuried = false;
        potatoMineSprite.setImagePath(SPRITE_PATH);
    }

    public void runScheduledTasks() {
        if (!isBuried) {
            //action();
        }
        else {
            if ((PvZ.frame % ARM_TIME) == 0) action();
        }
    }

    public void action() {
        // explosion = new Explosion(canvas, POTATOMINE_EXPLOSION_RADIUS, location, POTATOMINE_DAMAGE);
    }

    public int getSunCost() {
        return SUN_COST;
    }

    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }



}
