package plantsvszombies;

import edu.macalester.graphics.*;

public class Shovel {
    private Image shovelSprite;
    private GraphicsGroup shovel;

    public Shovel(double x, double y) {
        loadSprite();
        setCenter(x, y);
    }

    int n = PvZ.getTime();

    private void loadSprite(){

    }

    public void setCenter(double x, double y) {
        shovel.setCenter(x, y);
    }
    
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(shovel);
    }
    
}
