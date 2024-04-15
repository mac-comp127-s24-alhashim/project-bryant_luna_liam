package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Sunflower implements Plant {
    private int health;
    private GraphicsGroup sunflowerSprite;
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 50; 
    private CanvasWindow canvas;


    public Sunflower() {
        this.health = 6; 
        loadSprite();
    }

    private void loadSprite(){
        Image sunflowerImage = new Image("PLANT_PLACEHOLDER.png");
        sunflowerImage.setMaxHeight(GRID_SIZE);
        sunflowerImage.setMaxWidth(GRID_SIZE);
        sunflowerSprite = new GraphicsGroup();
        sunflowerSprite.add(sunflowerImage);
        canvas.add(sunflowerSprite);
    }
    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        sunflowerSprite.setPosition(x, y);
        canvas.draw();
        
        System.out.println("Drawing a Sunflower at position " + position);
    }

   
    public void attack() {
        
        System.out.println("Sunflower does not attack");
    }


    public void removePlant() {
        canvas.remove(sunflowerSprite);
        
    }

    public int getSunCost() { 
        return SUN_COST;
    }
}
