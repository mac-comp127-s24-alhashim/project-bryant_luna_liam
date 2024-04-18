package plant;

import edu.macalester.graphics.*;

public interface Plant {

    // SUNFLOWER, PEASHOOTER, WALLNUT, POTATO MINE, CHERRY BOMB
    // HEALTH
    // STRING NAME
    // POSITION
    // 32x32
    // SUN COST
    
    public void drawPlant(String type, int health, Point position);
    public void action();
    public int getSunCost();
    public void removePlant();
    public void loadSprite();
    
}