package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class CherryBomb implements Plant {
    
    private static final String SPRITE_PATH = "plants/CHERRYBOMB.png";
    public static final String CHERRYBOMB_SEED_SPRITE_PATH = "game/SEEDPACKET_CHERRYBOMB.png";
    public static final int SUN_COST = 150;
    private static final double RECHARGE_TIME_SECONDS = 40;
    private static final int CHERRYBOMB_DAMAGE = 100;
    private static final int CHERRYBOMB_EXPLOSION_RADIUS = 32;
    
    private CanvasWindow canvas;
    private Point location;
    private GraphicsGroup cherryBomb;
    private Image cherryBombSprite;
    private Explosion explosion;

    public CherryBomb(CanvasWindow canvas, Point location) {
        this.canvas = canvas;
        this.location = location;
        loadSprite();
        setPosition();
    }

    public void loadSprite() {
        cherryBombSprite = new Image(SPRITE_PATH);
        cherryBomb = new GraphicsGroup();
        cherryBomb.add(cherryBombSprite);
    }

    public void action() {
        explosion = new Explosion(canvas, CHERRYBOMB_EXPLOSION_RADIUS, location, CHERRYBOMB_DAMAGE);
        removeFromCanvas();
    }

    public int getSunCost() {
        return SUN_COST;
    }

    public double getRechargeTime() {
        return RECHARGE_TIME_SECONDS;
    }

    public Point getPosition() {
        return location;
    }

    public void setPosition() {
        cherryBomb.setPosition(location);
    }

    public void addToCanvas() {
        canvas.add(cherryBomb);
    }

    public void removeFromCanvas() {
        canvas.remove(cherryBomb);
    }
    
}
