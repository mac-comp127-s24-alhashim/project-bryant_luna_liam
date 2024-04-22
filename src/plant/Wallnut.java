package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Wallnut implements Plant {

    private static final String WALLNUT_SPRITE_PATH = "plants/PLANT_PLACEHOLDER.png";
    public static final String WALLNUT_SEED_SPRITE_PATH = "game/SEEDPACKET_WALLNUT.png";
    public static final int SUN_COST = 50;
    private static final double RECHARGE_TIME_SECONDS = 30;
    
    public int health = 54;
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup wallnut;
    private Image wallnutSprite;

    public Wallnut(CanvasWindow canvas, Point location) {
        this.canvas = canvas;
        this.location = location;
        loadSprite();
        setPosition();
    }

    public void loadSprite() {
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
    }

    public void addToCanvas() {
    }

    public void removeFromCanvas() {
    }
    
}

