package zombies;

import java.util.ArrayList;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;

import plantsvszombies.GrassTile;
import plantsvszombies.Lawn;
import plantsvszombies.PvZ;

/**
 * Handles the random spawning of zombies on the grid.
 */
public class ZombieManager {
    int spawnRate;
    ArrayList<NormalZombie> zombieList = new ArrayList<NormalZombie>();
    ArrayList<GrassTile> tileList = new ArrayList<GrassTile>();
    CanvasWindow canvas;
    
    public ZombieManager(CanvasWindow canvas) {
        spawnRate = 20;
        this.canvas = canvas;
        tileList.add(Lawn.getGrassTile(10-1));
        tileList.add(Lawn.getGrassTile(20-1));
        tileList.add(Lawn.getGrassTile(30-1));
        tileList.add(Lawn.getGrassTile(40-1));
        tileList.add(Lawn.getGrassTile(50-1));
    }

    public void runScheduledTasks() {
        moveZombies();
        zombieSpawn();
    }

    /*
     * Moves all the zombies on the canvas.
     */
    private void moveZombies() {
        for (NormalZombie zombie : zombieList) zombie.move();
    }

    /*
     * If all conditions are right, spawns a zombie.
     * Zombies will not spawn within the first 10 seconds, and
     * one zombie will spawn at every 20 seconds.
     */
    private void zombieSpawn() {
        Random random = new Random();
        if (PvZ.getTime() >= 10) {
            if ((PvZ.getTime() % spawnRate) == 0) {
                GrassTile chosenTile = tileList.get(random.nextInt((3 - 0) + 1) + 0);
                NormalZombie zombie = new NormalZombie(chosenTile.getX(), chosenTile.getY());
                zombieList.add(zombie);
                canvas.add(zombie);
                canvas.draw();
            } 
        }
    }
}
