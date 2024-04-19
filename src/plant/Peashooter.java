package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Peashooter implements Plant {

    private static final String PEASHOOTER_SPRITE_PATH = "plants/PLANT_PLACEHOLDER.png";
    public static final String PEASHOOTER_SEED_SPRITE_PATH = "plants/SEEDPACKET_PEASHOOTER.png";
    public final int SUN_COST = 100;
    private final double RECHARGE_TIME_SECONDS = 7.5;
    private final double PEA_SHOOTING_RATE = 1.5;
    private final int PEASHOOTER_DAMAGE = 1;
    
    public int health = 6;
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup peashooter;
    private Image peashooterSprite;

    public Peashooter(CanvasWindow canvas, Point location) {
        this.canvas = canvas;
        this.location = location;
        loadSprite();
        setPosition();
    }

    public void loadSprite() {
        peashooterSprite = new Image(PEASHOOTER_SPRITE_PATH);
        peashooter = new GraphicsGroup();
        peashooter.add(peashooterSprite);
    }

    public void actionActivator() {
        // ACTIVATE ACTION WHEN THERE IS A ZOMBIE IN PEASHOOTER'S LANE
        action();
    }

    public void action() {
        Projectile pea = new Projectile(canvas, getPosition(), PEASHOOTER_DAMAGE);
        pea.addToCanvas();
    }

    public int getSunCost() {
        return SUN_COST;
    }

    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }

    public double getFireRate() {
        return PEA_SHOOTING_RATE;
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
        peashooter.setPosition(location);
    }

    public void addToCanvas() {
        canvas.add(peashooter);
    }

    public void removeFromCanvas() {
        canvas.remove(peashooter);
    }

}
