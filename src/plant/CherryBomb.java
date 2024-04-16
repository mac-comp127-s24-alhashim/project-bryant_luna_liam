package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class CherryBomb implements Plant{
    
    private int health;
    private GraphicsGroup cherryBombSprite;
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 150; 
    private CanvasWindow canvas;


    public CherryBomb() {
        this.health = 1000; 
        loadSprite();
    }

    public void loadSprite(){
        Image cherryBomb= new Image("PLANT_PLACEHOLDER.png");
        cherryBomb.setMaxHeight(GRID_SIZE);
        cherryBomb.setMaxWidth(GRID_SIZE);
        cherryBombSprite = new GraphicsGroup();
        cherryBombSprite.add(cherryBomb);
        canvas.add(cherryBombSprite);
    }
    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        // Set the position of the sprite on the canvas
        cherryBombSprite.setPosition(x, y);
    
        System.out.println("Drawing a Cherry Bomb at position " + position);
    }

    public void action() {
        // Cherry Bomb explodes, dealing 300 damage to zombies
        System.out.println("Cherry Bomb explodes, dealing 300 damage to zombies");
    }

    public void removePlant(){
        canvas.remove(cherryBombSprite);
    }


    public int getSunCost() { 
        return SUN_COST;
    }
    
}
