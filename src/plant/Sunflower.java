package plant;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

public class Sunflower implements Plant {
    private int health;
    private GraphicsGroup sunflowerSprite;
    private static final int GRID_SIZE = 16;
    private static final int SUN_COST = 50; 


    public Sunflower() {
        this.health = 50; 
        loadSprite();
    }

    private void loadSprite(){
        Image sunflowerImage= new Image("PLANT_PLACEHOLDER.png");
        sunflowerImage.setMaxHeight(GRID_SIZE);
        sunflowerImage.setMaxWidth(GRID_SIZE);
        sunflowerSprite = new GraphicsGroup();
        sunflowerSprite.add(sunflowerImage);
    }
    public void drawPlant(String type, int health, Point position) {
        double x = position.getX() * GRID_SIZE;
        double y = position.getY() * GRID_SIZE;

        sunflowerSprite.setPosition(x, y);
        
        System.out.println("Drawing a Sunflower at position " + position);
    }

   
    public void attack() {
        
        System.out.println("Sunflower does not attack");
    }


    public void takeDamage() {
        
        health -= 10; 
        System.out.println("Sunflower takes damage, health is now " + health);
    }

    public int getSunCost() { 
        return SUN_COST;
    }
}
