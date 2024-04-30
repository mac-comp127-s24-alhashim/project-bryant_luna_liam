package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Point;

import zombies.*;

import java.awt.Color;

public class Explosion extends GraphicsGroup {

    private final Color EXPLOSION_COLOR = new Color(255, 87, 0, 128);
    private final Color EXPLOSION_OUTLINE_COLOR = new Color(255, 0, 0, 128);
    private final int EXPLOSION_DAMAGE;

    private CanvasWindow canvas;
    private Ellipse explosion;
    private double radius;
    private Point location;

    public Explosion(double radius, Point location, int damage) {
        this.radius = radius;
        this.location = location;
        EXPLOSION_DAMAGE = damage;
        explosion = new Ellipse(0, 0, radius * 2, radius * 2);
        createExplosionDrawing();
    }

    private void createExplosionDrawing() {
        explosion.setFillColor(EXPLOSION_COLOR);
        explosion.setStrokeColor(EXPLOSION_OUTLINE_COLOR);
        explosion.setCenter(location.getX() + 16, location.getY() + 16);
    }

    public int getDamage() {
        return EXPLOSION_DAMAGE;
    }

    // public void dealDamage(ZombieManager zombieManager) {
    //     for (NormalZombie zombie : zombieManager.getZombies()) {
    //         if (zombie.checkCollisions(explosion)) {
    //             zombie.reduceHealth(EXPLOSION_DAMAGE);
    //         }
    //     }
    // }
    
}