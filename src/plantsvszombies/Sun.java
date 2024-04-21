package plantsvszombies;

import edu.macalester.graphics.*;

/*
 * Handles the creation and spawning of collectible suns.
 */
public class Sun {
    private final int SUN_VALUE = 25;

    private CanvasWindow canvas;
    private Point location;
    private Image sunSprite;
    private GraphicsGroup sun;
    private boolean spawnType; // TRUE = spawned by game | FALSE = spawned by a sun producer

    public Sun(CanvasWindow canvas, Point location, Boolean spawnType) {
        this.canvas = canvas;
        this.location = location;
        this.spawnType = spawnType;
        loadSprite();
        setCenter();
    }

    private void loadSprite() {
        sunSprite = new Image("game/SUN.png");
        sun = new GraphicsGroup();
        sun.add(sunSprite);
    }

    private void setCenter() {
        sun.setCenter(location);
    }

    public void addToCanvas() {
        canvas.add(sun);
    }

    public void updatePosition() {
        if (spawnType == true) {
            sun.moveBy(0, -1);
        }
    }

    // public void clickSun(Player player) {
    //     player.changeSunCount(SUN_VALUE);
    //     removeSun(canvas);
    // }

    private void removeSun(CanvasWindow canvas){
        canvas.remove(sun);
    }
    
}
