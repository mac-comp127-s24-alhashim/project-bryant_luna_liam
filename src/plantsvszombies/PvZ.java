package plantsvszombies;

import edu.macalester.graphics.*;
import plant.*;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import zombies.*;

/**
 * The game of Plants. vs Zombies, programmed in Java.
 * 
 * Authors: Bryant Juarez, Luna Muñoz-Maldonado, William Acosta Macalester College, COMP 127, Prof.
 * Amin G. Alhashim, PhD, 6σ
 */
public class PvZ {
    public static final int CANVAS_WIDTH = 320;
    public static final int CANVAS_HEIGHT = 240;

    private static CanvasWindow canvas = new CanvasWindow("Plants vs. Zombies: Java Edition", CANVAS_WIDTH,
        CANVAS_HEIGHT);;

    public static long frame = 0;

    // Game elements
    private UI ui = new UI(canvas);
    private ZombieManager zombieManager;
    private Lawn lawn;
    private Image background = new Image("game/LAWN.png");
    private PlantManager plantManager;
    private int spawnSpeed = 1500;

    public static List<Image> sunflowerSuns;
    public Image gameSun;


    // Player Statistics
    private static String playerName;
    public static int sunCount = 9999;
    private static int zombiesKilled = 0;
    private final short maxSun = 9999;
    Random random = new Random();

    // ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public PvZ() {
        canvas.add(background);
        lawn = new Lawn(canvas);
        gameSun = null; // No suns when constructed
        zombieManager = new ZombieManager(canvas);
        plantManager = new PlantManager(canvas);
        sunflowerSuns = new ArrayList<Image>();
        canvas.add(ui);

        // Gets called every millisecond
        canvas.animate(runnable -> {
            frame++;

            // Tasks to run every 1 frame
            if ((frame % 1) == 0) {
                for (Zombie zombie : zombieManager.getZombies()) {
                    plantManager.moveProjectiles(zombie);
                    plantManager.explode(zombie);
                    // if (zombie.getHealth() <= 0) {
                    // // zombieManager.getZombies().remove(zombie);
                    // }
                }
                if (gameSun != null) {
                    gameSun.moveBy(0, 0.33);
                    if (gameSun.getY() >= PvZ.CANVAS_HEIGHT) {
                        canvas.remove(gameSun);
                        gameSun = null;
                    }
                }
                zombieManager.moveZombies();
                if (frame % 600 == 0) {
                    checkGameStatus();
                }
            }

            // Tasks to run every 1.5 seconds
            if ((frame % 90) == 0) {

                if (zombieManager.getZombies().size() > 0) {
                    plantManager.shootProjectile();
                }

                if (zombieManager.getZombies() != null) {
                    plantManager.createCherryBombExplosion();
                    Iterator<Zombie> zombieIterator = zombieManager.getZombies().iterator();
                    Zombie zombie;
                    while (zombieIterator.hasNext()) {
                        zombie = zombieIterator.next();
                        plantManager.createPotatoMineExplosion(zombie);
                        plantManager.zombieDamagePlant(zombie);
                    }
                    // Iterator<Explosion> explosionIterator = plantManager.getExplosions().iterator();
                    // Explosion explosion;
                    // while (explosionIterator.hasNext()) {
                    // explosion = explosionIterator.next();
                    // zombieManager.createZombieExplosion();
                    // plantManager.explosionsDamagePlant(explosion);
                    // }
                }
            }

            // Tasks to run every 24 seconds
            if ((frame % 1440) == 0) {
                plantManager.produceSunflowerSuns();
            }

            // Tasks to run every 10 seconds
            if ((frame % 600) == 0) {
                spawnSun();
            }

            // Tasks to run every 15 seconds
            if ((frame % 60) == 0) {
                plantManager.armPotatoMine();
                zombieManager.zombieSpawn();
            }

            // Zombie Spawn
            // if ((frame % 3600) == 0) {
            // if (spawnSpeed >= 300) {
            // spawnSpeed /= 1.12;
            // }
            // }
            // if ((frame % spawnSpeed) == 0) {
            // zombieManager.zombieSpawn();
            // }
            // }
        });

        /*
         * Determines what element is under the mouse when a click occurs, and runs that element's task for
         * clicks accordingly.
         */
        canvas.onClick(handler -> {

            // NULL HANDLER
            if (handler.getPosition().getX() > 320 || handler.getPosition().getY() > 240) {
                // NOTHING
            } else {
                GraphicsObject clickedObject = canvas.getElementAt(handler.getPosition());
                Image sunImage = new Image("game/SUN.png");

                // Check if the clicked object is a sun produced by a sunflower
                if (sunflowerSuns.contains(clickedObject)) {
                    canvas.remove(clickedObject);
                    collectSun();
                    // // Only one sun generated by the game can be on the canvas
                    // ui.update();
                }

                if (clickedObject.equals(gameSun)) {
                    canvas.remove(clickedObject);
                    collectSun();
                    gameSun = null;
                }


                if (UI.objInMotion == false) {
                    if (clickedObject.equals(UI.shovelSprite)) {
                        UI.followMouse(clickedObject, true);
                        UI.shovelMode = true;
                    } else if (UI.seedPackets.contains(clickedObject)) {
                        UI.followMouse(clickedObject, true);
                    }
                } else {
                    UI.centerButtons();
                    UI.objInMotion = false;

                    Point plantPoint = Lawn.getPlantPoint(handler.getPosition());
                    if (UI.shovelMode) {
                        plantManager.removePlant(clickedObject);
                    } else if (plantPoint != null) { // Out of bounds check
                        if (clickedObject.equals(UI.sunflowerPacket)) {
                            plantManager.addPlant(0, plantPoint);
                        } else if (clickedObject.equals(UI.peashooterPacket)) {
                            plantManager.addPlant(1, plantPoint);
                        } else if (clickedObject.equals(UI.wallnutPacket)) {
                            plantManager.addPlant(2, plantPoint);
                        } else if (clickedObject.equals(UI.potatoMinePacket)) {
                            plantManager.addPlant(3, plantPoint);
                        } else if (clickedObject.equals(UI.cherryBombPacket)) {
                            plantManager.addPlant(4, plantPoint);
                        }
                    }
                }
                ui.update();
            }
        });
    }

    public static void main(String[] args) {
        playerName = JOptionPane.showInputDialog("What is your name?");
        PvZ plantsVsZombies = new PvZ();
    }

    /**
     * Returns the elapsed program time, in seconds.
     * 
     * @return
     */
    public static long getFrame() {
        return frame;
    }

    /**
     * Gets the player's name.
     * 
     * @return
     */
    public static String getPlayerName() {
        return playerName;
    }

    /**
     * If all conditions are right, spawns a sun.
     */
    private void spawnSun() {
        // Check if there is not a sun generated by the game on the canvas.
        if (gameSun == null) {
            Point point = new Point(random.nextInt((PvZ.CANVAS_WIDTH - 0) + 1), -10);
            gameSun = new Image("game/SUN.png");
            gameSun.setPosition(point);
            canvas.add(gameSun);
        }
    }

    private void collectSun() {
        if (sunCount >= maxSun) {
            sunCount = maxSun;
        } else {
            sunCount += 25;
        }
    }

    /**
     * Returns whether or not a zombie has reached the end of the lawn to determine if a user has lost
     * the game.
     */
    private void checkGameStatus() {
        // Check if any zombie has reached the end of the lawn
        for (Zombie zombie : zombieManager.getZombies()) {
            if (zombie.getPosition().getX() <= 0) {
                JOptionPane.showMessageDialog(null, "Oh no, a zombie reached your house! Game over!");
                System.exit(0); // Terminate the game
            }
        }
    }
}

