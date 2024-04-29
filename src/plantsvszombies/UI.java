package plantsvszombies;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plant.CherryBomb;
import plant.Peashooter;
import plant.PotatoMine;
import plant.Sunflower;
import plant.Wallnut;

/**
 * Handles the UI elements in the game.
 */
public class UI extends GraphicsGroup {

    private final Color FONT_COLOR = new Color(41, 41, 41);
    private final CanvasWindow canvas;
    static boolean objInMotion = false;
    public static boolean shovelMode = false;
    private static GraphicsObject currentObjInMotion;

    // Background UI elements
    static Image sunBox;
    static Image shovelBox;
    private static GraphicsText sunText;
    private GraphicsText nameText;

    // Movable objects and their default locations
    static Image shovelSprite;
    static Image sunflowerPacket;
    static Image peashooterPacket;
    static Image wallnutPacket;
    static Image potatoMinePacket;
    static Image cherryBombPacket;
    static List<Image> seedPackets = new ArrayList<Image>();

    public UI(CanvasWindow canvas) {
        this.canvas = canvas;
        loadSunBox();
        loadShovelAndBox();
        loadSunText();
        loadNameText();
        loadSeedPackets();

        canvas.onMouseMove(handler -> {
            if (objInMotion) {
                currentObjInMotion.setCenter(handler.getPosition());
            }
        });
    }

    /**
     * Loads the box containing the sun text.
     */
    private void loadSunBox() {
        sunBox = new Image("game/SUNCOUNT.png");
        sunBox.setPosition(0, 0);
        add(sunBox);
    }

    /**
     * Loads the shovel and its box containing it.
     */
    private void loadShovelAndBox() {
        shovelBox = new Image("game/SHOVELBOX.png");
        shovelBox.setPosition(0, sunBox.getHeight());
        add(shovelBox);

        shovelSprite = new Image("game/SHOVEL.png");
        centerButtons();
        add(shovelSprite);
    }

    /**
     * Loads the sun counter.
     */
    private void loadSunText() {
        sunText = new GraphicsText(String.valueOf(PvZ.sunCount));
        sunText.setFont(FontStyle.BOLD, 16);
        sunText.setFillColor(FONT_COLOR);
        sunText.setCenter(sunBox.getWidth() / 2, sunBox.getHeight() / 2);
        add(sunText);
    }

    /**
     * Loads the name text.
     */
    private void loadNameText() {
        nameText = new GraphicsText(PvZ.getPlayerName() + "'s House");
        nameText.setFont(FontStyle.BOLD, 12);
        nameText.setFillColor(FONT_COLOR);
        nameText.setPosition(10, canvas.getHeight() * 0.9825);
        add(nameText);
    }

    /**
     * Updates the UI text.
     */
    public void update() {
        sunText.setText(String.valueOf(PvZ.sunCount));
        sunText.setCenter(sunBox.getWidth() / 2, sunBox.getHeight() / 2);
    }

    /**
     * Centers buttons.
     */
    public static void centerButtons() {
        double shovelXMargin = (shovelBox.getWidth() - shovelSprite.getWidth()) / 2;
        double shovelYMargin = (shovelBox.getHeight() - shovelSprite.getHeight()) / 2;
        shovelSprite.setPosition(shovelBox.getX() + shovelXMargin, shovelBox.getY() + shovelYMargin);

        int n = 0;
        for (Image seedPacket : seedPackets) {
            int x = (int) (64 + (seedPacket.getWidth() * n));
            seedPacket.setPosition(x ,0);
            n++;
        }
    }
    
    /**
     * Makes the specified object follow the mouse.
     * @param object Must be a graphicsobject displayed by the UI.
     * @param isFollowing
     */
    public static void followMouse(GraphicsObject object, boolean isMoving) {
        currentObjInMotion = object;
        objInMotion = isMoving;
    }

    /**
     * Loads the seed packets displaying each plant.
     */
    private void loadSeedPackets() {  
        sunflowerPacket = new Image(Sunflower.SEED_SPRITE_PATH);
        peashooterPacket = new Image(Peashooter.SEED_SPRITE_PATH);
        wallnutPacket = new Image(Wallnut.SEED_SPRITE_PATH);
        potatoMinePacket = new Image(PotatoMine.SEED_SPRITE_PATH);
        cherryBombPacket = new Image(CherryBomb.CHERRYBOMB_SEED_SPRITE_PATH);

        seedPackets.add(sunflowerPacket);
        seedPackets.add(peashooterPacket);
        seedPackets.add(wallnutPacket);
        seedPackets.add(potatoMinePacket);
        seedPackets.add(cherryBombPacket);

        int n = 0;
        for (Image seedPacket : seedPackets) {
            int x = (int) (64 + (seedPacket.getWidth() * n));
            seedPacket.setPosition(x ,0);
            add(seedPacket);
            n++;
        }
    }
}
