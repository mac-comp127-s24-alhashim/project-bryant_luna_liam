package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class PotatoMine implements Plant {
    private int health;
    private GraphicsGroup potatoMineSprite;
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 25; 
    private CanvasWindow canvas;


    public PotatoMine() {
        this.health = 1000; 
        loadSprite();
    }

    public void loadSprite(){
        Image PotatoMine = new Image("PLANT_PLACEHOLDER.png");
        PotatoMine.setMaxHeight(GRID_SIZE);
        PotatoMine.setMaxWidth(GRID_SIZE);
        potatoMineSprite = new GraphicsGroup();
        potatoMineSprite.add(PotatoMine);
        canvas.add(potatoMineSprite);
    }

    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        // Set the position of the sprite on the canvas
        potatoMineSprite.setPosition(x, y);
       
        System.out.println("Drawing a Potato Mine at position " + position);
    }

    public void action() {
        // Potato Mine explodes, dealing 300 damage to zombies
        System.out.println("Potato Mine explodes, dealing 300 damage to zombies");
    }

    public void removePlant(){
        canvas.remove(potatoMineSprite);
    }

    public int getSunCost() { 
        return SUN_COST;
    }

    
}
