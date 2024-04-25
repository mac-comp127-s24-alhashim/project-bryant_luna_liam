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
    
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup projectile;
    private Image projectileSprite;
    private List<Projectile> projectiles;

    public Projectile(CanvasWindow canvas, Point location, int damage, String spritePath, List<Projectile> projectiles) {
        this.canvas = canvas;
        this.location = location;
        this.projectiles = projectiles;
        PROJECTILE_DAMAGE = damage;
        PROJECTILE_SPRITE_PATH = spritePath;
        loadSprite();
        setPosition();
    }

    private void loadSprite() {
        projectileSprite = new Image(PROJECTILE_SPRITE_PATH);
        projectile = new GraphicsGroup();
        projectile.add(projectileSprite);
    }

    private void setPosition() {
        projectile.setPosition(location);
    }

    public Point getPosition() {
        return projectile.getPosition();
    }

    public void updatePosition() {
        projectile.moveBy(+1, 0);
        if (projectile.getX() <= PvZ.CANVAS_WIDTH + projectile.getWidth() && projectile.getX() >= 0) {
            canvas.remove(projectile);
            projectiles.remove(this);
        }
    }

    public int getDamage() {
        return PROJECTILE_DAMAGE;
    }

    public void addToCanvas() {
        canvas.add(projectile);
    }

    public void removeFromCavas() {
        canvas.remove(projectile);
    }

    public void dealDamage() {
        for (NormalZombie zombie : ZombieManager.getZombies()) {
            if (zombie.checkCollisions(projectile)) {
                zombie.reduceHealth(PROJECTILE_DAMAGE);
            }
        }
    }
}
    
    

    

