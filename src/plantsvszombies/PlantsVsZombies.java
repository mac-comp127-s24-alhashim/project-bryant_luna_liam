package plantsvszombies;

import edu.macalester.graphics.*;

import java.awt.Color;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

import zombies.ZombieManager;
import plant.*;

public class PlantsVsZombies {
    public static final int CANVAS_WIDTH = 320;
    public static final int CANVAS_HEIGHT = 240;
    //private final short maxSun = 9999;
    private final Color FONT_COLOR = new Color(41, 41, 41);
    
    private static CanvasWindow canvas;
    private Player player;
    private String playerName;
    private Image background;
    private Image sunBox;
    private Image shovelBox;
    private Lawn lawn;
    private Sun sun;
    private Shovel shovel;
    private GraphicsText sunText;
    private GraphicsText nameText;
    private Sunflower sunflower;

    //private short sunCount;

    public PlantsVsZombies() {
        canvas = new CanvasWindow("Plants vs. Zombies: Java Edition", CANVAS_WIDTH, CANVAS_HEIGHT);
        player = new Player("Bryant", (short) 0);
        sunflower = new Sunflower(canvas);
        loadBackground();
        loadSunBox();
        initializeSun();
        loadSeedPacket();
        drawLawn();
        loadShovelAndBox();
        loadPlayerName();
        sunflower.drawPlant("Sunflower", 6, lawn.getGrassTile(3).getPosition());
        sunflower.addToCanvas(canvas);
        sun = new Sun(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2);
        sun.addToCanvas(canvas);
        canvas.performEventAction(() -> 
            spawnSun());

       // canvas.draw();
    }

    public static void main(String[] args) {
        PlantsVsZombies plantsVsZombies = new PlantsVsZombies();
        ZombieManager zombieManager = new ZombieManager(canvas);
        //plantsVsZombies.run();    
    }

    private void spawnSun() {
        System.out.println("BAZINGA!");
    }

    private void loadBackground() {
        background = new Image("game/LAWN.png");
        background.setPosition(0, 0);
        canvas.add(background);

    }

    private void loadSunBox() {
        sunBox = new Image("game/SUNCOUNT.png");
        sunBox.setPosition(0, 0);
        canvas.add(sunBox);
    }

    private void loadShovelAndBox() {
        shovelBox = new Image("game/SHOVELBOX.png");
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

    private void initializeSun() {
        sunText = new GraphicsText(String.valueOf(player.getSunCount()));
        sunText.setFont(FontStyle.BOLD, 16);
        sunText.setFillColor(FONT_COLOR);
        sunText.setCenter(sunBox.getWidth() / 2, sunBox.getHeight() / 2);
        canvas.add(sunText);
    }

    private void loadPlayerName() {
        nameText = new GraphicsText(player.getName() + "'s House");
        nameText.setFont(FontStyle.BOLD, 12);
        nameText.setFillColor(FONT_COLOR);
        //nameText.setPosition(shovelBox.getWidth() + 12, shovelBox.getY() + (shovelBox.getHeight() / 2) + 4);
        nameText.setPosition(10, CANVAS_HEIGHT * 0.9825);
        canvas.add(nameText);
    }
}
