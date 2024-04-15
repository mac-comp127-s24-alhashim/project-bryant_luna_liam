package plant;

import edu.macalester.graphics.*;

public interface Plant {

    // SUNFLOWER, PEASHOOTER, WALLNUT, POTATO MINE, CHERRY BOMB
    // HEALTH
        // Sunflower and Peashooter have a health of 6. Wallnut has health of 54, while Cherry Bomb and PotatoMine have health of 1,000
    // STRING NAME
    // POSITION
    // 32x32
    // SUN COST
    // SEED PACKET ICON "STRING" and IMAGE
    
   
    public void drawPlant(String type, int health, Point position);
    public void attack();
    public void removePlant();


    
}