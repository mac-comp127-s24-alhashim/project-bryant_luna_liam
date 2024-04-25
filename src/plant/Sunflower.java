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
    private static final double RECHARGE_TIME_SECONDS = 24000;
    private static final double SUN_PRODUCTION_RATE = 24000;
    
    public int health = 6;
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup sunflower;
    private Image sunflowerSprite;

    public Sunflower() {
        this.canvas = canvas;
        this.location = location;
        loadSprite();
        setPosition();
        PvZ.sunCount -= SUN_COST;
    }

    public void loadSprite() {
        sunflowerSprite = new Image(SPRITE_PATH);
        sunflower = new GraphicsGroup();
        sunflower.add(sunflowerSprite);
        addToCanvas();
    }

    public void runScheduledPlantTasks() {
        if ((PvZ.time % SUN_PRODUCTION_RATE) == 0) action();
    }

    public void action() {
        Sun sun = new Sun(getCenter(), false);
        canvas.add(sun);
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

    @Override
    public void runScheduledTasks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runScheduledTasks'");
    }
    
}
