package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

import plantsvszombies.Sun;

public class Sunflower implements Plant {

    private static final String SUNFLOWER_SPRITE_PATH = "plants/SUNFLOWER.png";
    public static final String SUNFLOWER_SEED_SPRITE_PATH = "plants/SEEDPACKET_SUNFLOWER.png";
    public static final int SUN_COST = 50;
    private static final double RECHARGE_TIME_SECONDS = 24;
    private static final double SUN_PRODUCTION_RATE = 24;
    
    public int health = 6;
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup sunflower;
    private Image sunflowerSprite;

    public Sunflower(CanvasWindow canvas, Point location) {
        this.canvas = canvas;
        this.location = location;
        loadSprite();
        setPosition();
    }

    public void loadSprite() {
        sunflowerSprite = new Image(SUNFLOWER_SPRITE_PATH);
        sunflower = new GraphicsGroup();
        sunflower.add(sunflowerSprite);
    }

    public void actionActivator() {
        // EVERY 24 SECONDS.
        action();
    }

    public void action() {
        Sun sun = new Sun(canvas, getCenter(), false);
        sun.addToCanvas();
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

    public Point getCenter() {
        return sunflower.getCenter();
    }

    public void setPosition() {
        sunflower.setPosition(location);
    }

    public void addToCanvas() {
        canvas.add(sunflower);
    }

    public void removeFromCanvas() {
        canvas.remove(sunflower);
    }
    
}
