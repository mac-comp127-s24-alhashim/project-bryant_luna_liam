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
    private GraphicsGroup pea;
    private Image peaSprite;

    public Projectile(CanvasWindow canvas, Point location, int damage, String spritePath) {
        this.canvas = canvas;
        this.location = location;
        PROJECTILE_DAMAGE = damage;
        PROJECTILE_SPRITE_PATH = spritePath;
        loadSprite();
        setCenter();
    }

    private void loadSprite() {
        peaSprite = new Image(PROJECTILE_SPRITE_PATH);
        pea = new GraphicsGroup();
        pea.add(peaSprite);
    }

    private void setCenter() {
        pea.setCenter(location);
    }

    public Point getPosition() {
        return pea.getPosition();
    }

    public void updatePosition() {
        pea.moveBy(+1, 0);
    }

    public void addToCanvas() {
        canvas.add(pea);
    }

    public void removeFromCavas() {
        canvas.remove(pea);
    }
}
    
    

    

