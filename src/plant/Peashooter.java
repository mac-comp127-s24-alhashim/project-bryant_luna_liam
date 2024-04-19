package plant;

import java.util.Timer;
import java.util.TimerTask;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Peashooter implements Plant {

    private static final String PEASHOOTER_SPRITE_PATH = "plants/PLANT_PLACEHOLDER.png";
    public static final String PEASHOOTER_SEED_SPRITE_PATH = "plants/SEEDPACKET_PEASHOOTER.png";
    public static final int SUN_COST = 100;
    private static final double RECHARGE_TIME_SECONDS = 7.5;
    
    public int health = 6;
    private GraphicsGroup peashooter;
    private Image peashooterSprite;

    public Peashooter() {
        loadSprite();
    }

    public void loadSprite() {
        peashooterSprite = new Image(PEASHOOTER_SPRITE_PATH);
        peashooter = new GraphicsGroup();
        peashooter.add(peashooterSprite);
    }

    public void action() {
        // CREATE A PEA WHEN ZOMBIE IS IN THE SAME LANE.
    }

    public int getSunCost() {
        return SUN_COST;
    }

    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }

    public void receiveDamage() {
        health--;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(peashooter);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(peashooter);
    }

}
