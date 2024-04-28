package zombies;

import java.util.ArrayList;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;
import plant.Projectile;
import plant.Sunflower;
import plant.Peashooter;
import plant.Wallnut;
import plantsvszombies.GrassTile;
import plantsvszombies.Lawn;
import plantsvszombies.PvZ;

/**
 * Handles the random spawning of zombies on the grid.
 */
public class ZombieManager {
    final int GRACE_TIME;
    int spawnRate;
    static ArrayList<Zombie> zombieList = new ArrayList<Zombie>();
    ArrayList<Point> tileList = new ArrayList<Point>();
    CanvasWindow canvas;
    
    public ZombieManager(CanvasWindow canvas) {
        GRACE_TIME = 0;
        spawnRate = 20000;
        this.canvas = canvas;
        tileList.add(Lawn.getGrassTilePosition(9));
        tileList.add(Lawn.getGrassTilePosition(19));
        tileList.add(Lawn.getGrassTilePosition(29));
        tileList.add(Lawn.getGrassTilePosition(39));
        tileList.add(Lawn.getGrassTilePosition(49));
    }

    /*
     * Moves all the zombies on the canvas.
     */
    public void moveZombies() {
        for (Zombie zombie : zombieList) zombie.move();
    }
    
    /*
     * If all conditions are right, spawns a zombie.
     * Zombies will not spawn within the set grace time, and
     * one zombie will spawn at the set spawn rate.
     */
    public void zombieSpawn() {
        Random random = new Random();
        if (PvZ.getFrame() >= GRACE_TIME) {
            Point chosenPos = tileList.get(random.nextInt((4 - 0) + 1) + 0);
            double x = chosenPos.getX() + (GrassTile.TILE_SIZE - (GrassTile.TILE_SIZE * 0.25));
            // Weird bug where zombies spawn one tile under, dirty
            // fix is to just subtract a tile
            double y = ((Zombie.ZOMBIE_HEIGHT - GrassTile.TILE_SIZE) + chosenPos.getY()) - GrassTile.TILE_SIZE;
            Zombie zombie = new Zombie(x, y);
            zombieList.add(zombie);
            canvas.add(zombie);
            canvas.draw();
        }
    }

    /*
     * 
     */
    public ArrayList<Zombie> getZombies() {
        return zombieList;
    }

    public void removeZombie(Zombie zombie) {
        if (zombie.getHealth() <= 0) {
            zombieList.remove(zombie);
            canvas.remove(zombie);
        }
    }

    public void eatPlant(Zombie zombie, Sunflower sunflower, Peashooter peashooter, Wallnut wallnut) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eatPlant'");
    }

        private Boolean damageZombieProjectile(Projectile projectile, Zombie zombie) {
        if (canvas.getElementAt(projectile.getPosition()) == canvas.getElementAt(zombie.getX(), zombie.getY() + zombie.getHeight() / 3)) {
            zombie.reduceHealth(projectile.getDamage());
            return true;
        }
        else return false;
    }

}
