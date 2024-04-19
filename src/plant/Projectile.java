package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Projectile {

    private static final String PEA_SPRITE_PATH = "plants/PEASHOOTER_PEA.png";
    private final int PROJECTILE_DAMAGE;
    
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup pea;
    private Image peaSprite;

    public Projectile(CanvasWindow canvas, Point location, int damage) {
        this.canvas = canvas;
        this.location = location;
        PROJECTILE_DAMAGE = damage;
        loadSprite();
        setCenter();
    }

    private void loadSprite() {
        peaSprite = new Image(PEA_SPRITE_PATH);
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
    
    

    

