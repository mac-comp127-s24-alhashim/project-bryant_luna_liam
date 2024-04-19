package plant;

import edu.macalester.graphics.*;
import zombies.ZombieManager;

public interface Plant {

    void loadSprite();

    void action();

    int getSunCost();

    double getRechargeTime();

    void receiveDamage();

    void addToCanvas(CanvasWindow canvas);
    
    void removeFromCanvas(CanvasWindow canvas);

    // SUNFLOWER, PEASHOOTER, WALLNUT, POTATO MINE, CHERRY BOMB
    // HEALTH
    // STRING NAME
    // POSITION
    // 32x32
    // SUN COST
    
}