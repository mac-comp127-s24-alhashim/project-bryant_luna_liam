package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Peashooter implements Plant{

    private static final String PEASHOOTER_SPRITE_PATH = "\\plants\\PLANT_PLACEHOLDER.png";
    public static final String PEASHOOTER_SEED_SPRITE_PATH = "\\game\\SEEDPACKET_PEASHOOTER.png";
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 100; 

    private int health;
    private GraphicsGroup peashooter;
    private CanvasWindow canvas;


    public Peashooter() {
        this.health = 6; 
        loadSprite();
    }

    public void loadSprite(){
        Image peashooterSprite= new Image(PEASHOOTER_SPRITE_PATH);
        peashooterSprite.setMaxHeight(GRID_SIZE);
        peashooterSprite.setMaxWidth(GRID_SIZE);
        peashooter = new GraphicsGroup();
        peashooter.add(peashooterSprite);
        canvas.add(peashooter);
    }

    public void drawPlant(String type, int health, Point position) {

        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        peashooter.setPosition(x, y);

        System.out.println("Drawing a Peashooter at position " + position);
    }

    public int getSunCost() { 
        return SUN_COST;
    }

    public void removePlant(){
        canvas.remove(peashooter);
    }
    public void action() {
        // Peashooter shoots peas, dealing 1 damage to zombies
        System.out.println("Peashooter shoots a pea, dealing 1 damage to zombies");
    }
}
