package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Sunflower implements Plant {

    private static final String SUNFLOWER_SPRITE_PATH = "\\plants\\SUNFLOWER.png";
    public static final String SUNFLOWER_SEED_SPRITE_PATH = "\\game\\SEEDPACKET_SUNFLOWER.png";
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 50; 
    private static final int SUN_PRODUCTION_TIME = 24000;
    private static final int RECHARGE_TIME = 24000; 

    private int health;
    private GraphicsGroup sunflower;
    private CanvasWindow canvas;


    public Sunflower() {
        this.health = 6; 
        loadSprite();
    }

    public void loadSprite(){
        Image sunflowerSprite = new Image(SUNFLOWER_SPRITE_PATH);
        sunflowerSprite.setMaxHeight(GRID_SIZE);
        sunflowerSprite.setMaxWidth(GRID_SIZE);
        sunflower = new GraphicsGroup();
        sunflower.add(sunflowerSprite);
        canvas.add(sunflower);
    }

    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        sunflower.setPosition(x, y);
        canvas.draw();
        
        System.out.println("Drawing a Sunflower at position " + position);
    }

   
    public void action() {
        System.out.println("Sunflower does not attack");
    }


    public void removePlant() {
        canvas.remove(sunflower);   
    }

    public int getSunCost() { 
        return SUN_COST;
    }

    /// modify action so that it takes sunproduction time to produce
}
