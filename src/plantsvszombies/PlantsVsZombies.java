package plantsvszombies;

import edu.macalester.graphics.*;

import java.awt.Font;

import zombies.ZombieManager;


public class PlantsVsZombies {
    private static final int CANVAS_WIDTH = 320;
    private static final int CANVAS_HEIGHT = 240;
    
    private CanvasWindow canvas;
    private Image background;
    private Image sunBox;
    private Image shovelBox;
    private Lawn lawn;
    private Sun sun;
    private Shovel shovel;

    private short sunCount = 0;
    private final short maxSun = 9999;

    public PlantsVsZombies() {
        canvas = new CanvasWindow("Plants vs. Zombies", CANVAS_WIDTH, CANVAS_HEIGHT);

        loadBackground();
        loadSunBox();
        loadSeedPacket();
        drawLawn();
        loadShovelAndBox();
        sun = new Sun(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2);
        sun.addToCanvas(canvas);

        canvas.draw();

        // sun = new Sun(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2);
        // canvas.add(sun);

    }
        
    public static void main(String[] args) {
        PlantsVsZombies plantsVsZombies = new PlantsVsZombies();
        ZombieManager zombieManager = new ZombieManager();
        //plantsVsZombies.run();    
    }

    private void loadBackground() {
        background = new Image("\\game\\LAWN.png");
        background.setPosition(0, 0);
        canvas.add(background);

    }

    private void loadSunBox() {
        sunBox = new Image("\\game\\SUNCOUNT.png");
        sunBox.setPosition(0, 0);
        canvas.add(sunBox);
    }

    private void loadShovelAndBox() {
        shovelBox = new Image("\\game\\SHOVELBOX.png");
        shovelBox.setPosition(0, sunBox.getHeight());
        canvas.add(shovelBox);

        double shovelBoxCenterX = shovelBox.getX() + shovelBox.getWidth() / 2;
        double shovelBoxCenterY = shovelBox.getY() + shovelBox.getHeight() / 2;

        shovel = new Shovel(shovelBoxCenterX, shovelBoxCenterY);
        shovel.addToCanvas(canvas);
    }

    private void loadSeedPacket() {
        for (int n = 0; n <= 4; n++) {
            SeedPacket seedPacket = new SeedPacket(n);
            int x = (int) (sunBox.getImageWidth() + (seedPacket.getWidth() * n));
            seedPacket.setPosition(x ,0);
            seedPacket.addToCanvas(canvas);
        }
    }

    private void drawLawn() {
        lawn = new Lawn(canvas);
        lawn.generateLawn();
    }


}
