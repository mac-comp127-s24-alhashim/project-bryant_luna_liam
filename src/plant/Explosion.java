package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Point;

import java.awt.Color;

public class Explosion extends GraphicsGroup {

    private final Color EXPLOSION_COLOR = new Color(255, 87, 0, 128);
    private final Color EXPLOSION_OUTLINE_COLOR = new Color(255, 0, 0, 128);
    private final int EXPLOSION_DAMAGE;

    private Ellipse explosion;
    private double radius;
    private Point location;
    /**
     * Constructs explosion
     */
    public Explosion(double radius, Point location, int damage) {
        this.radius = radius;
        this.location = location;
        EXPLOSION_DAMAGE = damage;
        explosion = new Ellipse(0, 0, radius * 2, radius * 2);
        createExplosionDrawing();
    }
    /**
     * Creates explosion drawing.
     */
    private void createExplosionDrawing() {
        explosion.setFillColor(EXPLOSION_COLOR);
        explosion.setStrokeColor(EXPLOSION_OUTLINE_COLOR);
        explosion.setCenter(location.getX() + 16, location.getY() + 16);
        add(explosion);
    }

    /**
     * Gets damage
     * @return
     */
    public int getDamage() {
        return EXPLOSION_DAMAGE;
    }
    /**
     * Gets radius
     * @return
     */
    public double getRadius() {
        return radius;
    }
    
}