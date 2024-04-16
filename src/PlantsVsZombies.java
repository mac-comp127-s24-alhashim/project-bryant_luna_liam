import edu.macalester.graphics.*;
import zombies.ZombieManager;

public class PlantsVsZombies {
    private static final int CANVAS_WIDTH = 320;
    private static final int CANVAS_HEIGHT = 240;
    
    private CanvasWindow canvas;
    private Image background;
    private Image sunBox;
    private Image seedPacket;
    private Lawn lawn;

    //private Sun sun;

public PlantsVsZombies() {
    canvas = new CanvasWindow("Plants vs. Zombies", CANVAS_WIDTH, CANVAS_HEIGHT);
    loadBackground();
    loadSunBox();
    loadSeedPacket();
    drawLawn();
    canvas.draw();

    // sun = new Sun(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2);
    // canvas.add(sun);
    }
    
public static void main(String[] args) {
    PlantsVsZombies plantsVsZombies = new PlantsVsZombies();
    ZombieManager zombieManager = new ZombieManager();
    //plantsVsZombies.run();    
    }

public void loadBackground() {
    background = new Image("\\game\\LAWN.png");
    background.setPosition(0, 0);
    canvas.add(background);

    }

public void loadSunBox() {
    sunBox = new Image("\\game\\SUNCOUNT.png");
    sunBox.setPosition(0, 0);
    canvas.add(sunBox);
    }

public void loadSeedPacket() {
    seedPacket = new Image("\\game\\SEEDPACKET_EMPTY.png");
    seedPacket.setPosition(sunBox.getImageWidth(),0);
    canvas.add(seedPacket);
    }

public void drawLawn() {
    lawn = new Lawn(canvas);
    lawn.generateLawn();
    }


}
