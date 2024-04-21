package plantsvszombies;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import edu.macalester.graphics.*;

/*
 * Handles the creation of a sun.
 */
public class Sun extends GraphicsGroup {
    private final int SUN_VALUE = 25;
    private CanvasWindow canvas;
    private Point location;
    private Image sunSprite;
    private GraphicsGroup sun;
    private boolean spawnType;
    private double time;

    /**
     * Creates a sun.
     * @param canvas
     * @param location
     * @param spawnType Set true if spawned by game, false if spawned by a sunflower.
     */
    public Sun(Point location, Boolean spawnType) {
        this.location = location;
        this.spawnType = spawnType;
        loadSprite();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Every 250ms, the sun's position gets updated.
        Runnable sunRunnable = () -> {
            time++;
            updatePosition();
        };
            
        ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(sunRunnable, 0, 250, TimeUnit.MILLISECONDS);
    }

    /**
     * Removes the sun sprite and updates the player's sun value.
     * This should only be run when the user clicks on this sun.
     */
    public void click() {
        PvZ.sunCount = PvZ.sunCount + SUN_VALUE;
        remove(sunSprite);
    }

    private void loadSprite() {
        sunSprite = new Image("game/SUN.png");
        setCenter(location);
        add(sunSprite);
    }

    public void updatePosition() {
        // The sun will not move if it is not spawned by the game.
        if (spawnType == true) {
            moveBy(0, 1);
        }
    }
}
