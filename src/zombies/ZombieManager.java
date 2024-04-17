package zombies;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import edu.macalester.graphics.CanvasWindow;
import plantsvszombies.Sun;

/**
 * Handles the random spawning of zombies on the grid.
 */
public class ZombieManager {
    int time;
    int spawnRate;
    ArrayList<Zombie> zombieList = new ArrayList<Zombie>();
    ArrayList<Integer> tileList = new ArrayList<Integer>();
    CanvasWindow canvas;

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    Runnable helloRunnable = () -> {
        time++;
        zombieSpawn();
    };

    ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
    
    public ZombieManager(CanvasWindow canvas) {
        time = 0;
        spawnRate = 5;
        this.canvas = canvas;
        System.out.println("Zombie Manager Initialized");
    }

    public int getTimeElapsed() {
        return time;
    }

    private void zombieSpawn() {
        if (time >= 10) {
            System.out.println("java");
            System.out.println(time % spawnRate);
            if ((time % spawnRate) == 0) {
                summonZombie();
            } 
        }
    }

    private void summonZombie() {
        Zombie zombie = new Zombie(1, 1);
        zombieList.add(zombie);
        canvas.add(zombie);
        canvas.draw();
    }
    
}
