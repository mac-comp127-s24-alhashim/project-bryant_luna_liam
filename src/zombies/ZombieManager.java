package zombies;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Handles the random spawning of zombies on the grid.
 */
public class ZombieManager {
    int time;
    int spawnRate;
    ArrayList<Zombie> zombieList = new ArrayList<Zombie>();

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    Runnable helloRunnable = () -> {
        time++;
        zombieSpawn();
    };

    ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
    
    public ZombieManager() {
        spawnRate = 60;
        System.out.println("Zombie Manager Initialized");
    }

    public int getTimeElapsed() {
        return time;
    }

    private void zombieSpawn() {
        if (time > 60) {
            
        }
    }

    private void summonZombie() {
        Zombie zombie = new Zombie();
    }
    
}
