package plant;

import edu.macalester.graphics.*;

public interface Plant {

    // SUNFLOWER, PEASHOOTER, WALLNUT, POTATO MINE, CHERRY BOMB
    // HEALTH
    // STRING NAME
    // POSITION
    // 16x16
    // SUN COST
    
    public void drawPlant(String type, int health, Point position);
    public void action();
    public int getSunCost();
 
    
}