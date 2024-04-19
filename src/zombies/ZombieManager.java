package zombies;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import plantsvszombies.GrassTile;
import plantsvszombies.PlantsVsZombies;
import plantsvszombies.Sun;

/**
 * Handles the random spawning of zombies on the grid.
 */
public class ZombieManager {
    static int time;
    int spawnRate;
    ArrayList<Zombie> zombieList = new ArrayList<Zombie>();
    ArrayList<GrassTile> tileList = new ArrayList<GrassTile>();
    CanvasWindow canvas;

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    Runnable helloRunnable = () -> {
        time++;
        zombieSpawn();
        moveZombies();
    };

    ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
    
    public ZombieManager(CanvasWindow canvas) {
        time = 0;
        spawnRate = 20;
        this.canvas = canvas;
        tileList.add(10-1);
        tileList.add(20-1);
        tileList.add(30-1);
        tileList.add(40-1);
        tileList.add(50-1);
    }

    private void moveZombies() {
        for (Zombie zombie : zombieList) zombie.move();
    }

    public static int getTimeElapsed() {
        return time;
    }

    private void zombieSpawn() {
        Random random = new Random();
        if (time >= 10) {
            if ((time % spawnRate) == 0) {
                GrassTile chosenTile = tileList.get(random.nextInt((4 - 0) + 1) + 0);
                summonZombie();
            } 
        }
    }

    private void summonZombie(double x, double y) {
        ConeZombie zombie = new ConeZombie(64*3, 64 - 16);
        zombieList.add(zombie);
        canvas.add(zombie);
        canvas.draw();
    }
    
}
