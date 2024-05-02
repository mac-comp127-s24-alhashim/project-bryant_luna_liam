package plantsvszombies;

import edu.macalester.graphics.*;

/*
 * Handles the creation of a sun.
 */
public class Sun extends GraphicsGroup {
    
    private final int SUN_VALUE = 25;
    private Point location;
    static Image sunSprite;
    private boolean spawnType;

    /**
     * Creates a sun.
     * @param canvas
     * @param location
     * @param spawnType Set true if spawned by game, false if spawned by a sun producer.
     */
    public Sun(Point location, Boolean spawnType) {
        this.location = location;
        this.spawnType = spawnType;
        loadSprite();
    }

    public void runScheduledTasks() {
        if ((PvZ.frame % 50) == 0) updatePosition();
    }

    /**
     * Removes the sun sprite and updates the player's sun value.
     * This should only be run when the user clicks on this sun.
     */
    public void click() {
        PvZ.sunCount += SUN_VALUE;
        remove(sunSprite);
    }
    /**
     * Loads sun sprite 
     */
    private void loadSprite() {
        sunSprite = new Image("game/SUN.png");
        setCenter(location);
        add(sunSprite);
    }
    /**
     * Updates position of sun and makes it so that the sun will not move if it is not spawned by the game.
     */
    public void updatePosition() {
        if (spawnType == true) {
            moveBy(0, 1);
        }
    }
}
