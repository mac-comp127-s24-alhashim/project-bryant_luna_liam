package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;

public class Peashooter implements Plant {

    private static final String SPRITE_PATH = "plants/PEASHOOTER.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_PEASHOOTER.png";
    public final String PEASHOOTER_PEA_SPRITE_PATH = "plants/PEASHOOTER_PEA.png";
    public static final int SUN_COST = 100;
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

    /**
     * Loads the peashooter sprite.
     */
    public void loadSprite() {
        peashooterSprite = new Image(SPRITE_PATH);
        peashooter = new GraphicsGroup();
        peashooter.add(peashooterSprite);
        addToCanvas();
        PvZ.sunCount -= SUN_COST;
    }

    /**
     * Activates the pea shooting when there's a zombie in the Peashooter's lane.  
     */
    public void actionActivator() {
        action();
    }
    /**
     * Shoots a pea.
     */
    public void action() {
        Projectile pea = new Projectile(canvas, getPosition(), PEASHOOTER_DAMAGE, PEASHOOTER_PEA_SPRITE_PATH);
        pea.addToCanvas();
    }

    /**
     * @return Peashooter's sun cost.
     */
    public int getSunCost() {
        return SUN_COST;
    }

    /**
     * @return Peashooter's recharge time.
     */
    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }

    /**
     * @return Peashooter's fire rate.
     */
    public double getFireRate() {
        return PEA_SHOOTING_RATE;
    }

    /**
     * Substracts the Peashooter's health by one.
     */
    public void receiveDamage() {
        health--;
        checkDeath();
    }

    /**
     * If Peashooter's health goes below zero, it is removed from canvas.
     */
    public void checkDeath() {
        if (health <= 0) {
            removeFromCanvas();
        }
    }
    
    /**
     * @return Peashooter's location.
     */
    public Point getPosition() {
        return location;
    }

    /**
     * Sets the Peashooter's position to the given location.
     */
    public void setPosition() {
        peashooter.setPosition(location);
    }
    
    /**
     * Adds Peashooter to the canvas.
     */
    public void addToCanvas() {
        canvas.add(peashooter);
    }

    /**
     * Removes Peashooter from the canvas.
     */
    public void removeFromCanvas() {
        canvas.remove(peashooter);
    }

}
