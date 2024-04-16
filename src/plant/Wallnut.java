package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Wallnut implements Plant{

    private static final String WALLNUT_SPRITE_PATH = "\\plants\\PLANT_PLACEHOLDER.png";
    public static final String WALLNUT_SEED_SPRITE_PATH = "\\game\\SEEDPACKET_WALLNUT.png";
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 50; 

    private int health;
    private GraphicsGroup wallnut;
    private CanvasWindow canvas;

    public Wallnut() {
        this.health = 54; 
        loadSprite();
    }

    private void loadSprite(){
        Image wallnutSprite = new Image(WALLNUT_SPRITE_PATH);
        wallnutSprite.setMaxHeight(GRID_SIZE);
        wallnutSprite.setMaxWidth(GRID_SIZE);
        wallnut = new GraphicsGroup();
        wallnut.add(wallnutSprite);
        canvas.add(wallnut);
    }
    
    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        wallnut.setPosition(x, y);
        
        System.out.println("Drawing a Wallnut at position " + position);
    }
    
    public void removePlant(){
        canvas.remove(wallnut);
    }

    public int getSunCost() { 
        return SUN_COST;
    }

    @Override
    public void action() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'action'");
    }
}
    

