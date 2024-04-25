package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;

public class PotatoMine implements Plant {
    
    private static final String SPRITE_PATH = "plants/POTATOMINE.png";
    private static final String BURIED_SPRITE_PATH = "plants/POTATOMINE_BURIED.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_POTATOMINE.png";
    public static final int SUN_COST = 25;
    private static final double RECHARGE_TIME_SECONDS = 20000;
    private static final double ARM_TIME = 15000;
    private static final int POTATOMINE_DAMAGE = 100;
    private static final int POTATOMINE_EXPLOSION_RADIUS = 16;
    
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup potatoMine;
    private Image potatoMineSprite;
    private Boolean isBuried;
    private Explosion explosion;

    public PotatoMine(CanvasWindow canvas, Point location, Boolean isBuried) {
        this.canvas = canvas;
        this.location = location;
        this.isBuried = isBuried;
        loadSprite();
        setPosition();
        PvZ.sunCount -= SUN_COST;
    }

    public void loadSprite() {
        if (!isBuried) {
            potatoMineSprite = new Image(SPRITE_PATH);
        }
        else {
            potatoMineSprite = new Image(BURIED_SPRITE_PATH);
        }
        potatoMine = new GraphicsGroup();
        potatoMine.add(potatoMineSprite);
        addToCanvas();
    }

    public void armUp() {
        isBuried = false;
        potatoMineSprite.setImagePath(SPRITE_PATH);
    }

    public void runScheduledTasks() {
        if (!isBuried) {
            action();
        }
        else {
            armUp();
        }
    }

    public void action() {
        explosion = new Explosion(canvas, POTATOMINE_EXPLOSION_RADIUS, location, POTATOMINE_DAMAGE);
        removeFromCanvas();
    }

    public int getSunCost() {
        return SUN_COST;
    }

    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }

    public Point getPosition() {
        return location;
    }

    public void setPosition() {
        potatoMine.setPosition(location);
    }

    public void addToCanvas() {
        canvas.add(potatoMine);
    }

    public void removeFromCanvas() {
        canvas.remove(potatoMine);
    }



}
