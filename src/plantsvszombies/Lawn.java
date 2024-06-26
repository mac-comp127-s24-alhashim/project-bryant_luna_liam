package plantsvszombies;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the creation of the lawn and manages the grass tiles on the lawn.
 */
public class Lawn {
    
    private CanvasWindow canvas;
    private static List<GrassTile> tileList;
    private static List<Point> pointList;
    private static GraphicsGroup grassTiles;

    public static final int MAX_COLUMNS = 10;
    public static final int MAX_ROWS = 5;
    public static final int START_Y = 64;

    public Lawn(CanvasWindow canvas) {
        tileList = new ArrayList<GrassTile>();
        pointList = new ArrayList<Point>();
        grassTiles = new GraphicsGroup();
        this.canvas = canvas;
    }

    /**
     * Get a specific grass tile on the canvas.
     * @param id Number of grass tile, going from left to right, 0 to 39.
     * @return
     */
    public static GrassTile getGrassTile(int n) {
        return tileList.get(n);
    }

    /**
     * Get the position to be used when a plant is placed on a grass tile.
     * If a tile is not found, returns null.
     * @param n
     * @return
     */
    public static Point getPlantPoint(Point point) {
        GraphicsObject tile = grassTiles.getElementAt(point);
        if (tile == null) return null;
        Point plantPoint = tile.getPosition();
        return plantPoint;
    }

    /**
     * Get a specific grass tile's position on the canvas.
     * @param id Number of grass tile, going from left to right, 0 to 39.
     * @return
     */
    public static Point getGrassTilePosition(int n) {
        return pointList.get(n);
    }

    /**
     * Generates the lawn and adds it to the given canvas.
     */
    public void generateLawn() {
        for (int i = 0; i < MAX_ROWS; i++) {
            int y = START_Y + (GrassTile.TILE_SIZE * i);
            for (int n = 0; n < MAX_COLUMNS; n++) {
                int x = ((GrassTile.TILE_SIZE * n));
                int tileNumber = (i + n);
                GrassTile grassTile = new GrassTile(x, y, tileNumber);
                tileList.add(grassTile);
                grassTiles.add(grassTile);
                Point tilePosition = new Point(x, y);
                pointList.add(tilePosition);
            }
        }
        canvas.add(grassTiles);
    }
}
