import edu.macalester.graphics.*;
import zombies.ZombieManager;

public class PlantsVsZombies {
    private static final int CANVAS_WIDTH = 320;
    private static final int CANVAS_HEIGHT = 240;
    
    private CanvasWindow canvas;
    private Image lawn;


public PlantsVsZombies() {
    canvas = new CanvasWindow("Plants vs. Zombies", CANVAS_WIDTH, CANVAS_HEIGHT);
    lawn = new Image("\\game\\LAWN.png");
    lawn.setPosition(0, 0);
    canvas.add(lawn);
    }
    
public static void main(String[] args) {
    PlantsVsZombies plantsVsZombies = new PlantsVsZombies();
    ZombieManager zombieManager = new ZombieManager();
    //plantsVsZombies.run();    
    }
}
