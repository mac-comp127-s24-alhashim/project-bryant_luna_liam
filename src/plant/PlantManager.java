package plant;

import java.util.List;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;

/**
 * Manages the placement and logic of plants.
 */
public class PlantManager {
    List<Object> plants;
    List<String> plantTypes;
    CanvasWindow canvas;

    public PlantManager() {
        plants = new ArrayList<>();
    }

    public void runScheduledTasks() {
        for (Object plant : plants) {
            System.out.println("plant");
        }
    }

    public void addPlant(int type, Point position) {
        switch(type) {
            case 0:
                Sunflower sunflower = new Sunflower();
                plants.add(sunflower);
                canvas.add(sunflower);
            case 1:
                Peashooter peashooter = new Peashooter();
                plants.add(peashooter);
                canvas.add(peashooter);
            case 2:
                Wallnut wallnut= new Wallnut();
                plants.add(wallnut);
                canvas.add(wallnut);
            case 3:
                CherryBomb cherrybomb= new CherryBomb();
                plants.add(cherrybomb);
                canvas.add(cherrybomb)
            case 4:
                PotatoMine potatomine= new PotatoMine();
                plants.add(potatomine);
                canvas.add(potatomine)
            default:
                break;
        }
    }
}