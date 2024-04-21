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
public class UI extends GraphicsGroup{
    private final Color FONT_COLOR = new Color(41, 41, 41);
    private final CanvasWindow canvas;
    private Image background;
    private Image sunBox;
    private Image shovelBox;
    private GraphicsText sunText;
    private GraphicsText nameText;

    public UI(CanvasWindow canvas) {
        this.canvas = canvas;

        sunBox = new Image("game/SUNCOUNT.png");
        sunBox.setPosition(0, 0);
        add(sunBox);

        shovelBox = new Image("game/SHOVELBOX.png");
        shovelBox.setPosition(0, sunBox.getHeight());
        add(shovelBox);

        double shovelBoxCenterX = shovelBox.getX() + shovelBox.getWidth() / 2;
        double shovelBoxCenterY = shovelBox.getY() + shovelBox.getHeight() / 2;

        Image shovelSprite = new Image("game/SHOVEL.png");
        shovelSprite.setPosition(shovelBoxCenterX, shovelBoxCenterY);
        add(shovelSprite);

        // shovel = new Shovel(shovelBoxCenterX, shovelBoxCenterY);
        // shovel.addToCanvas(canvas);

        // for (int n = 0; n <= 4; n++) {
        //     SeedPacket seedPacket = new SeedPacket(n);
        //     int x = (int) (sunBox.getImageWidth() + (seedPacket.getWidth() * n));
        //     seedPacket.setPosition(x ,0);
        //     seedPacket.addToCanvas(canvas);
        // }

        sunText = new GraphicsText(String.valueOf(PvZ.getSunCount()));
        sunText.setFont(FontStyle.BOLD, 16);
        sunText.setFillColor(FONT_COLOR);
        sunText.setCenter(sunBox.getWidth() / 2, sunBox.getHeight() / 2);
        add(sunText);

        nameText = new GraphicsText(PvZ.getPlayerName() + "'s House");
        nameText.setFont(FontStyle.BOLD, 12);
        nameText.setFillColor(FONT_COLOR);
        nameText.setPosition(10, canvas.getHeight() * 0.9825);
        add(nameText);
    }
}
