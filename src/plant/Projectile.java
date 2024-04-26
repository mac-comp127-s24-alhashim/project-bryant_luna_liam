package plant;

import java.util.List;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;
import zombies.*;

public class Projectile extends GraphicsGroup {

    private final String PROJECTILE_SPRITE_PATH;
    private final int PROJECTILE_DAMAGE;
    
    private Image projectileSprite;

    public Projectile(Point location, int damage, String spritePath) {
        PROJECTILE_DAMAGE = damage;
        PROJECTILE_SPRITE_PATH = spritePath;
        projectileSprite = new Image(PROJECTILE_SPRITE_PATH);
        setPosition(location);
        add(projectileSprite);
    }

    // public void updatePosition() {
    //     projectile.moveBy(+1, 0);
    //     if (projectile.getX() <= PvZ.CANVAS_WIDTH + projectile.getWidth() && projectile.getX() >= 0) {
    //         remove(projectile);
    //     }
    // }

    public int getDamage() {
        return PROJECTILE_DAMAGE;
    }

    // public void dealDamage() {
    //     for (NormalZombie zombie : ZombieManager.getZombies()) {
    //         if (zombie.checkCollisions(this)) {
    //             zombie.reduceHealth(PROJECTILE_DAMAGE);
    //         }
    //     }
    // }
}
    
    

    

