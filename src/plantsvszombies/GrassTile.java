package plantsvszombies;

import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.GraphicsGroup;

import java.awt.Color;

/**
 * A grass tile.
 */
public class GrassTile extends GraphicsGroup {
    public final Color GRASS_COLOR_A = new Color(115, 236, 74);
    public final Color GRASS_COLOR_B = new Color(66, 189, 24);
    public final Color OUTLINE_COLOR = new Color(0, 129, 16);
    public static final int TILE_SIZE = 32;

    private Rectangle grassTile;

    /**
     * Constructs a grass tile
     */
    public GrassTile(int x, int y, int tileNumber) {
        grassTile = new Rectangle(x, y, TILE_SIZE, TILE_SIZE);
        if ((tileNumber % 2) == 0) {
            grassTile.setFillColor(GRASS_COLOR_A);
        } else {
            grassTile.setFillColor(GRASS_COLOR_B);
        }
        grassTile.setStrokeColor(OUTLINE_COLOR);
        add(grassTile);
    }
    /**
     * Returns a grass tile
     * @return
     */
    public Rectangle getGrassTile() {
        return grassTile;
    }
    
}
