package plantsvszombies;

import edu.macalester.graphics.*;

public class Sun extends GraphicsGroup{
    
    private final int SUN_VALUE = 25;
    private final int GRID_SIZE = 32;

    private CanvasWindow canvas;
    private Image sun;

    public Sun(double x, double y) {
        sun = new Image("game\\SUN.png");
        sun.setMaxWidth(GRID_SIZE);
        sun.setMaxHeight(GRID_SIZE);
        sun.setCenter(x, y);
    }

    // private void loadSprite(double x, double y) {
    //     Image sun = new Image("res\\game\\SUN.png");
    //     sun.setMaxHeight(GRID_SIZE);
    //     sun.setMaxWidth(GRID_SIZE);
    //     sunSprite = new GraphicsGroup();
    //     sunSprite.add(sun);
    //     canvas.add(sunSprite);
    //     setPosition(x, y);
    // }

    // private void setPosition(double x, double y) {
    //     sunSprite.setPosition(x, y);
    // }

    public void clickSun(Player player) {
        player.changeSunCount(SUN_VALUE);
        removeSun();
    }

    public void removeSun(){
        canvas.remove(sun);
    }
    
}
