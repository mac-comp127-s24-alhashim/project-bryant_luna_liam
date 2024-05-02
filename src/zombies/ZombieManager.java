package zombies;

import java.util.ArrayList;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;
import plant.Explosion;
import plantsvszombies.GrassTile;
import plantsvszombies.Lawn;
import plantsvszombies.PvZ;

/**
 * Handles the random spawning of zombies on the grid.
 */
public class ZombieManager {
    final int GRACE_TIME;
    int spawnRate;
    static ArrayList<Zombie> zombieList;
    ArrayList<Explosion> zombieExplosions;
    ArrayList<Point> tileList;
    CanvasWindow canvas;
    
    /**
     * Creates a new zombie manager.
     */
    public ZombieManager(CanvasWindow canvas) {
        
        GRACE_TIME = 300;
        spawnRate = 20000;
        zombieList = new ArrayList<Zombie>();
        zombieExplosions = new ArrayList<Explosion>();
        tileList = new ArrayList<Point>();

        this.canvas = canvas;
        tileList.add(Lawn.getGrassTilePosition(9));
        tileList.add(Lawn.getGrassTilePosition(19));
        tileList.add(Lawn.getGrassTilePosition(29));
        tileList.add(Lawn.getGrassTilePosition(39));
        tileList.add(Lawn.getGrassTilePosition(49));
    }

    /*
     * Moves all the zombies.
     */
    public void moveZombies() {
        for (Zombie zombie : zombieList) zombie.move();
    }
    
    /**
     * If all conditions are right, spawns a zombie.
     * Zombies will not spawn within the set grace time, and
     * one zombie will spawn at the set spawn rate.
     */
    public void zombieSpawn() {
        Random random = new Random();
        if (PvZ.frame >= GRACE_TIME) {
            Point chosenPos = tileList.get(random.nextInt((4 - 0) + 1) + 0);
            double x = chosenPos.getX() + (GrassTile.TILE_SIZE - (GrassTile.TILE_SIZE * 0.25));
            double y = ((Zombie.ZOMBIE_HEIGHT - GrassTile.TILE_SIZE) + chosenPos.getY()) - GrassTile.TILE_SIZE;
            Zombie zombie = new Zombie(x, y);
            zombieList.add(zombie);
            canvas.add(zombie);
            canvas.draw();
        }
    }

    /**
     * Returns all zombies.
     * @return
     */
    public ArrayList<Zombie> getZombies() {
        return zombieList;
    }

    /**
     * Removes the specified zombie.
     * @param zombie The zombie to remove.
     */
    public void removeZombie(Zombie zombie) {
        if (zombie.getHealth() <= 0) {
            zombieList.remove(zombie);
            canvas.remove(zombie);
        }
    }
}
