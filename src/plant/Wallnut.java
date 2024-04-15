package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Wallnut implements Plant{
    private int health;
    private GraphicsGroup wallnutSprite;
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 50; 
    private CanvasWindow canvas;


    public Wallnut() {
        this.health = 54; 
        loadSprite();
    }

    private void loadSprite(){
        Image wallnut= new Image("PLANT_PLACEHOLDER.png");
        wallnut.setMaxHeight(GRID_SIZE);
        wallnut.setMaxWidth(GRID_SIZE);
        wallnutSprite = new GraphicsGroup();
        wallnutSprite.add(wallnut);
        canvas.add(wallnutSprite);
    }
    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        wallnutSprite.setPosition(x, y);
        
        System.out.println("Drawing a Wallnut at position " + position);
    }

    public void attack() {
        System.out.println("Wallnut does not attack");
    }

    public void removePlant(){
        canvas.remove(wallnutSprite);
    }

    public int getSunCost() { 
        return SUN_COST;
    }
}
    

