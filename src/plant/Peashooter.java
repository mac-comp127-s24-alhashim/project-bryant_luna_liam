package plant;

import java.util.List;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;

public class Peashooter extends GraphicsGroup {

    private static final String SPRITE_PATH = "plants/PEASHOOTER.png";
    public static final String SEED_SPRITE_PATH = "game/SEEDPACKET_PEASHOOTER.png";
    public final static String PEA_SPRITE_PATH = "plants/PEASHOOTER_PEA.png";
    public static final int SUN_COST = 100;
    private final int RECHARGE_TIME_SECONDS = 7500;
    private final int PEA_SHOOTING_RATE = 1500;
    final static int PEASHOOTER_DAMAGE = 1;
    
    public int health = 6;
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup peashooter;
    private Image peashooterSprite;
    private List<Projectile> peas;

    public Peashooter() {
        peas = new ArrayList<Projectile>();
        peashooterSprite = new Image(SPRITE_PATH);
        add(peashooterSprite);
        PvZ.sunCount -= SUN_COST;
    }

    // /**
    //  * Activates the pea shooting when there's a zombie in the Peashooter's lane.  
    //  */
    // public void runScheduledTasks () {
    //     if ((PvZ.time % PEA_SHOOTING_RATE) == 0) action();
    //     for (Projectile pea : peas) pea.updatePosition();
    // }
    
    // /**
    //  * Shoots a pea.
    //  */
    // public void action() {
    //     Projectile pea = new Projectile(getPosition(), PEASHOOTER_DAMAGE, PEA_SPRITE_PATH);
    //     peas.add(pea);
    //     pea.addToCanvas();    
    // }

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
            remove(peashooterSprite);
        }
    }
}
