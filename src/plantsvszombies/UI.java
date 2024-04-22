package plantsvszombies;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

/**
 * Handles the UI elements in the game.
 */
public class UI extends GraphicsGroup {

    private final Color FONT_COLOR = new Color(41, 41, 41);
    private final CanvasWindow canvas;
    private Image sunBox;
    private Image shovelBox;
    static Image shovelSprite;
    private GraphicsText sunText;
    private GraphicsText nameText;

    public UI(CanvasWindow canvas) {
        this.canvas = canvas;
        loadSunBox();
        loadShovelAndBox();
        //loadSeedPackets();
        loadSunText();
        loadNameText();
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
        double shovelXMargin = (shovelBox.getWidth() - shovelSprite.getWidth()) / 2;
        double shovelYMargin = (shovelBox.getHeight() - shovelSprite.getHeight()) / 2;
        shovelSprite.setPosition(shovelBox.getX() + shovelXMargin, shovelBox.getY() + shovelYMargin);
        add(shovelSprite);
    }

    // /**
    //  * Loads the seed packets displaying each plant.
    //  */
    // private void loadSeedPackets() {  
    //     for (int n = 0; n <= 4; n++) {
    //         SeedPacket seedPacket = new SeedPacket(canvas, n);
    //         int x = (int) (sunBox.getImageWidth() + (seedPacket.getWidth() * n));
    //         seedPacket.setPosition(x ,0);
    //         seedPacket.addToCanvas();
    //     }      
    // }

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
    }
}
