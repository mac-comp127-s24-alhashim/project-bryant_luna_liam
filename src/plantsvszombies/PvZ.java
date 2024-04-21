package plantsvszombies;

import edu.macalester.graphics.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import zombies.ZombieManager;

/**
 * The game of Plants. vs Zombies, programmed in Java.
 * 
 * Authors: Bryant Juarez, Luna Muñoz-Maldonado, William Acosta
 * Macalester College, COMP 127, Prof. Amin G. Alhashim, PhD, 6σ
 */
public class PvZ {
    public static final int CANVAS_WIDTH = 320;
    public static final int CANVAS_HEIGHT = 240;

    private static CanvasWindow canvas = new CanvasWindow("Plants vs. Zombies: Java Edition", CANVAS_WIDTH, CANVAS_HEIGHT);;

    private static int timeInSeconds = 0;

    // Game elements
    private UI ui = new UI(canvas);
    private ZombieManager zombieManager;
    private Lawn lawn;
    private Image background = new Image("game/LAWN.png");

    // Player Statistics
    private static String playerName = "Bryant";
    private static int sunCount = 0;
    private static int zombiesKilled = 0;
    private final short maxSun = 9999;
    
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public PvZ() {
        background.setPosition(0, 0);
        canvas.add(background);
        lawn = new Lawn(canvas);
        zombieManager = new ZombieManager(canvas);
        canvas.add(ui);

        // Gets called every second
        Runnable pvzRunnable = () -> {
            timeInSeconds++;
            zombieManager.runScheduledTasks();
        };
            
        ScheduledFuture<?> mainScheduledFuture = executor.scheduleAtFixedRate(pvzRunnable, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        PvZ plantsVsZombies = new PvZ();
    }

    /**
     * Returns the elapsed program time, in seconds.
     * @return
     */
    public static int getTime() {
        return timeInSeconds;
    }

    /**
     * Returns the player's current sun count.
     * @return
     */
    public static int getSunCount() {
        return sunCount;
    }

    /**
     * Gets the player's name.
     * @return
     */
    public static String getPlayerName() {
        return playerName;
    }

    // TODO: implement Sun Spawning
    private void spawnSun() {
        System.out.println("BAZINGA!");
    }
}
