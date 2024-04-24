package plant;

import edu.macalester.graphics.Point;

public interface Plant {

    void loadSprite();

    int getSunCost();

    double getRechargeTime();

    Point getPosition();

    void setPosition();

    void addToCanvas();
    
    void removeFromCanvas();

	void runScheduledTasks();
    
}