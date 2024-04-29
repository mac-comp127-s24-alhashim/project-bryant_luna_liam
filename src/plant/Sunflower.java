package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;
import plantsvszombies.Sun;

public class Sunflower extends GraphicsGroup {

    private static final String SPRITE_PATH = "plants/SUNFLOWER.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_SUNFLOWER.png";
    public static final int SUN_COST = 50;
    private static final double RECHARGE_TIME= 24000;
    private static final double SUN_PRODUCTION_RATE = 24000;
    
    public int health = 300;
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup sunflower;
    private Image sunflowerSprite;

    public Sunflower() {
        loadSprite();
        PvZ.sunCount -= SUN_COST;
    }

    public void loadSprite() {
        sunflowerSprite = new Image(SPRITE_PATH);
        add(sunflowerSprite);
    }

    public void reduceHealth(int damage) {
        health -= damage;
        if (health <= 0) die();
    }

    private void die() {
        removeAll();
    }

    public int getHealth() {
        return health;
    }

    public int getSunCost() {
        return SUN_COST;
    }
}
