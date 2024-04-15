package plant;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Peashooter implements Plant{
    private int health;
    private GraphicsGroup peashooterSprite;
    private static final int GRID_SIZE = 32;
    private static final int SUN_COST = 50; 
    private CanvasWindow canvas;


    public Peashooter() {
        this.health = 6; 
        loadSprite();
    }

    private void loadSprite(){
        Image peashooterImage= new Image("PLANT_PLACEHOLDER.png");
        peashooterImage.setMaxHeight(GRID_SIZE);
        peashooterImage.setMaxWidth(GRID_SIZE);
        peashooterSprite = new GraphicsGroup();
        peashooterSprite.add(peashooterImage);
        canvas.add(peashooterSprite);
    }

    public void drawPlant(String type, int health, Point position) {

        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        peashooterSprite.setPosition(x, y);

        System.out.println("Drawing a Peashooter at position " + position);
    }

    public int getSunCost() { 
        return SUN_COST;
    }

    public void removePlant(){
        canvas.remove(peashooterSprite);
    }
    public void attack() {
        // Peashooter shoots peas, dealing 1 damage to zombies
        System.out.println("Peashooter shoots a pea, dealing 1 damage to zombies");
    }
    
}
