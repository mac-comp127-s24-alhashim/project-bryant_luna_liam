package plantsvszombies;

import edu.macalester.graphics.CanvasWindow;

import java.util.ArrayList;
import java.util.List;

public class Lawn {

    private CanvasWindow canvas;
    private List<GrassTile> lawn;

    public static final int MAX_COLUMNS = 10;
    public static final int MAX_ROWS = 5;
    public static final int START_Y = 64;

    public Lawn(CanvasWindow canvas) {
        lawn = new ArrayList<>();
        this.canvas = canvas;
    }

    public void generateLawn() {
        for (int i = 0; i < MAX_ROWS; i++) {
            int y = START_Y + (GrassTile.TILE_SIZE * i);
            for (int n = 0; n < MAX_COLUMNS; n++) {
                int x = ((GrassTile.TILE_SIZE * n));
                int tileNumber = (i + n);
                GrassTile grassTile = new GrassTile(x, y, tileNumber);
                createGrassTile(grassTile);
            }
        }
    }

    public void createGrassTile(GrassTile grassTile) {
        canvas.add(grassTile);
        lawn.add(grassTile);
    }
    
}
