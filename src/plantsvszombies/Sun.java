package plantsvszombies;

import edu.macalester.graphics.*;

public class Sun {
    
    private final int SUN_VALUE = 25;

    private Image sunSprite;
    private GraphicsGroup sun;

    public Sun(double x, double y) {
        loadSprite();
        setCenter(x, y);
    }

    private void loadSprite() {
        sunSprite = new Image("\\game\\SUN.png");
        sun = new GraphicsGroup();
        sun.add(sunSprite);
    }

    public void setCenter(double x, double y) {
        sun.setCenter(x, y);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(sun);
    }

    public void clickSun(Player player, CanvasWindow canvas) {
        player.changeSunCount(SUN_VALUE);
        removeSun(canvas);
    }

    private void removeSun(CanvasWindow canvas){
        canvas.remove(sun);
    }
    
}
