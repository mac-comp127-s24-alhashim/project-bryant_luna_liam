package zombies;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import edu.macalester.graphics.CanvasWindow;

/**
 * Handles the random spawning of zombies on the grid.
 */
public class ZombieManager {
    int time;
    int spawnRate;
    ArrayList<Zombie> zombieList = new ArrayList<Zombie>();
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
        System.out.println("creating zombie in zombiemanager");
        Zombie zombie = new Zombie(1, 1);
        System.out.println("adding zombie to zombielist");
        zombieList.add(zombie);
        System.out.println("added zombie to canvas");
        canvas.add(zombie);
        System.out.println("drawing zombie on canvas");
        canvas.draw();
    }
    
}
