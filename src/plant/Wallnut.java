package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Wallnut implements Plant {

    private static final String SPRITE_PATH = "plants/WALLNUT.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_WALLNUT.png";
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
        wallnutSprite = new Image(SPRITE_PATH);
        wallnut = new GraphicsGroup();
        wallnut.add(wallnutSprite);
    }

    public int getSunCost() {
        return SUN_COST;
    }

    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }

    public void receiveDamage() {
        health--;
        checkDeath();
    }

    public void checkDeath() {
        if (health <= 0) {
            removeFromCanvas();
        }
    }

    public Point getPosition() {
        return location;
    }

    public void setPosition() {
        wallnut.setPosition(location);
    }

    public void addToCanvas() {
        canvas.add(wallnut);
    }

    public void removeFromCanvas() {
        canvas.remove(wallnut);
    }
    
}

