package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Peashooter implements Plant{
    private int health;
    private GraphicsGroup peashooterSprite;
    private static final int GRID_SIZE = 16;
    private static final int SUN_COST = 50; 


    public Peashooter() {
        this.health = 50; 
        loadSprite();
    }

    private void loadSprite(){
        Image peashooterImage= new Image("PLANT_PLACEHOLDER.png");
        peashooterImage.setMaxHeight(GRID_SIZE);
        peashooterImage.setMaxWidth(GRID_SIZE);
        peashooterSprite = new GraphicsGroup();
        peashooterSprite.add(peashooterImage);
    }

    public void drawPlant(String type, int health, Point position) {

        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        peashooterSprite.setPosition(x, y);

        System.out.println("Drawing a Peashooter at position " + position);
    }

    public void attack() {
        System.out.println("Peashooter attacks");
    }

    public void takeDamage() {
        health -= 10; 
        System.out.println("Peashooter  takes damage, health is now " + health);
    }

    public int getSunCost() { 
        return SUN_COST;
    }

    @Override
    public void removePlant() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePlant'");
    }
    
}
