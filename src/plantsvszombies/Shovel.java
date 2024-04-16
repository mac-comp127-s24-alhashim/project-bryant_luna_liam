package plantsvszombies;

import edu.macalester.graphics.*;

public class Shovel {
    
    // private CanvasWindow canvas;
    private Image shovelSprite;
    private GraphicsGroup shovel;

    public Shovel(double x, double y) {
        loadSprite();
        setCenter(x, y);
    }

    private void loadSprite(){
        shovelSprite = new Image("\\game\\SHOVEL.png");
        shovel = new GraphicsGroup();
        shovel.add(shovelSprite);
    }

    public void setCenter(double x, double y) {
        shovel.setCenter(x, y);
    }
    
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(shovel);
    }
    
}
