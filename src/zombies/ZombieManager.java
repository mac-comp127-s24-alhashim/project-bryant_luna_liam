package zombies;

import java.util.ArrayList;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import plantsvszombies.GrassTile;
import plantsvszombies.Lawn;
import plantsvszombies.PvZ;

/**
 * Handles the random spawning of zombies on the grid.
 */
public class ZombieManager {
    final int GRACE_TIME;
    int spawnRate;
    ArrayList<NormalZombie> zombieList = new ArrayList<NormalZombie>();
    ArrayList<Point> tileList = new ArrayList<Point>();
    CanvasWindow canvas;
    
    public ZombieManager(CanvasWindow canvas) {
        GRACE_TIME = 3;
        spawnRate = 20;
        this.canvas = canvas;
        tileList.add(Lawn.getGrassTilePosition(10-1));
        tileList.add(Lawn.getGrassTilePosition(20-1));
        tileList.add(Lawn.getGrassTilePosition(30-1));
        tileList.add(Lawn.getGrassTilePosition(40-1));
        tileList.add(Lawn.getGrassTilePosition(50-1));
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
     * Zombies will not spawn within the set grace time, and
     * one zombie will spawn at the set spawn rate.
     */
    private void zombieSpawn() {
        Random random = new Random();
        if (PvZ.getTime() >= GRACE_TIME) {
            if ((PvZ.getTime() % spawnRate) == 0) {
                Point chosenPos = tileList.get(random.nextInt((4 - 0) + 1) + 0);
                double x = chosenPos.getX() + (GrassTile.TILE_SIZE - (GrassTile.TILE_SIZE * 0.25));
                // Weird bug where zombies spawn one tile under, dirty
                // fix is to just subtract a tile
                double y = ((NormalZombie.ZOMBIE_HEIGHT - GrassTile.TILE_SIZE) + chosenPos.getY()) - GrassTile.TILE_SIZE;
                NormalZombie zombie = new NormalZombie(x, y);
                zombieList.add(zombie);
                canvas.add(zombie);
                canvas.draw();
            } 
        }
    }
}
