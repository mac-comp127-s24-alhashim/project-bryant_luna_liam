package plantsvszombies;

import edu.macalester.graphics.*;
import plant.PlantManager;
import zombies.Zombie;
import zombies.ZombieManager;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;


/**
 * The game of Plants. vs Zombies, programmed in Java.
 * 
 * Authors: Bryant Juarez, Luna Muñoz-Maldonado, William Acosta Macalester College, COMP 127, Prof.
 * Amin G. Alhashim, PhD, 6σ
 */
public class PvZ {
    public static final int CANVAS_WIDTH = 320;
    public static final int CANVAS_HEIGHT = 240;
    public static long frame;
    private static CanvasWindow canvas;
    Random random;

    // Game elements
    private UI ui;
    private ZombieManager zombieManager;
    private Lawn lawn;
    private Image background;
    private PlantManager plantManager;

    public static List<Image> sunflowerSuns;
    public Image gameSun;

    // Player Statistics
    static String playerName;
    public static int sunCount;
    private final short maxSun;
    
    /**
     * Constructs PvZ game
     */
    public PvZ() {
        frame = 0;
        sunCount = 500;
        maxSun = 9999;
        gameSun = null;
        random = new Random();
        sunflowerSuns = new ArrayList<Image>();

        canvas = new CanvasWindow("Plants vs. Zombies: Java Edition", CANVAS_WIDTH, CANVAS_HEIGHT);
        ui = new UI(canvas);
        background = new Image("game/LAWN.png");
        canvas.add(background);
        lawn = new Lawn(canvas);
        lawn.generateLawn();
        zombieManager = new ZombieManager(canvas);
        plantManager = new PlantManager(canvas);
        canvas.add(ui);
    }

    /**
     * Uses Kilt Graphics' canvas.animate function to call the game's logic.
     * Animate runs these tasks up to 60 frames per second.
     */
    public void startAnimation() {
        canvas.animate(runnable -> {
            frame++;

            if ((frame % 1) == 0) {
                for (Zombie zombie : zombieManager.getZombies()) {
                    plantManager.moveProjectiles(zombie);
                    plantManager.runExplosionLogic(zombie);
                }

                // Handles motion of game sun and removes if out of bounds.
                if (gameSun != null) {
                    gameSun.moveBy(0, 0.33);
                    if (gameSun.getY() >= PvZ.CANVAS_HEIGHT) {
                        canvas.remove(gameSun);
                        gameSun = null;
                    }
                }
                
                zombieManager.moveZombies();
            }
            

            // Tasks to run every 90 frames (1.5 seconds)
            if ((frame % 90) == 0) {
                checkLossStatus();
                 
                // Makes peashooters shoot peas
                // if (zombieManager.getZombies().size() > 0) {
                //     plantManager.shootPeas();
                // }

                // 
                if (zombieManager.getZombies() != null) {
                    plantManager.explodeCherryBombs();
                    Iterator<Zombie> zombieIterator = zombieManager.getZombies().iterator();
                    Zombie zombie;
                    while (zombieIterator.hasNext()) {
                        zombie = zombieIterator.next();
                        plantManager.shootPeas(zombie);
                        plantManager.createPotatoMineExplosion(zombie);
                        plantManager.zombieDamagePlant(zombie);
                    }
                }
            }

            // Tasks to run every 1440 frames (24 seconds)
            if ((frame % 1440) == 0) {
                plantManager.produceSunflowerSuns();
            }

            // Tasks to run every 600 frames (10 seconds)
            if ((frame % 600) == 0) {
                spawnGameSun();
            }

            // Tasks to run every 15 seconds
            if ((frame % 900) == 0) {
                plantManager.armPotatoMine();
                zombieManager.zombieSpawn();
            }
        });
    }

    public void handleClicks() {
/*
        * Determines what element is under the mouse when a click occurs, and runs that element's task for
        * clicks accordingly.
        */
        canvas.onClick(handler -> {
            // Checks if the player clicked outside of the window when resized
            if (handler.getPosition().getX() <= 320 && handler.getPosition().getY() <= 240) {
                GraphicsObject clickedObject = canvas.getElementAt(handler.getPosition());

                // Sunflower collecting logic
                if (sunflowerSuns.contains(clickedObject)) {
                    canvas.remove(clickedObject);
                    collectSun();
                }

                // Game sun collecting
                if (clickedObject.equals(gameSun)) {
                    canvas.remove(clickedObject);
                    collectSun();
                    gameSun = null;
                }

                /* Determines if the user clicked the shovel or a seedpacket,
                 * and enables object motion mode.
                 */
                if (UI.objInMotion == false) {
                    if (clickedObject.equals(UI.shovelSprite)) {
                        UI.followMouse(clickedObject, true);
                        UI.shovelMode = true;
                    } else if (UI.seedPackets.contains(clickedObject)) {
                        UI.followMouse(clickedObject, true);
                    }

                /*
                 * Checks to do when in motion mode.
                 */
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

    /**
     * If all conditions are right, spawns a sun.
     */
    private void spawnGameSun() {
        // Check if there is not a sun generated by the game on the canvas.
        if (gameSun == null) {
            Point point = new Point(random.nextInt((PvZ.CANVAS_WIDTH - 0) + 1), -10);
            gameSun = new Image("game/SUN.png");
            gameSun.setPosition(point);
            canvas.add(gameSun);
        }
    }

    /*
     * Collects the game sun.
     */
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
    private void checkLossStatus() {
        // Check if any zombie has reached the end of the lawn
        for (Zombie zombie : zombieManager.getZombies()) {
            if (zombie.getPosition().getX() <= 0) {
                JOptionPane.showMessageDialog(null, "Oh no, a zombie reached your house! Game over!");
                System.exit(0); // Terminate the game
            }
        }
    }
    
    public static void main(String[] args) {
        playerName = JOptionPane.showInputDialog("What is your name?");
        PvZ plantsVsZombies = new PvZ();
        plantsVsZombies.startAnimation();
        plantsVsZombies.handleClicks();
    }
}

