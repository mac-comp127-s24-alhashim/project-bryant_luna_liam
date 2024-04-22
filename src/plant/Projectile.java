package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Projectile {

    private final String PROJECTILE_SPRITE_PATH;
    private final int PROJECTILE_DAMAGE;
    
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup projectile;
    private Image projectileSprite;

    public Projectile(CanvasWindow canvas, Point location, int damage, String spritePath) {
        this.canvas = canvas;
        this.location = location;
        PROJECTILE_DAMAGE = damage;
        PROJECTILE_SPRITE_PATH = spritePath;
        loadSprite();
        setCenter();
    }

    private void loadSprite() {
        projectileSprite = new Image(PROJECTILE_SPRITE_PATH);
        projectile = new GraphicsGroup();
        projectile.add(projectileSprite);
    }

    private void setCenter() {
        projectile.setCenter(location);
    }

    public Point getPosition() {
        return projectile.getPosition();
    }

    public void updatePosition() {
        projectile.moveBy(+1, 0);
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
}
    
    

    

