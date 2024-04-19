package plant;

import edu.macalester.graphics.Point;

public interface Plant {

    void loadSprite();

    // void actionActivator();

    void action();

    int getSunCost();

    double getRechargeTime();

    // void receiveDamage();

    // void checkDeath();

    Point getPosition();

    void setPosition();

    void addToCanvas();
    
    void removeFromCanvas();
    
}