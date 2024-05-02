package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

/**
 * A projectile, shot by Peashooters, that harms Zombies.
 */
public class Projectile extends GraphicsGroup {

    private final String PROJECTILE_SPRITE_PATH;
    private final int PROJECTILE_DAMAGE;
    
    private Image projectileSprite;

    /**
     * Constructs a projectile.
     */
    public Projectile(Point location, int damage, String spritePath) {
        PROJECTILE_DAMAGE = damage;
        PROJECTILE_SPRITE_PATH = spritePath;
        projectileSprite = new Image(PROJECTILE_SPRITE_PATH);
        setPosition(location);
        moveBy(32 - projectileSprite.getWidth() / 2, 0);
        add(projectileSprite);
    }

    /**
     * Returns the damage value that this projectile does.
     * @return
     */
    public int getDamage() {
        return PROJECTILE_DAMAGE;
    }
}
    
    

    

