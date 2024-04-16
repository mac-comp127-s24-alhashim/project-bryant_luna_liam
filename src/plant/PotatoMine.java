package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class PotatoMine implements Plant {
    private int health;
    private GraphicsGroup potatoMine;
    private static final String POTATOMINE_SPRITE_PATH = "\\plants\\POTATOMINE.png";
    private static final String POTATOMINE_BURIED_SPRITE_PATH = "\\plants\\POTATOMINE_BURIED.png";
    public static final String POTATOMINE_SEED_SPRITE_PATH = "\\game\\SEEDPACKET_POTATOMINE.png";
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 25; 
    private CanvasWindow canvas;
    private boolean potatoMineBuried = true;


    public PotatoMine() {
        this.health = 1000; 
        loadSprite();
    }

    public void loadSprite(){
        Image PotatoMineSprite = new Image(POTATOMINE_BURIED_SPRITE_PATH);
        PotatoMineSprite.setMaxHeight(GRID_SIZE);
        PotatoMineSprite.setMaxWidth(GRID_SIZE);
        potatoMine = new GraphicsGroup();
        potatoMine.add(PotatoMineSprite);
        canvas.add(potatoMine);
    }

    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        // Set the position of the sprite on the canvas
        potatoMine.setPosition(x, y);
       
        System.out.println("Drawing a Potato Mine at position " + position);
    }

    public void action() {
        // Potato Mine explodes, dealing 300 damage to zombies
        System.out.println("Potato Mine explodes, dealing 300 damage to zombies");
    }

    public void removePlant(){
        canvas.remove(potatoMine);
    }

    public int getSunCost() { 
        return SUN_COST;
    }

    
}
