package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class CherryBomb implements Plant{
    
    private int health;
    private GraphicsGroup cherryBombSprite;
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 150; 


    public CherryBomb() {
        this.health = 1000; 
        loadSprite();
    }

    private void loadSprite(){
        Image cherryBomb= new Image("PLANT_PLACEHOLDER.png");
        cherryBomb.setMaxHeight(GRID_SIZE);
        cherryBomb.setMaxWidth(GRID_SIZE);
        cherryBombSprite = new GraphicsGroup();
        cherryBombSprite.add(cherryBomb);
    }
    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        // Set the position of the sprite on the canvas
        cherryBombSprite.setPosition(x, y);
    
        System.out.println("Drawing a Cherry Bomb at position " + position);
    }

    public void attack() {
       
        System.out.println("Cherry Bomb explodes");
    }

    public int getSunCost() { 
        return SUN_COST;
    }
    
}
