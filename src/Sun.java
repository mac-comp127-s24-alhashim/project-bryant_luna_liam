import edu.macalester.graphics.*;

public class Sun {
    
    private Image sunSprite;
    private final int sunValue = 25;

    public Sun() {
        loadSprite();
    }

    private void loadSprite(){
        sunSprite = new Image("res\\game\\SUN.png");
    }
    
}
