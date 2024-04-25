package plant;

import java.util.List;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import plantsvszombies.PvZ;

/**
 * Manages the placement and logic of plants. Handles projectiles and explosions
 * created by plants.
 */
public class PlantManager {
    CanvasWindow canvas;
    List<Object> plants;
    List<String> plantTypes;

    public PlantManager(CanvasWindow cv) {
        canvas = cv;
        plants = new ArrayList<>();
    }

    // public void runScheduledTasks() {
    //     for (Object plant : plants) {
    //         System.out.println("plant");
    //     }
    // }

    public void addPlant(int type, Point position) {
        switch(type) {
            case 0:
                Sunflower sunflower = new Sunflower();
                sunflower.setPosition(position);
                plants.add(sunflower);
                canvas.add(sunflower);
                break;
            case 1:
                Peashooter peashooter = new Peashooter();
                peashooter.setPosition(position);
                plants.add(peashooter);
                canvas.add(peashooter);
                break;
            case 2:
                Wallnut wallnut= new Wallnut();
                wallnut.setPosition(position);
                plants.add(wallnut);
                canvas.add(wallnut);
                break;
            case 3:
                PotatoMine potatomine= new PotatoMine();
                potatomine.setPosition(position);
                plants.add(potatomine);
                canvas.add(potatomine);
                break;
            case 4:
                CherryBomb cherrybomb= new CherryBomb();
                cherrybomb.setPosition(position);
                plants.add(cherrybomb);
                canvas.add(cherrybomb);
                break;
            default:
                break;
        }
    }
}