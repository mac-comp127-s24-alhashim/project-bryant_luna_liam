package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class CherryBomb implements Plant {

    private static final String CHERRYBOMB_SPRITE_PATH = "\\plants\\PLANT_PLACEHOLDER.png";
    public static final String CHERRYBOMB_SEED_SPRITE_PATH = "\\game\\SEEDPACKET_CHERRYBOMB.png";
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 150;
    private static final int RECHARGE_TIME = 40000; 
    
    private int health;
    private GraphicsGroup cherryBomb;
    private CanvasWindow canvas;

    public CherryBomb() {
        this.health = 1000; 
        loadSprite();
    }

    public void loadSprite(){
        Image cherryBombSprite = new Image(CHERRYBOMB_SPRITE_PATH);
        cherryBombSprite.setMaxHeight(GRID_SIZE);
        cherryBombSprite.setMaxWidth(GRID_SIZE);
        cherryBomb = new GraphicsGroup();
        cherryBomb.add(cherryBombSprite);
        canvas.add(cherryBomb);
    }

    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        // Set the position of the sprite on the canvas
        cherryBomb.setPosition(x, y);
    
        System.out.println("Drawing a Cherry Bomb at position " + position);
    }

    public void action() {
        // Cherry Bomb explodes, dealing 300 damage to zombies
        System.out.println("Cherry Bomb explodes, dealing 300 damage to zombies");
    }

    public void removePlant(){
        canvas.remove(cherryBomb);
    }


    public int getSunCost() { 
        return SUN_COST;
    }
}
