package plantsvszombies;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the creation of the lawn and manages the grass tiles on the lawn.
 */
public class Lawn {
    private CanvasWindow canvas;
    private static List<GrassTile> tileList;

    // Part of a quick and dirty fix, see below
    private static List<Point> pointList;

    public static final int MAX_COLUMNS = 10;
    public static final int MAX_ROWS = 5;
    public static final int START_Y = 64;

    public Lawn(CanvasWindow canvas) {
        tileList = new ArrayList<GrassTile>();
        pointList = new ArrayList<Point>();
        this.canvas = canvas;
        generateLawn();
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
     * Get a specific grass tile's position on the canvas.
     * @param id Number of grass tile, going from left to right, 0 to 39.
     * @return
     */
    public static Point getGrassTilePosition(int n) {
        return pointList.get(n);
    }

    private void generateLawn() {
        for (int i = 0; i < MAX_ROWS; i++) {
            int y = START_Y + (GrassTile.TILE_SIZE * i);
            for (int n = 0; n < MAX_COLUMNS; n++) {
                int x = ((GrassTile.TILE_SIZE * n));
                int tileNumber = (i + n);
                GrassTile grassTile = new GrassTile(x, y, tileNumber);
                tileList.add(grassTile);
                canvas.add(grassTile);

                // This is a quick and dirty fix for not being able to
                // get the position of a grass tile on the screen, for some reason
                Point tilePosition = new Point(x, y);
                pointList.add(tilePosition);
            }
        }
    }
}
