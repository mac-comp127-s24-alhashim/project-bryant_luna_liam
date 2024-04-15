import edu.macalester.graphics.*;

public class Sun {
    
    private final int sunValue = 25;
    private final int GRID_SIZE = 32;

    private CanvasWindow canvas;
    private GraphicsGroup sunSprite;


    public Sun() {
        loadSprite();
    }

    private void loadSprite(){
        Image sun = new Image("res\\game\\SUN.png");
        sun.setMaxHeight(GRID_SIZE);
        sun.setMaxWidth(GRID_SIZE);
        sunSprite = new GraphicsGroup();
        sunSprite.add(sun);
        canvas.add(sunSprite);
    }

    public void removeSun(){
        canvas.remove(sunSprite);
    }
    
}
